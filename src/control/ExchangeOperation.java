package control;

import Persistence.CurrencySetLoader;
import model.CurrencySet;
import model.Exchange;
import model.ExchangeRate;
import model.Money;
import persistence.ExchangeRateLoader;
import ui.ExchangeDialog;
import ui.MoneyDisplay;

public class ExchangeOperation {
    
    private CurrencySet currencySet;

    public ExchangeOperation(CurrencySet currencySet) {
        this.currencySet = currencySet;
    }
    
    public void execute(){
        Exchange exchange = readExchange();
        ExchangeRate exchangeRate = readExchangeRate();
        Money money = calculate(exchange.getAmount(), exchangeRate);
        show(money);
    }

    private Exchange readExchange() {
        ExchangeDialog dialog = new ExchangeDialog();
        dialog.execute();
        return dialog.getExchange();
    }

    private Money calculate(Money amount, ExchangeRate exchangeRate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void show(Money money) {
        new MoneyDisplay(money);
    }

    private ExchangeRate readExchangeRate() {
        return new ExchangeRateLoader().load();
    }
    
}
