/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.Scholarship;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author Joshua
 */
public class getScholarship 
{
    
    private ArrayList<Scholarship> scholarships = new ArrayList<Scholarship>();
    private int NumberOfScholarships = 0;
    
    
    public ArrayList<Scholarship> getScholarship()
    {
        ResultSet rs = getResultSet();
        try
        {
            while(rs.next())
            {
                scholarships.add(new Scholarship(rs.getInt("ID"), rs.getString("Name"),rs.getString("Discription"),rs.getString("Link_For_More_Info")));
                NumberOfScholarships++;
            }
        }
        catch(Exception e)
        {
        
        }
        return scholarships;
    }
    
    
    
    public int getNumberOfScholarships()
    {
        return NumberOfScholarships;
    }
    
    
    
    public ResultSet getResultSet()
    {
    ResultSet rs = null;

            String Database_URL = "jdbc:mysql://172.31.5.11/LMA_TestProduction";
            try{
                Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(Database_URL, "jlr072", "P64W");
            Statement st = connection.createStatement();
             rs = st.executeQuery("SELECT *\n" +
                                            "FROM  `scholarships` \n" );





            }
            catch(Exception e)
            {e.printStackTrace();}


                 return rs;

        }

}
    




