package Project.BankMangmentSystem;

import javax.swing.*;

import java.awt.Font;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
public class SignUp extends JFrame implements ActionListener
{
   int Randomnum;
   JTextField CNames , FNames , Eadd , Add , CityName , StateName , PINC;
   JButton next;
   JRadioButton male , female , other , married ,nontmarried ,Others;
   JDateChooser datechoose; 
   public SignUp()
   {
     setLayout(null);
     Random num = new Random();
     Randomnum= num.nextInt(9000)+1000;
     JLabel Formno = new JLabel("APPLICATION FORM NO. " + Randomnum);
     Formno.setFont(new Font("Raleway",Font.BOLD,38));
     Formno.setBounds(140,20,600,40);
     add(Formno);

     JLabel PersonalDeatils = new JLabel("Page 1: Personal Details ");
     PersonalDeatils.setFont(new Font("Raleway",Font.BOLD,22));
     PersonalDeatils.setBounds(290,80,400,30);
     add(PersonalDeatils);

     JLabel Name=  new JLabel("Name : ");
     Name.setFont(new Font("Raleway",Font.BOLD,20));
     Name.setBounds(100,140,100,30);
     add(Name);

     CNames= new JTextField();
     CNames.setFont(new Font("Raleway", Font.BOLD , 14));
     CNames.setBounds(300,140,400,30);
     add(CNames);

     JLabel fName=  new JLabel("Father's Name : ");
     fName.setFont(new Font("Raleway",Font.BOLD,20));
     fName.setBounds(100,190,200,30);
     add(fName);

     FNames= new JTextField();
     FNames.setFont(new Font("Raleway", Font.BOLD , 14));
     FNames.setBounds(300,190,400,30);
     add(FNames);

     JLabel DOB=  new JLabel("Date Of Birth : ");
     DOB.setFont(new Font("Raleway",Font.BOLD,20));
     DOB.setBounds(100,240,200,30);
     add(DOB);

     datechoose = new JDateChooser();
     datechoose.setBounds(300,240,400,30);
     add(datechoose);

     JLabel Gender=  new JLabel("Gender : ");
     Gender.setFont(new Font("Raleway",Font.BOLD,22));
     Gender.setBounds(100,290,100,30);
     add(Gender);

     male = new JRadioButton("Male");
     male.setBounds(300,290,60,30);
     add(male);

     female = new JRadioButton("Female");
     female.setBounds(450,290,100,30);
     add(female);

     ButtonGroup gendersgroup = new ButtonGroup();
     gendersgroup.add(female);
     gendersgroup.add(male);

     JLabel EMail=  new JLabel("Email : ");
     EMail.setFont(new Font("Raleway",Font.BOLD,22));
     EMail.setBounds(100,340,100,30);
     add(EMail);

     Eadd= new JTextField();
     Eadd.setFont(new Font("Raleway", Font.BOLD , 14));
     Eadd.setBounds(300,340,400,30);
     add(Eadd);

     JLabel Maritial=  new JLabel("Maritial Status : ");
     Maritial.setFont(new Font("Raleway",Font.BOLD,20));
     Maritial.setBounds(100,390,200,30);
     add(Maritial);

     
     married = new JRadioButton("Marrired");
     married.setBounds(300,390,100,30);
     add(married);

     nontmarried = new JRadioButton("Not Married");
     nontmarried.setBounds(450,390,100,30);
     add(nontmarried);

     Others = new JRadioButton("Other");
     Others.setBounds(630,390,100,30);
     add(Others);


     ButtonGroup MarriedorNot = new ButtonGroup();
     gendersgroup.add(married);
     gendersgroup.add(nontmarried);
     gendersgroup.add(Others);

     JLabel Adress=  new JLabel("Adress : ");
     Adress.setFont(new Font("Raleway",Font.BOLD,20));
     Adress.setBounds(100,440,100,30);
     add(Adress);

     Add= new JTextField();
     Add.setFont(new Font("Raleway", Font.BOLD , 14));
     Add.setBounds(300,440,400,30);
     add(Add);

     JLabel City=  new JLabel("City : ");
     City.setFont(new Font("Raleway",Font.BOLD,20));
     City.setBounds(100,490,100,30);
     add(City);

     CityName= new JTextField();
     CityName.setFont(new Font("Raleway", Font.BOLD , 14));
     CityName.setBounds(300,490,400,30);
     add(CityName);

     JLabel State=  new JLabel("State : ");
     State.setFont(new Font("Raleway",Font.BOLD,20));
     State.setBounds(100,540,100,30);
     add(State);

     StateName= new JTextField();
     StateName.setFont(new Font("Raleway", Font.BOLD , 14));
     StateName.setBounds(300,540,400,30);
     add(StateName);

     JLabel Pincode=  new JLabel("Pincode : ");
     Pincode.setFont(new Font("Raleway",Font.BOLD,20));
     Pincode.setBounds(100,590,100,30);
     add(Pincode);

     PINC= new JTextField();
     PINC.setFont(new Font("Raleway", Font.BOLD , 14));
     PINC.setBounds(300,590,400,30);
     add(PINC);

     JButton next = new JButton("NEXT-->");
     next.setBounds(620,660,80,30);
     add(next);
     next.addActionListener(this);

     setSize(850,800);
     setLocation(350,10);
     setVisible(true);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   public void actionPerformed(ActionEvent ae)
    {
       String Formno = ""+Randomnum;
       String Name = CNames.getText();
       String Fname = FNames.getText();
       String dob = ((JTextField)datechoose.getDateEditor().getUiComponent()).getText();
       String gender = null;
       if(male.isSelected())
       {
        gender="male";
       }
       else
       {
        gender="female";
       }
       String email = Eadd.getText();
       String Marital = null;
       if(married.isSelected())
       {
        Marital="Married";
       }
       else if(nontmarried.isSelected())
       {
        Marital="Unmarried";
       }
       else
       {
        Marital="Other";
       }

       String adress = Add.getText();
       String city = CityName.getText();
       String state = StateName.getText();
       String pin = PINC.getText();

       try{
          if(Name.equals(""))
          {
            JOptionPane.showMessageDialog(null, "Name is REQUIRED !!");
          }
          else
          {
            conn c = new conn();
            String query = "insert into signup values('"+Formno+"','"+Name+"','"+Fname+"','"+dob+"','"+gender+"','"+email+"','"+Marital+"','"+adress+"','"+city+"','"+state+"','"+pin+"')";
            c.s.executeUpdate(query);

            
            new SignUp2(Formno);
            setVisible(false);
          }
       }
       catch(Exception e)
       {
         System.out.println(e);
       }

    }


  public static void main(String[] args) 
  {
    new SignUp();
  }    
}
