package displayQuetions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class examForm extends JFrame implements ActionListener{
    
    ImageIcon background;
    JLabel backgroundlbl;
    
    public examForm(){
        background =new ImageIcon("image\\m.jpg");
        backgroundlbl=new JLabel(background);
        add(backgroundlbl);
        setVisible(true);
        setLocation(0, 0);
        setSize(1365, 730);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }
    public static void main(String[] args) {
        new examForm();
    }
    
}
