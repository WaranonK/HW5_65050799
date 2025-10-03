<%-- 
    Document   : fail
    Created on : Oct 3, 2025, 7:52:37 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Error - Duplicate ID</title>
</head>
<body>
    <h2>Error</h2>
    
    <p style="color: black; font-weight: bold;">There is an existing student with this ID</p>
    
    <hr>
    
    <jsp:include page="studentList.jsp" />
    
    <p><a href="index.html">Back to Add Student</a></p>
</body>
</html>