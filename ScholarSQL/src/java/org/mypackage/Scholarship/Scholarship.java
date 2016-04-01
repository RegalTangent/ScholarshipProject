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
public class Scholarship {
    
    int ID;
    String Name;
    String Discription;
    String Link;
    
    
    public Scholarship(int id,String name, String discription, String link)
    {
        ID = id;
        Name = name;
        Discription = discription;
        Link = link;
    }
    
    
     public int getID()
     {
         return ID;
     }
     
     public String getName()
     {
         return Name;
     }
    
     public String getDiscription()
     {
         return Discription;
     }
     
     public String getLink()
     {
         return Link;
     }
}
