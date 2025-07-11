package Project.BankMangmentSystem;

import java.sql.*;
public class conn 
{
        Connection c;
        Statement s;

    public conn()
    {
       
        try
        {
          c=DriverManager.getConnection("jdbc:mysql:///bankmanagmentsystem","root" , "2299Sh@rma5140");
          s=c.createStatement();


        } 
        catch(Exception e)
        {
            System.out.println(e);

        }

    }
}
