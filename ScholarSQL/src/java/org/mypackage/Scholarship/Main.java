/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.Scholarship;
import java.util.ArrayList;

/**
 *
 * @author Joshua
 */
public class Main {
    
    
    public static void main(String [] args)
    {
         getRequirements req = new getRequirements();
         ArrayList<Requirement> reqs = req.getRequirements();
        for(int reqN=0;reqN < req.getNumberOfRequirements() ;reqN++)
        {
            for(int opt=0;opt < reqs.get(reqN).getNumberOfOptions();opt++)
            {
                System.out.println(reqs.get(reqN).getOptions().get(opt).getText());
            }
        }
    }
}
