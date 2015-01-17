/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import javax.swing.JLabel;
import model.Money;
import ui.MoneyDisplay;

/**
 *
 * @author Javivi
 */
public class MoneyDisplayLabel extends JLabel implements MoneyDisplay {

    @Override
    public void show(Money money) {
        super.setText("Result: "+ writeResult(money));
    }

    private String writeResult(Money money) {
        if (money.getAmount() == 0) return null;
        return (money.getAmount() + " " + money.getCurrency().getCode());
    }
    
}
