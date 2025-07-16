package Project.BankMangmentSystem;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class Transaction extends JFrame implements ActionListener
{
    JButton deposit,withdrawl,fastcash,ministatment,pinchange,balanceenquiry,exit;
    String pinnumber;
    public Transaction(String pinnumber)
    {
        setTitle("Transaction");
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Project/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(215,300,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        deposit = new JButton("Deposite");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(355,415,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatment = new JButton("Mini Statment");
        ministatment.setBounds(355,450,150,30);
        ministatment.addActionListener(this);
        image.add(ministatment);

        pinchange = new JButton("Pin Change");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceenquiry = new JButton("Balnace Enquiry");
        balanceenquiry.setBounds(355,485,150,30);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);

        exit = new JButton("Exit");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900 ,900);
        setLocation(300,0);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==exit)
        {
           System.exit(0);
        }
        else if(ae.getSource()==deposit)
        {
            new Deposite(pinnumber);
            setVisible(false);
        }
        else if(ae.getSource()==withdrawl)
        {
            new Withdrawl(pinnumber);
            setVisible(false);
        }
        else if(ae.getSource()==fastcash)
        {
            new FastCash(pinnumber);
            setVisible(false);
        }
        else if(ae.getSource()==pinchange)
        {
            new PinChange(pinnumber);
            setVisible(false);
        }
        else if(ae.getSource()==balanceenquiry)
        {
            new BalanceEnquiry(pinnumber);
            setVisible(false);
        }
        else if(ae.getSource()==ministatment)
        {
            new MiniStatment(pinnumber);
        }
    }
    public static void main(String[] args) 
    {
         new Transaction("");

    }
}
