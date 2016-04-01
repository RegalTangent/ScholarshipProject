package org.mypackage.Scholarship;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Joshua
 */

//import  Options;
import org.mypackage.Scholarship.Option; 
import java.util.ArrayList;
import java.lang.String;

public class Requirement {
    private int NumberOfOptions=0;
    private int RequrimentID;
    private String Name;
    private String Discription;
    private ArrayList<Option> Options = new ArrayList<Option>();
    
    
    public Requirement(int RequrimentID,String Name,String Discription)
    {
        //creats an requirement with basic info
        this.RequrimentID = RequrimentID;
        this.Name = Name;
        this.Discription = Discription;
        
    }
    
    void addOption(int ID, int reqID, String text,int OptOrInput)
    {
        Option option = new Option( ID,  reqID,  text, OptOrInput);
        Options.add(option);
        this.NumberOfOptions++;
    }
     
    public ArrayList<Option> getOptions()
    {
        return Options;
    }
    
    
    public String getDiscription()
    {
    return Discription;
    }
    
    public String getName()
    {
    return Name;
    }
    
    public int getRequrimentID()
    {
    return RequrimentID;
    }
    
    public int getNumberOfOptions()
    {
        
        return NumberOfOptions;
    }
    
}
