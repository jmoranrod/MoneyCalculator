package swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ApplicationFrame extends JFrame {
    private ActionListener actionListener;
    
    public ApplicationFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setTitle("Money Calculator");
        this.createWidgets();
        this.setVisible(true);
    }

    private void createWidgets() {
        this.getContentPane().add(createCalculateButton(), BorderLayout.SOUTH);
    }

    private JButton createCalculateButton() {
        JButton button = new JButton("Calculate");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                actionListener.actionPerformed(e);
            }
        });
        return button;
    }

    public void register(ActionListener actionListener) {
        this.actionListener = actionListener;
    }
       
    
}
