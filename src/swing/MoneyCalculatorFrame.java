package swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.CurrencySet;
import ui.ExchangeDialog;
import ui.MoneyDisplay;

public class MoneyCalculatorFrame extends JFrame {
    
    private ExchangeDialog exchangeDialog;
    private MoneyDisplay moneyDisplay;
    private final Map<String,ActionListener> listeners;
    private final CurrencySet currencySet;

    public MoneyCalculatorFrame(CurrencySet currencySet) {
        this.listeners = new HashMap<>();
        this.currencySet = currencySet;
        setTitle("MoneyCalculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(300, 300));
        setResizable(false);
        setLocation(300, 300);
        createComponents();
        setVisible(true);
        MoneyCalculatorFrame.this.add(createMoneyDisplay(), NORMAL);
    }
    
    public ExchangeDialog getExchangeDialog() {
        return exchangeDialog;
    }

    public MoneyDisplay getMoneyDisplayLabel() {
        return moneyDisplay;
    }
    
    public void register(String command, ActionListener actionListener){
        this.listeners.put(command, actionListener);
    }

    private void createComponents(){
        add(createExchangeDialog());
        add(createToolbar(), BorderLayout.SOUTH);
    }

    private JPanel createExchangeDialog() {
        ExchangeDialogPanel panel = new ExchangeDialogPanel(currencySet);
        this.exchangeDialog = panel;
        return panel;
    }

    private JPanel createToolbar() {
        JPanel toolBar = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        toolBar.add(createCalculateButton());
        toolBar.add(createCancelButton());
        return toolBar;
    }

    private JButton createCalculateButton() {
        JButton button = new JButton("Calculate");
        button.addActionListener(createActionListener("Calculate"));
        return button;
    }

    private JButton createCancelButton() {
        JButton button = new JButton("Close/Cancel");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                MoneyCalculatorFrame.this.dispose();
            }
        });
        return button;
    }

    private JLabel createMoneyDisplay() {
        MoneyDisplayLabel label = new MoneyDisplayLabel();
        this.moneyDisplay = label;
        return label;
    }

    private ActionListener createActionListener(final String string) {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                listeners.get(string).actionPerformed(e);
            }
        };
    }

}
