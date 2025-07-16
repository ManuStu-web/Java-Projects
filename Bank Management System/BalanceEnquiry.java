package Project.BankMangmentSystem;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
public class BalanceEnquiry extends JFrame implements ActionListener
{
    JButton back;
    String pinnumber;
    public BalanceEnquiry(String pinnumber)
    {
        setTitle("Balance Check");
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Project/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        conn c = new conn();
        int balance=0;
        try
        {
            ResultSet rs = c.s.executeQuery("select * from  bank where Pin_Num='"+pinnumber+"'");
            while(rs.next())
            {
                if(rs.getString("Type").equals("Deposite"))
                {
                    balance+=Integer.parseInt(rs.getString("Amount"));
                }
                else
                {
                    balance-=Integer.parseInt(rs.getString("Amount"));
                }
            }
        }
        catch(Exception e)
        {
           System.out.println(e);
        }

        JLabel l1 = new JLabel("Your Account Balance = Rs "+balance);
        l1.setForeground(Color.white);
        l1.setBounds(170,300,400,30);
        image.add(l1);


        back = new JButton("BACK");
        back.setBounds(355,520,150,30);
        image.add(back);
        back.addActionListener(this);


        setSize(900 ,900);
        setLocation(300,0);
        setVisible(true);   
    }

    public void actionPerformed(ActionEvent ae)
    {
        new Transaction(pinnumber);
        setVisible(false);
    }
    public static void main(String[] args) 
    {
        new BalanceEnquiry("");
    }
}
