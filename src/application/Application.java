package application;

import control.ExchangeOperation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mock.CurrencySetLoader;
import model.CurrencySet;
import swing.MoneyCalculatorFrame;

public class Application {
    
    public static void main(String[] args) {
        final CurrencySet currencySet = new CurrencySetLoader().load();
        final MoneyCalculatorFrame frame = new MoneyCalculatorFrame(currencySet);
        frame.register("Calculate", new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new ExchangeOperation(frame.getMoneyDisplayLabel(), frame.getExchangeDialog()).execute();
            }
        });
    }
    
}
