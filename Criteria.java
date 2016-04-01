/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.Scholarship;

/**
 *
 * @author Joshua Roberts
 */
public class Criteria 
{

    private int ReqID;
    private String Input;
    
    
    public Criteria( int reqid,String input)
    {
        ReqID = reqid;
        Input = input;
    }
    
    public int getReqID()
    {
    return ReqID;
    }
    
    public String getInput()
    {
    return Input;
    }
    
}
