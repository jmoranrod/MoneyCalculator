package application;

import control.ExchangeOperation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import model.CurrencySet;
import sqlite.CurrencySetLoader;
import swing.MoneyCalculatorFrame;

public class Application {
    
    public static void main(String[] args) throws SQLException {
        final CurrencySet currencySet = new CurrencySetLoader().load();
        final MoneyCalculatorFrame frame = new MoneyCalculatorFrame(currencySet);
        frame.register("Calculate", new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new ExchangeOperation(frame.getMoneyDisplayLabel(), frame.getExchangeDialog()).execute();
                } catch (SQLException ex) {
                }
            }
        });
    }
    
}
