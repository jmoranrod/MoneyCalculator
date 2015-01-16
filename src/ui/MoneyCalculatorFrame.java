package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MoneyCalculatorFrame extends JFrame {
    private ActionListener actionListener;

    public MoneyCalculatorFrame() {
        setTitle("MoneyCalculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(300, 300));
        createComponents();
        setVisible(true);
    }

    private void createComponents() {
        add(createExchangeDialog());
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
                System.out.println("");
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

}
