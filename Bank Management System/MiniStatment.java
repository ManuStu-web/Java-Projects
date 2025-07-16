package Project.BankMangmentSystem;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
public class MiniStatment extends JFrame implements ActionListener
{
    String pinnumber;
    public MiniStatment(String pinnumber)
    {
      setTitle("Recipt");
      this.pinnumber=pinnumber;
      setLayout(null);

      JLabel mini = new JLabel();
      mini.setBounds(20 ,140, 400 ,200);
      add(mini);

      JLabel bank = new JLabel("Bharat Bank");
      bank.setBounds(150,20,100,20);
      add(bank);

      JLabel card = new JLabel();
      card.setBounds(20,80,300,20);
      add(card);

      JLabel balance = new JLabel();
      balance.setBounds(20,400,300,20);
      add(balance);
      

      try
      {
        conn Conn = new conn();
        ResultSet rs = Conn.s.executeQuery("select * from login where Pin_Num = '"+pinnumber+"'");
        while (rs.next()) 
        {
            card.setText("Card Number : "+rs.getString("Card_Num").substring(0,4)+"XXXXXXXX"+rs.getString("Card_Num").substring(12));
        }
      }
      catch(Exception e)
      {
         System.out.println(e);
      }

      try
      {
        conn Conn = new conn();
        int bal=0;
        ResultSet rs = Conn.s.executeQuery("select * from bank where Pin_Num = '"+pinnumber+"'");
        while (rs.next()) 
        {
            mini.setText(mini.getText() + "<html>" + rs.getString("Date") + "&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("Type") + "&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("Amount") +"<br><br><html>" );
           
            if (rs.getString("Type").equals("Deposite")) {
              bal += Integer.parseInt(rs.getString("Amount"));
            } else {
              bal -= Integer.parseInt(rs.getString("Amount"));
            }
        }
        balance.setText("Your Balance: Rs "+bal);
      }
      catch(Exception e)
      {
         System.out.println(e);
      }

      mini.setBounds(20,140,400,200);

      setSize(400,600);
      setLocation(20,20);
      setVisible(true);
      
    }

    public void actionPerformed(ActionEvent ae)
    {

    }
    public static void main(String[] args) {
        new MiniStatment("");
    }
}
