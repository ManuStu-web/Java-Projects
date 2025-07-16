package Project.BankMangmentSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Withdrawl extends JFrame implements ActionListener
{
    JLabel text;
    JTextField amount;
    JButton withdraw , back;
    String pinnumber;
    public Withdrawl(String pinnumber) 
    {
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Project/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        text = new JLabel("Enter the Amount you want to Withdraw");
        text.setBounds(180,300,400,20);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        amount=new JTextField();
        amount.setBounds(170,350,320,25);
        image.add(amount);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(355,485,150,30);
        image.add(withdraw);
        withdraw.addActionListener(this);

        back=new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        image.add(back);
        back.addActionListener(this);

        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==withdraw)
        {
            String amt = amount.getText();
            Date date = new Date();
            if(amt.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Bikhari paise to daal le");
            }
            else
            {
                conn Conn = new conn();
                String query = "insert into bank values('"+pinnumber+"', '"+date+"','Withdrawl','"+amt+"')";
                try {
                    Conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Successfully Withdrawled the Money \n Amount = "+amt);
                    new Transaction(pinnumber);
                    setVisible(false);
                } catch (Exception e) {
                    System.out.println(e);
                }

            }
        }
        if(ae.getSource()==back)
        {
            new Transaction(pinnumber);
            setVisible(false);
        }
    }
    public static void main(String args[])
    {
       new Deposite("");
    }
}
