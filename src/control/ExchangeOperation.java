package control;

import java.sql.SQLException;
import mock.ExchangeRateLoader;
import model.Currency;
import model.Exchange;
import model.ExchangeRate;
import model.Money;
import process.Exchanger;
import ui.ExchangeDialog;
import ui.MoneyDisplay;

public class ExchangeOperation {
    
    private final MoneyDisplay moneyDisplay;
    private final ExchangeDialog exchangeDialog;

    public ExchangeOperation(MoneyDisplay moneyDisplay, ExchangeDialog exchangeDialog) {
        this.moneyDisplay = moneyDisplay;
        this.exchangeDialog = exchangeDialog;
    }
    
    public void execute() throws SQLException{
        Exchange exchange = readExchange();
        ExchangeRate exchangeRate = readExchangeRate(getInCurrency(exchange), getOutCurrency(exchange));
        Money money = calculate(exchange.getMoney(), exchangeRate);
        show(money);
    }
    
    private Currency getInCurrency(Exchange exchange){
        return exchange.getMoney().getCurrency();
    }
    
    private Currency getOutCurrency(Exchange exchange){
        return exchange.getCurrency();
    }
    
    
    private Exchange readExchange() {
        return exchangeDialog.getExchange();
    }

    private Money calculate(Money amount, ExchangeRate exchangeRate) {
        return new Exchanger(exchangeRate, amount).exchange();
    }

    private void show(Money money) {
        moneyDisplay.show(money);
    }

    private ExchangeRate readExchangeRate(Currency in, Currency out) throws SQLException {
        return new ExchangeRateLoader().load(in,out);
    }
    
}
