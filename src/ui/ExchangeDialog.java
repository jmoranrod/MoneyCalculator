package ui;

import model.CurrencySet;
import model.Exchange;
import model.Money;

public class ExchangeDialog {
    
    private final CurrencySet currencySet;
    private Exchange exchange;
    
    public ExchangeDialog(CurrencySet currencySet) {
        this.currencySet = currencySet;
        //this.exchange = new Exchange(null, null);
    }
    
    public void execute(){
        this.exchange = new Exchange(new Money(exchange.getMoney().getAmount(), 
                currencySet.get("EUR")), 
                currencySet.get(exchange.getCurrency().getCode()));
    }

    public Exchange getExchange() {
        return exchange;
    }

    public CurrencySet getCurrencySet() {
        return currencySet;
    }
    
    
    
}
