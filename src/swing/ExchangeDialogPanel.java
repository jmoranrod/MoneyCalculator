package swing;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Currency;
import model.CurrencySet;
import model.Exchange;
import ui.ExchangeDialog;

public class ExchangeDialogPanel extends JPanel implements ExchangeDialog {
    private CurrencySet currencySet;
    private JTextField amount;
    private JComboBox<Currency> inputCurrency;
    private JComboBox<Currency> outputCurrency;

    public ExchangeDialogPanel(CurrencySet currencySet) {
        this.currencySet = currencySet;
    }
    
    
    
    @Override
    public Exchange getExchange() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
