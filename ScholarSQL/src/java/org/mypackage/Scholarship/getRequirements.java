/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.Scholarship;
/**
 *
 * @author Joshua
 */
 
import java.sql.DriverManager;
import java.util.ArrayList;
import java.sql.*;

public class getRequirements 
{
    //crates an arraylist of requirements based on a sql search of our database
    
    private ArrayList<Requirement> Requirements = new ArrayList<Requirement>();
   private int NumberOfRequirements = 0;
   
   //constructor
   public getRequirements()
   {}
   
   //methed
    public ArrayList<Requirement> getRequirements()
    {
      ResultSet rs = getResultSet();
      try{
          int lastRID=0;
          int arraySize=0;
      while(rs.next())
      {
          if(rs.getInt("ID")== lastRID)
          {
             Requirements.get(arraySize - 1).addOption(-1, -1,rs.getString("Text") , rs.getInt("OptionOrInput"));
          }
          else
          {
              //creat new requirement
             Requirements.add(new Requirement(rs.getInt("ID"),rs.getString("Name"),rs.getString("Discription")));
             lastRID = rs.getInt("ID");
             arraySize++;
             Requirements.get(arraySize - 1).addOption(-1, -1,rs.getString("Text") , rs.getInt("OptionOrInput"));
             
          }
      
      
      }
      
         NumberOfRequirements= arraySize;
      }
      catch(Exception e)
      {}
      
      return Requirements;
    }

    public int getNumberOfRequirements()
    {
        return NumberOfRequirements;
    
    }
    
    public static ResultSet getResultSet()
    {
        ResultSet rs = null;
        
        String Database_URL = "jdbc:mysql://172.31.5.11/LMA_TestProduction";
        try{
            Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(Database_URL, "jlr072", "P64W");
        Statement st = connection.createStatement();
         rs = st.executeQuery("SELECT requirements.ID, Name, Discription, options.Text, options.OptionOrInput\n" +
                                        "FROM  `requirements` \n" +
                                        "RIGHT JOIN options ON requirements.ID = options.RequirementID\n" +
                                        "LIMIT 0 , 70");
        
        
        
       
          
        }
        catch(Exception e)
        {e.printStackTrace();}
        
        
             return rs;
        
    }
}
