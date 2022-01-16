package week5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ThirdExample extends JFrame{
    JPanel panel;
    JLabel label;
    JButton button;
    JTextField textField;
    JTextArea textArea;
    
    public static void main(String[] args) {
        new ThirdExample();
    }
    
    public ThirdExample(){
        //Configure the Frame(Window)
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Third Example");
        
        //Create Panel
        panel = new JPanel();
        //Create Label
        label = new JLabel("My First Label");
        panel.add(label);
        label.setText("The value of label changed.");
        
        button = new JButton("Click");
        button.setToolTipText("You can click this button");
        panel.add(button);
        ListenForButton buttonListener = new ListenForButton();
        button.addActionListener(buttonListener);
        
        textField = new JTextField("Hello World",20);
        panel.add(textField);
        
        textArea = new JTextArea(5,10);
        textArea.setLineWrap(true);
        panel.add(textArea);

        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane);
        
        this.add(panel);
        
        this.setVisible(true);
    }
    
    private class ListenForButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            label.setText(textField.getText());
        }
    }
}
