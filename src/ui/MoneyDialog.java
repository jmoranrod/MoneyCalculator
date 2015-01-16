package ui;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class MoneyDialog extends JPanel {

    public MoneyDialog() {
        super();
        add(createTextField());
        add(new CurrencyDialog());
    }

    private JTextField createTextField() {
        return new JTextField(10);
    }
    
}
