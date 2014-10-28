package control;

import model.Exchange;
import model.ExchangeRate;
import model.Money;
import ui.MoneyDisplay;

public class ExchangeOperation {
    
    public void execute(){
        Exchange exchange = readExchange();
        ExchangeRate exchangeRate = loadExchangeRate(exchange.getAmount());
        Money money = calculate(exchange.getAmount(), exchangeRate);
        show(money);
    }

    private Exchange readExchange() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private ExchangeRate loadExchangeRate(Money amount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Money calculate(Money amount, ExchangeRate exchangeRate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void show(Money money) {
        new MoneyDisplay(money);
    }
    
}
