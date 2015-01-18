package sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Currency;
import model.CurrencySet;

public class CurrencySetLoader implements persistence.CurrencySetLoader {

    private static final int CODE = 1;
    private static final int NAME = 2;
    private static final int SYMBOL = 3;
    private final Connection connection;

    public CurrencySetLoader() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlite:moneycalculator.db");
    }

    public CurrencySetLoader(String databaseFileName) throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlite:" + databaseFileName);
    }
    
    @Override
    public CurrencySet load() {
        try {
            return proccessCurrencySet(connection.createStatement().executeQuery("SELECT * FROM Currency"));
        } catch (SQLException e) {
            return new CurrencySet();
        }
    }
    
    private CurrencySet proccessCurrencySet(ResultSet resultSet) throws SQLException {
       CurrencySet currencySet = new CurrencySet();
        while (resultSet.next()) {
            currencySet.add(proccessCurrency(resultSet));
        }
        return currencySet;
    }
    
    private Currency proccessCurrency(ResultSet resultSet) throws SQLException {
        return new Currency(resultSet.getString(CODE),
                resultSet.getString(NAME), 
                resultSet.getString(SYMBOL));
    }
    
}
