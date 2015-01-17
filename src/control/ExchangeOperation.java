package control;

import mock.ExchangeRateLoader;
import model.Currency;
import model.Exchange;
import model.ExchangeRate;
import model.Money;
import process.Exchanger;
import swing.MoneyDisplayLabel;
import ui.ExchangeDialog;

public class ExchangeOperation {
    
    private final MoneyDisplayLabel moneyDisplayLabel;
    private final ExchangeDialog exchangeDialog;

    public ExchangeOperation(MoneyDisplayLabel moneyDisplayLabel, ExchangeDialog exchangeDialog) {
        this.moneyDisplayLabel = moneyDisplayLabel;
        this.exchangeDialog = exchangeDialog;
    }
    
    public void execute(){
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
        moneyDisplayLabel.show(money);
    }

    private ExchangeRate readExchangeRate(Currency in, Currency out) {
        return new ExchangeRateLoader().load(in,out);
    }
    
}
