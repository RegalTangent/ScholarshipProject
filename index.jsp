<%-- 
    Document   : index
    Created on : Mar 21, 2016, 10:35:52 PM
    Author     : Richard
--%>

<%@page import="org.mypackage.Scholarship.*" %>
<%@page import="java.util.*" %>
<%@page import="java.sql.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Louisiana Tech University</title>
	</head>
	<body>
		<h1>Requirements</h1>
		<h3>
                        <!-- Java function to pull the options for each requirement
                        on the database, then returns everything as a single string-->
			<%= getRequirementsList() %>
		</h3>
	</body>
</html>

<%!
private String getRequirementsList()
{
    // generic variable to hold all strings
    String msg = "";
    // get the requirements and then save them into an array list
    getRequirements req = new getRequirements();
    ArrayList<Requirement> reqs = req.getRequirements();
    // go through each requirement number
    for(int reqN=0;reqN < req.getNumberOfRequirements() ;reqN++)
    {   
        // go through all the options for the current requirement and get the text name for it
        for(int opt=0;opt < reqs.get(reqN).getNumberOfOptions();opt++)
        {
            // add the current option to the message then go to the next line
            msg += reqs.get(reqN).getOptions().get(opt).getText() + "<br>";
        }
        // add an empty line between requirements for easy readability
        msg += "<br>";
    }

    // return the completed message
    return msg;
}
%>