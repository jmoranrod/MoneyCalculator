package ui;

import model.CurrencySet;
import model.Exchange;

public class ExchangeDialog {
    
    private final Exchange exchange;
    private final CurrencySet currencySet;
    
    public ExchangeDialog(Exchange exchange, CurrencySet currencySet) {
        this.exchange = exchange;
        this.currencySet = currencySet;
    }
    
    public void execute(){
        
    }

    public Exchange getExchange() {
        return exchange;
    }

    public CurrencySet getCurrencySet() {
        return currencySet;
    }
    
    
    
}
