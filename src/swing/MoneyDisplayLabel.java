package swing;

import javax.swing.JLabel;
import model.Money;
import ui.MoneyDisplay;

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
