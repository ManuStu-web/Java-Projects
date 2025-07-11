package Project.BankMangmentSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// import Project.BankMangmentSystem.SignUp;

public class Login extends JFrame implements ActionListener {

    JButton login , Clear , Newcus;
    JTextField Cno;
    JPasswordField pno;
    public Login() {
        setTitle("Bharat Bank");
        setLayout(null);

        ImageIcon blogo = new ImageIcon("C:/Users/rajra/Downloads/banklogo.png");
        Image blogo2 = blogo.getImage().getScaledInstance(130, 80, Image.SCALE_DEFAULT);
        ImageIcon banklogoo = new ImageIcon(blogo2);
        JLabel label = new JLabel(banklogoo);
        label.setBounds(70, 10, 100, 100); 
        add(label);

        JLabel text = new JLabel("Welcome to Bharat Bank ATM");
        text.setFont(new Font("Osward" , Font.BOLD,38));
        text.setBounds(200,40,700,40);
        add(text);

        JLabel CardNo = new JLabel("Card Number:");
        CardNo.setFont(new Font("Lucida Sans" , Font.BOLD,28));
        CardNo.setBounds(120,150,200,40);
        add(CardNo);

        Cno = new JTextField();
        Cno.setBounds(350 , 160 , 250 , 30);
        Cno.setFont(new Font("Arial" ,Font.BOLD, 14));
        add(Cno);

        JLabel Pin = new JLabel("PIN:");
        Pin.setFont(new Font("Raleway" , Font.BOLD,28));
        Pin.setBounds(120,220,100,40);
        add(Pin);

        pno = new JPasswordField();
        pno.setBounds(350 , 230 , 250 , 30);
        add(pno);

        login = new JButton("Login");
        login.setBounds(350,300,100,30);
        add(login);
        login.addActionListener(this);

        Clear = new JButton("Reset");
        Clear.setBounds(500,300,100,30);
        add(Clear);
        Clear.addActionListener(this);

        Newcus = new JButton("Sign Up");
        Newcus.setBounds(350,350,250,30);
        add(Newcus);
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
