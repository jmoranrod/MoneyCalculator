package ui;

import javax.swing.JComboBox;
import javax.swing.JPanel;

public class CurrencyDialog extends JPanel {

    public CurrencyDialog() {
        super();
        add(createComboBox());
    }

    private JComboBox createComboBox() {
        //Mock, load from BD.
        return new JComboBox(new String[] {"EUR", "USD", "GBP"});
    }
    
}
