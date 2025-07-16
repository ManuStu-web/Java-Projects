package Project.BankMangmentSystem;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.ResultSet;

import javax.swing.*;
public class FastCash extends JFrame implements ActionListener
{
    JButton deposit,withdrawl,fastcash,ministatment,pinchange,balanceenquiry,exit;
    String pinnumber;
    public FastCash(String pinnumber)
    {
        setTitle("Fast Cash");
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Project/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Select Withdrawl Amount");
        text.setBounds(215,300,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        deposit = new JButton("Rs 500");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl = new JButton("Rs 1000");
        withdrawl.setBounds(355,415,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastcash = new JButton("Rs 2000");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatment = new JButton("Rs 5000");
        ministatment.setBounds(355,450,150,30);
        ministatment.addActionListener(this);
        image.add(ministatment);

        pinchange = new JButton("Rs 10000");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceenquiry = new JButton("Rs 15000");
        balanceenquiry.setBounds(355,485,150,30);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);

        exit = new JButton("BACK");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900 ,900);
        setLocation(300,0);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == exit) {
        new Transaction(pinnumber);
        setVisible(false);
    } else {
        String rawText = ((JButton) ae.getSource()).getText();
        int amount = Integer.parseInt(rawText.replaceAll("[^\\d]", "")); // Cleans "Rs 15,000" → 15000

        conn c = new conn();

        try {
            ResultSet rs = c.s.executeQuery("select * from bank where Pin_Num='" + pinnumber + "'");
            int balance = 0;

            while (rs.next()) {
                String type = rs.getString("Type");
                int entryAmount = Integer.parseInt(rs.getString("Amount").replaceAll("[^\\d]", ""));
                balance += type.equals("Deposite") ? entryAmount : -entryAmount;
            }

            if (balance < amount) {
                JOptionPane.showMessageDialog(null, "Insufficient Balance");
                return;
            }

            Date date = new Date();
            String query = "insert into bank values('" + pinnumber + "','" + date + "','Withdrawl','" + amount + "')";
            c.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null, "Rs " + amount + " Withdrawl Successfully");

            new Transaction(pinnumber);
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error occurred: " + e.getMessage());
        }
    }
}
    public static void main(String[] args) 
    {
         new FastCash("");

    }
}
