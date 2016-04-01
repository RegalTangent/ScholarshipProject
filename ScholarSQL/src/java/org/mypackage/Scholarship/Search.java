/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.Scholarship;
import java.util.ArrayList;
import java.sql.DriverManager;
import java.sql.*;
import java.util.Arrays;
/**
 *
 * @author Joshua Roberts
 */
public class Search 
{
    // create a dynamic array list for all of the criteria
    ArrayList<Criteria> Criteria = new ArrayList<Criteria>();
    // also initizalize an array list for the scholarships
   private ArrayList<Scholarship> AllScholarships ;
    
    // search function
    public Search()
    {
        // populate the list of scholarships
        getScholarship sch = new getScholarship();
        AllScholarships= new ArrayList<Scholarship>(sch.getScholarship());

       
    }
    
    // function for adding criteria from the array list to a temp. variable
    public void inputCriteria(ArrayList<Criteria> cr)
    {
        Criteria = cr;
    }
    
    // function to properly sort the results based on the input from the user
    public ArrayList<Scholarship> getSearchResults()
    {
        // create a new dynamic array list with the scholarships post search
        // basically this array list holds the search results to be redisplayed to the user
        ArrayList<Scholarship> Filteredscholarship = new ArrayList<Scholarship>();
        
       
       //gets list of all the scholarship requirements from the scholarship_requirements table on the database
       ArrayList<ScholarshipRequirement> scholarshipReq = getScholarshipRequirements();
       
       int curSchoID = 0; // ID number of the current scholarship for reference
       boolean accepted =false;
       
       // go through all the scholarship requirements
       for(int srN = 0; srN < scholarshipReq.size(); srN++)
       {
           // check to make sure we are looking at the correct scholarship based on the ID number
           if(curSchoID != scholarshipReq.get(srN).getScholarshipID())
           {
           //new or next scholarship
               
               //if last scholarship is accepted by search criteria then add to filtered list else do not add
               if(accepted)
               {
                  Filteredscholarship.add( getScholarshipByID(curSchoID)  );
               }
               
               curSchoID = scholarshipReq.get(srN).getScholarshipID();
               accepted = true;
               
           }
           else
           {
               //same scholarhsip
               //if scholarship is alread rejected then move to next req
               if(!accepted)
               {
                   continue;
               }
           }
           //do acceptance criteria comparison
           
           String AC = scholarshipReq.get(srN).getAcceptanceCriteria();
           int ReqID = scholarshipReq.get(srN).getRequirementID();
           String userInput = getCriteriaByReqID(ReqID);
           
           // if the user does not input any search criteria, just continue to return everything
           if(userInput == null)
           {
                continue;
           }
           
           
           if(scholarshipReq.get(srN).getInequality() == 1)
           {//if it is an inequality
           
           }
           //if it is not an inequality
           else if(scholarshipReq.get(srN).getInequality() == 0)
           {
               accepted = false;
               String[] ACparts = AC.split(",");
               for(int parts=0; parts < ACparts.length  ;parts++)
               {
                   if(userInput.compareToIgnoreCase(ACparts[parts]) == 0  )
                   {
                       accepted = true;
                       break;
                   }
               }
           }
       }
       
       //check last one 
        if(accepted)
        {
           Filteredscholarship.add( getScholarshipByID(curSchoID)  );
        }
       
        
        
        
        return Filteredscholarship;
    }
    
    // function for grabbing a requirement's ID number from the database
    private String getCriteriaByReqID(int reqID)
    {
        for(int index=0; index < Criteria.size() ;index++)
        {
            if(Criteria.get(index).getReqID() == reqID)
            {
                return Criteria.get(index).getInput();
            }
        }
        
        return null;
    }
    
    // function to grab a scholarship's ID number from the database
    private Scholarship getScholarshipByID(int ID)
    {
        for(int arraypos = 0;arraypos < AllScholarships.size() ; arraypos++)
        {
            if(AllScholarships.get(arraypos).getID() == ID)
            {
                return AllScholarships.get(arraypos);
            }
        }


 System.out.println("null");

        return null;
    }
    
    // function to grab all scholarship requirements from the database and return everything in an array list
    public ArrayList<ScholarshipRequirement> getScholarshipRequirements()
    {
         ResultSet rs = null;
         ArrayList<ScholarshipRequirement> schreq = new ArrayList<ScholarshipRequirement>();

            String Database_URL = "jdbc:mysql://172.31.5.11/LMA_TestProduction";
            try{
                Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(Database_URL, "jlr072", "P64W");
            Statement st = connection.createStatement();
             rs = st.executeQuery("SELECT *\n" +
                                            "FROM  `scholarship_requirements` \n" );



             while(rs.next())
             {
                 schreq.add(new ScholarshipRequirement( rs.getInt(1), rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getInt(5),rs.getInt(6) ) );
             
             }


            }
            catch(Exception e)
            {e.printStackTrace();}


            return schreq;

        }
        
    }

