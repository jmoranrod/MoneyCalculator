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
import ui.CurrencyDialog;
import ui.MoneyDialog;

public class MoneyCalculatorFrame extends JFrame {
    private ActionListener actionListener;
    private MoneyDisplayLabel moneyDisplayLabel;
    private final Map<String,ActionListener> listeners;

    public MoneyCalculatorFrame() {
        this.listeners = new HashMap<>();
        setTitle("MoneyCalculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(300, 300));
        setResizable(false);
        setLocation(300, 300);
        createComponents();
        setVisible(true);
        MoneyCalculatorFrame.this.add(createMoneyDisplay(),NORMAL);
    }
    
    public void register(String command, ActionListener actionListener){
        this.listeners.put(command, actionListener);
    }

    private void createComponents() {
        add(createExchangeDialog());
        //add(createMoneyDisplay());
        add(createToolbar(), BorderLayout.SOUTH);
    }

    private JPanel createExchangeDialog() {
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(new MoneyDialog());
        panel.add(new CurrencyDialog());
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
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                listeners.get("Calculate").actionPerformed(e);
            }
        });
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

    public void register(ActionListener actionListener) {
        this.actionListener = actionListener;
    }

    private JLabel createMoneyDisplay() {
        MoneyDisplayLabel label = new MoneyDisplayLabel();
        this.moneyDisplayLabel = label;
        return label;
    }

}
