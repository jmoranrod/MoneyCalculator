package control;

import mock.ExchangeRateLoader;
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
        ExchangeRate exchangeRate = readExchangeRate();
        Money money = calculate(exchange.getMoney(), exchangeRate);
        show(money);
    }

    private Exchange readExchange() {
        return exchangeDialog.getExchange();
    }

    private Money calculate(Money amount, ExchangeRate exchangeRate) {
        return new Exchanger(exchangeRate, amount).exchange();
    }

    private void show(Money money) {
        new MoneyDisplayLabel().show(money);
    }

    private ExchangeRate readExchangeRate() {
        return new ExchangeRateLoader().load();
    }
    
}
