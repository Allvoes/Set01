<%-- 
    Document   : ViewAll
    Created on : Jan 19, 2015, 10:00:34 AM
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
        <s:if test="#session.ADMIN != ''">
            <font color="purple">
            <h1>Welcome, <s:property value="%{#session.ADMIN}"/></h1>
            </font>
        </s:if>
            <form action="insert.jsp">
                <input type="submit" value="Insert"/>
            </form>
        <s:if test="employee.size > 0">
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>Employee ID</th>
                        <th>Password</th>
                        <th>Name</th>
                        <th>Age</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <s:iterator value="employee" status="employeeStatus">
            <tr>
                <td><s:property value="%{#employeeStatus.count}"/></td>
                <td><s:property value="employeeid"/></td>
                <s:set name="test" value="employeeid"/>
                <td><s:property value="password"/></td>
                <td><s:property value="name"/></td>
                <td><s:property value="age"/></td>
                <td>
                    <s:url id="deleteLink" action="delete">
                        <s:param name="employeeidProcess" value="employeeid"/>
                    </s:url>
                    <s:a href="%{deleteLink}">Delete</s:a>
                </td>
            </tr>
            </s:iterator>
        </tbody>
    </table>
</s:if>
</body>
</html>
