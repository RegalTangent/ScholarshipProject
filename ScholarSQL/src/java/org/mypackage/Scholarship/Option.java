package org.mypackage.Scholarship;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.lang.String;
/**
 *
 * @author Joshua
 */
public class Option 
{
 private int OptionID;
 private int RequirementID;
 private String Text;
 private int OptionOrInput;
 
 public Option(int ID, int reqID, String text,int OptOrInput)
 {
     OptionID = ID;
     RequirementID = reqID;
     this.Text=text;
     OptionOrInput = OptOrInput;
 }
    
 public int getRequirementID()
 {
     return RequirementID;
 }
 
 public int getOptionID()
 {
     return OptionID;
 }
 
 
  public String getText()
 {
     return Text;
 }
  
   public int getOptionOrInput()
 {
     return OptionOrInput;
 }
 
}
