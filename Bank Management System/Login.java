package Project.BankMangmentSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// import java.sql.*;
import java.sql.ResultSet;
// import Project.BankMangmentSystem.SignUp;

public class Login extends JFrame implements ActionListener {

    JButton login , Clear , Newcus;
    JTextField Cno;
    JPasswordField pno;
    public Login() {
        setTitle("Bharat Bank");
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Project/icons/loginbg.png"));
        Image i2 = i1.getImage().getScaledInstance(800,480,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,480);
        add(image);


        ImageIcon blogo = new ImageIcon(ClassLoader.getSystemResource("Project/icons/banklogo.png"));
        Image blogo2 = blogo.getImage().getScaledInstance(130, 80, Image.SCALE_DEFAULT);
        ImageIcon banklogoo = new ImageIcon(blogo2);
        JLabel label = new JLabel(banklogoo);
        label.setBounds(70, 10, 100, 100); 
        image.add(label);

        JLabel text = new JLabel("Welcome to Bharat Bank ATM");
        text.setFont(new Font("Osward" , Font.BOLD,38));
        text.setBounds(200,40,700,40);
        image.add(text);

        JLabel CardNo = new JLabel("Card Number:");
        CardNo.setFont(new Font("Lucida Sans" , Font.BOLD,28));
        CardNo.setBounds(120,150,200,40);
        image.add(CardNo);

        Cno = new JTextField();
        Cno.setBounds(350 , 160 , 250 , 30);
        Cno.setFont(new Font("Arial" ,Font.BOLD, 14));
        image.add(Cno);

        JLabel Pin = new JLabel("PIN:");
        Pin.setFont(new Font("Raleway" , Font.BOLD,28));
        Pin.setBounds(120,220,100,40);
        image.add(Pin);

        pno = new JPasswordField();
        pno.setBounds(350 , 230 , 250 , 30);
        image.add(pno);

        login = new JButton("Login");
        login.setBounds(350,300,100,30);
        image.add(login);
        login.addActionListener(this);

        Clear = new JButton("Reset");
        Clear.setBounds(500,300,100,30);
        image.add(Clear);
        Clear.addActionListener(this);

        Newcus = new JButton("Sign Up");
        Newcus.setBounds(350,350,250,30);
        image.add(Newcus);
        Newcus.addActionListener(this);



        setSize(800, 480);
        setLocation(350, 200);
        setVisible(true); 
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==Clear)
        {
            Cno.setText("");
            pno.setText("");
        }
        if(ae.getSource()==login)
        {
            conn Con = new conn();
            String cardnumber = Cno.getText();
            String pinnumber = pno.getText();

            String query = "select * from login where Card_Num= '" + cardnumber +"' and Pin_Num= '"+pinnumber +"'";
            try
            {
               ResultSet rs = Con.s.executeQuery(query);

               if(rs.next())
               {
                new Transaction(pinnumber);
                setVisible(false);
               }
               else
               {
                JOptionPane.showMessageDialog(null, "Incorrect Details");
               }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }

        if(ae.getSource()==Newcus)
        {
           
            new SignUp();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
