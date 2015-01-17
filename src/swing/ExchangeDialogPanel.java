package swing;

import java.awt.FlowLayout;
import static java.awt.FlowLayout.LEFT;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Currency;
import model.CurrencySet;
import model.Exchange;
import model.Money;
import ui.ExchangeDialog;

public class ExchangeDialogPanel extends JPanel implements ExchangeDialog {
    private final CurrencySet currencySet;
    private JTextField amount;
    private JComboBox<Currency> inputCurrency;
    private JComboBox<Currency> outputCurrency;

    public ExchangeDialogPanel(CurrencySet currencySet) {
        this.currencySet = currencySet;
        setLayout(new FlowLayout(LEFT));
        createWidgets();
    }
    
    @Override
    public Exchange getExchange() {
        return new Exchange(new Money(getAmount(), getInputCurrency()), getOutputCurrency());
    }

    private double getAmount(){
        return Double.parseDouble(amount.getText());
    }
    
    private Currency getInputCurrency(){
        return inputCurrency.getItemAt(inputCurrency.getSelectedIndex());
    }
    
    private Currency getOutputCurrency(){
        return outputCurrency.getItemAt(outputCurrency.getSelectedIndex());
    }
    
    
    private void createWidgets() {
        add(createAmount());
        add(createInputCurrency());
        add(createOutputCurrency());
    }

    private JComboBox createOutputCurrency() {
        JComboBox<Currency> box = new JComboBox<>();
        this.outputCurrency = box;
        addCurrenciesToOutputBox();
        return box;
    }

    private JComboBox createInputCurrency() {
        Currency[] currencies = currencySet.toArray();
        JComboBox box = new JComboBox<>(currencies);
        this.inputCurrency = box;
        return box;
    }

    private JTextField createAmount() {
        JTextField money = new JTextField();
        money.setColumns(5);
        this.amount = money;
        return money;
    }

    private void addCurrenciesToOutputBox() {
        Currency[] currencies = currencySet.toArray();
        for (Currency currency : currencies) {
            outputCurrency.addItem(currency);
        }
    }
    
}
