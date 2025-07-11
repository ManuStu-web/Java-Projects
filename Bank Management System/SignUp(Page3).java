package Project.BankMangmentSystem;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;
public class SignUp3 extends JFrame implements ActionListener
{
    JRadioButton r1 ,r2 ,r3 ,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit , cancel;
    private String Fnum;
    public SignUp3(String Fnum)
    {
        this.Fnum = Fnum;
        setLayout(null);
        JLabel label = new JLabel("Page 3: Account Details");
        label.setFont(new Font("Raleway" , Font.BOLD , 22));
        label.setBounds(280,40,400,40);
        add(label);

        JLabel type = new JLabel("Account Type :");
        type.setFont(new Font("Raleway" , Font.BOLD , 22));
        type.setBounds(100,140,200,30);
        add(type);

        r1=new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway" , Font.BOLD , 16));
        r1.setBounds(100,180,150,20);
        add(r1);

        r2=new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway" , Font.BOLD , 16));
        r2.setBounds(350,180,250,20);
        add(r2);

        r3=new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway" , Font.BOLD , 16));
        r3.setBounds(100,220,150,20);
        add(r3);

        r4=new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway" , Font.BOLD , 16));
        r4.setBounds(350,220,250,20);
        add(r4);

        ButtonGroup accounttype =new ButtonGroup();
        accounttype.add(r1);
        accounttype.add(r2);
        accounttype.add(r3);
        accounttype.add(r4);

        JLabel Cardno = new JLabel("Card Number :");
        Cardno.setFont(new Font("Raleway" , Font.BOLD , 22));
        Cardno.setBounds(100,300,200,20);
        add(Cardno);

        JLabel Carddetails = new JLabel("(Your 16 Digit Card Number)");
        Carddetails.setFont(new Font("Raleway" , Font.BOLD , 12));
        Carddetails.setBounds(100,330,200,20);
        add(Carddetails);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-4132");
        number.setFont(new Font("Raleway" , Font.BOLD , 16));
        number.setBounds(330,300,200,30);
        add(number);

        JLabel Pinno = new JLabel("PIN : ");
        Pinno.setFont(new Font("Raleway" , Font.BOLD , 22));
        Pinno.setBounds(100,370,200,20);
        add(Pinno);

        JLabel Pindetails = new JLabel("(Your 4 Digit PIN Number)");
        Pindetails.setFont(new Font("Raleway" , Font.BOLD , 12));
        Pindetails.setBounds(100,400,200,20);
        add(Pindetails);

        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway" , Font.BOLD , 16));
        pnumber.setBounds(330,370,200,30);
        add(pnumber);

        JLabel Services = new JLabel("Services Required : ");
        Services.setFont(new Font("Raleway" , Font.BOLD , 22));
        Services.setBounds(100,450,250,30);
        add(Services);

        c1 = new JCheckBox("ATM Card");
        c1.setFont(new Font("Raleway" , Font.BOLD , 16));
        c1.setBounds(100,500,200,30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway" , Font.BOLD , 16));
        c2.setBounds(350,500,200,30);
        add(c2);


        c3 = new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway" , Font.BOLD , 16));
        c3.setBounds(100,550,200,30);
        add(c3);

        c4 = new JCheckBox("Email Alerts");
        c4.setFont(new Font("Raleway" , Font.BOLD , 16));
        c4.setBounds(350,550,200,30);
        add(c4);
        
        c5 = new JCheckBox("Cheque Book");
        c5.setFont(new Font("Raleway" , Font.BOLD , 16));
        c5.setBounds(100,600,200,30);
        add(c5);

        c6 = new JCheckBox("E-Statment");
        c6.setFont(new Font("Raleway" , Font.BOLD , 16));
        c6.setBounds(350,600,200,30);
        add(c6);

        c7 = new JCheckBox("I confirm that all the details I filled are correct and have knwoledge about the conseqences if filled wrong.");
        c7.setFont(new Font("Raleway" , Font.BOLD , 12));
        c7.setBounds(100,680,600,30);
        add(c7);

        submit = new JButton("Submit   ✔️");
        submit.setFont(new Font("Raleway" , Font.BOLD , 14));
        submit.setBounds(250,720,130,30);
        add(submit);
        submit.addActionListener(this);

        cancel = new JButton("Cancel   ❌");
        cancel.setFont(new Font("Raleway" , Font.BOLD , 14));
        cancel.setBounds(420,720,130,30);
        add(cancel);
        cancel.addActionListener(this);


        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==submit)
        {
           
           String accountType =null;
           if(r1.isSelected())
           {
            accountType="Saving Account";
           }
           else if(r2.isSelected())
           {
            accountType="Fixed Deposit";
           }
           else if(r4.isSelected())
           {
            accountType="Reoccuring Deposite";
           }
           else
           {
            accountType="Current Account";
           }

           Random random = new Random();
           String Cno=""+ Math.abs((random.nextLong()%90000000L)+5040936000000000L);
           String pno = String.valueOf(random.nextInt(9000) + 1000);

           String facility="";
           if(c1.isSelected())
           {
            facility=facility+" ATM Card";
           }
           if(c2.isSelected())
           {
            facility=facility+" Internet Banking";
           }
           if(c3.isSelected())
           {
            facility=facility+" Mobile Banking";
           }
           if(c4.isSelected())
           {
            facility=facility+" Email Alert";
           }
           if(c5.isSelected())
           {
            facility=facility+" Cheque Book";
           }
           if(c6.isSelected())
           {
            facility=facility+" E-Statment";
           }

           try
           {
              if(accountType.equals(""))
              {
                  JOptionPane.showMessageDialog(null, "Fill all the details Please");
              }
              else
              {
                conn Conn = new conn();
                String query1="insert into signupthree values('"+Fnum+"','"+accountType+"','"+Cno+"','"+pno+"','"+facility+"')";
                String query2="insert into login values('"+Fnum+"','"+Cno+"','"+pno+"')";
                Conn.s.executeUpdate(query1);
                Conn.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Card Number : "+Cno + "\n PIN : "+pno);

                
              }
           }
           catch(Exception e)
           {
            System.out.println(e);
           }
        }
        else if(ae.getSource()==cancel)
        {

        }
    }

    public static void main(String[] args) 
    {
        new SignUp3("");
    }
}
