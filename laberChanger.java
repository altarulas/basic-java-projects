import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class laberChanger extends JFrame{
    
    JPanel panel;
    JLabel label;
    JButton button;
    JTextField textField;
    JTextField textField2;
    JTextArea textArea;

   
    public static void main(String[] args) {
        new laberChanger();
    }
    
    public laberChanger(){
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Third Example");
        
        panel = new JPanel();
        
        label = new JLabel("My Label");
        panel.add(label);
        label.setText("The value of label changed.");
        
        button = new JButton("Click");
        button.setToolTipText("You can click this button");
        panel.add(button);
        ListenForButton buttonListener = new ListenForButton();
        button.addActionListener(buttonListener);
        
        textField = new JTextField("Harry Potter 1",20);
        textField2 = new JTextField("Harry Potter 2",20);
        panel.add(textField);
        panel.add(textField2);
        
       
        
        this.add(panel);
        this.setVisible(true);
    }
    
    private class ListenForButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            label.setText(textField.getText()+textField2.getText());
            textField.setText("");
            textField2.setText("");
            
        }
    }
    
}
