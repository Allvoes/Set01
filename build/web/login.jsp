<%-- 
    Document   : login
    Created on : Jan 19, 2015, 10:00:24 AM
    Author     : David
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <h1>Login</h1>
        <s:form action="login" method="post" >
            <s:textfield name="employeeid" label="ID"/> <br/>
            <s:password name="password" label="Pass"/> <br/>
            <s:submit value="Login"/>
            <s:reset value="Reset"/>
        </s:form>
    </body>
</html>
