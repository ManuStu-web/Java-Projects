package Project.BankMangmentSystem;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// import java.util.*;
import javax.swing.*;
public class PinChange extends JFrame implements ActionListener
{
    String pinnumber;
    JButton back ,change;
    JLabel pintext , repintext ;
    JPasswordField pin , repin;
    public PinChange(String pinnumber)
    {
        this.pinnumber=pinnumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Project/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        JLabel text = new JLabel("Change Your PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System" , Font.BOLD , 20));
        text.setBounds(250,280 ,500 ,35);
        image.add(text);

        pintext = new JLabel("Enter Your New PIN :");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System" , Font.BOLD , 16));
        pintext.setBounds(165,390 ,180 ,25);
        image.add(pintext);

        pin = new JPasswordField(); 
        pin.setFont(new Font("Raleway", Font.BOLD, 16));
        pin.setBounds(360, 390, 140, 25);
        image.add(pin);


        repintext = new JLabel("Re-Enter New PIN :");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System" , Font.BOLD , 16));
        repintext.setBounds(165,425 ,180 ,25);
        image.add(repintext);

        repin = new JPasswordField();
        repin.setFont(new Font("Raleway" , Font.BOLD, 16));
        repin.setBounds(360,425,140,25);
        image.add(repin);

        change = new JButton("CHANGE");
        change.setBounds(355, 485 ,150,30);
        image.add(change);
        change.addActionListener(this);

        back = new JButton("BACK");
        back.setBounds(165, 485 ,150,30);
        image.add(back);
        back.addActionListener(this);

       
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource()==back)
        {
           new Transaction(pinnumber);
           setVisible(false);
        }
        else
        {
            String npin = pin.getText();
            String rpin = repin.getText(); 

            if(!npin.equals(rpin))
            {
                JOptionPane.showMessageDialog(null,"PIN doesn't Matched");
                return;
            }
            else if(npin.equals("") || rpin.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Enter Both the PIN Please");
                return;
            }
            else
            {
                try
                {
                   conn Conn = new conn();
                   String query1 = "update bank set Pin_Num='"+rpin+"' where Pin_Num='"+pinnumber+"'";
                   String query2 = "update signupthree set Pin_Num='"+rpin+"' where Pin_Num='"+pinnumber+"'";
                   String query3 = "update login set Pin_Num='"+rpin+"' where Pin_Num='"+pinnumber+"'";

                   Conn.s.executeUpdate(query1);
                   Conn.s.executeUpdate(query2);
                   Conn.s.executeUpdate(query3);

                   JOptionPane.showMessageDialog(null, "New PIN Updated Successfully \n PIN : "+rpin);

                   new Transaction(rpin);
                   setVisible(false);
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
             
            }
        }
    }
    public static void main(String[] args) 
    {
        new PinChange("");
    }
   
}
