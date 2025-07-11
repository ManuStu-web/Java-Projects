package Project.BankMangmentSystem;

import javax.swing.*;

import java.awt.Font;
import java.awt.event.*;
public class SignUp2 extends JFrame implements ActionListener
{
    String Fnum;
   JTextField  pnum , Addhar;
   JButton next;
   JRadioButton yes ,yes2 ,no , no2;
   JComboBox religion,category ,income,education , occupation;
   public SignUp2(String Fnum)
   {
    this.Fnum=Fnum;
     setTitle("New Registration -- Page 2");
     setLayout(null);

     JLabel AdditionalDeatils = new JLabel("Page 2: Additional Details ");
     AdditionalDeatils.setFont(new Font("Raleway",Font.BOLD,22));
     AdditionalDeatils.setBounds(290,80,400,30);
     add(AdditionalDeatils);

     JLabel Religion=  new JLabel("Religion : ");
     Religion.setFont(new Font("Raleway",Font.BOLD,20));
     Religion.setBounds(100,140,100,30);
     add(Religion);

     String reg[]={"Hindu" , "Muslim" , "Sikh" , "Christan" , "Others"};
     religion = new JComboBox(reg);
     religion.setBounds(300,140,400,30);
     add(religion);

     JLabel Category=  new JLabel("Category: ");
     Category.setFont(new Font("Raleway",Font.BOLD,20));
     Category.setBounds(100,190,200,30);
     add(Category);

     String cat[]={"General" , "OBC" , "SC" , "ST" , "Others"};
     category = new JComboBox(cat);
     category.setBounds(300,190,400,30);
     add(category);

     JLabel Income=  new JLabel("Income : ");
     Income.setFont(new Font("Raleway",Font.BOLD,20));
     Income.setBounds(100,240,200,30);
     add(Income);

     String inc[]={"Null" , "< 1,50,000" , "< 2,50,000" , "<10,00,000" , ">=10,00,000"};
     income = new JComboBox(inc);
     income.setBounds(300,240,400,30);
     add(income);

     JLabel Educated=  new JLabel("Education : ");
     Educated.setFont(new Font("Raleway",Font.BOLD,22));
     Educated.setBounds(100,290,300,30);
     add(Educated);

     String edu[]={"Null" , "8th Pass" , "10th pass" , "12th pass" , "UG/PG"};
     education = new JComboBox(edu);
     education.setBounds(300,290,400,30);
     add(education);

     JLabel Custoccupation=  new JLabel("Occupation : ");
     Custoccupation.setFont(new Font("Raleway",Font.BOLD,20));
     Custoccupation.setBounds(100,340,300,30);
     add(Custoccupation);

     String occ[]={"Job" , "Buisness" , "Youtube" , "Retired" , "Goverment/Soldier"};
     occupation = new JComboBox(occ);
     occupation.setBounds(300,340,400,30);
     add(occupation);

     JLabel Pannum=  new JLabel("Pan Number: ");
     Pannum.setFont(new Font("Raleway",Font.BOLD,20));
     Pannum.setBounds(100,390,300,30);
     add(Pannum);

     pnum= new JTextField();
     pnum.setFont(new Font("Raleway", Font.BOLD , 14));
     pnum.setBounds(300,390,400,30);
     add(pnum);

     JLabel AdhaarNum=  new JLabel("Adhaar No: ");
     AdhaarNum.setFont(new Font("Raleway",Font.BOLD,20));
     AdhaarNum.setBounds(100,440,300,30);
     add(AdhaarNum);

     Addhar= new JTextField();
     Addhar.setFont(new Font("Raleway", Font.BOLD , 14));
     Addhar.setBounds(300,440,400,30);
     add(Addhar);

     JLabel SeniorCitz=  new JLabel("Senior Citizen: ");
     SeniorCitz.setFont(new Font("Raleway",Font.BOLD,20));
     SeniorCitz.setBounds(100,490,300,30);
     add(SeniorCitz);

     yes = new JRadioButton("Yes");
     yes.setBounds(300,490,60,30);
     add(yes);

     no = new JRadioButton("No");
     no.setBounds(450,490,60,30);
     add(no);

     ButtonGroup senior = new ButtonGroup();
     senior.add(no);
     senior.add(yes);

     JLabel Existacc=  new JLabel("Existing account: ");
     Existacc.setFont(new Font("Raleway",Font.BOLD,20));
     Existacc.setBounds(100,540,300,30);
     add(Existacc);

     yes2 = new JRadioButton("Yes");
     yes2.setBounds(300,540,60,30); // moved down
     add(yes2);

     no2 = new JRadioButton("No");
     no2.setBounds(450,540,100,30); // moved down
     add(no2);

     ButtonGroup acc = new ButtonGroup();
     acc.add(yes2);
     acc.add(no2);



     JButton next = new JButton("NEXT-->");
     next.setBounds(620,660,80,30);
     add(next);
     next.addActionListener((ActionListener) this);

     setSize(850,800);
     setLocation(350,10);
     setVisible(true);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   public void actionPerformed(ActionEvent ae)
    {
       String sreligion =(String)religion.getSelectedItem();
       String scategory = (String)category.getSelectedItem();
       String sincome = (String)income.getSelectedItem();
       String seducation = (String)education.getSelectedItem();
       String soccupation = (String)occupation.getSelectedItem();
       String ssenior = null;    
       if(yes.isSelected())
       {
        ssenior="Yes";
       }
       else
       {
        ssenior="No";
       }
       String eaccount = null;    
       if(yes2.isSelected())
       {
        eaccount="Yes";
       }
       else
       {
        eaccount="No";
       }
       
       String saddhar = Addhar.getText();
       String span = pnum.getText();
       try
       {
          conn c = new conn();
          String query = "insert into signuptwo values('"+Fnum+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+ssenior+"','"+eaccount+"','"+saddhar+"','"+span+"')";
          c.s.executeUpdate(query);

          new SignUp3(Fnum);
          setVisible(false);
       }
       catch(Exception e)
       {
         System.out.println(e);
       }

    }


  public static void main(String[] args) 
  {
    new SignUp2("");
  }    
}
