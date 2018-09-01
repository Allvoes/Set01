

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <s:form action="insert" method="post" theme="simple">
            ID <s:textfield name="employeeid" label="employeeid"/>
            Pass <s:password name="password" label="password"/>
            Name <s:textfield name="name" label="name"/>
            Age <s:textfield name="age" label="age"/>
            <s:submit value="Insert"/>
        </s:form>
    </body>
</html>
