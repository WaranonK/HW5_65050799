<%-- 
    Document   : studentList
    Created on : Oct 3, 2025, 7:50:58 PM
    Author     : User
--%>

<%@page import="model.Student"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div style="margin-top: 20px;">
    <h3>Student List</h3>
    <table border="1" cellpadding="5" cellspacing="0">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>GPA</th>
            </tr>
        </thead>
        <tbody>
            <% 
                // Get the list of students from the request attribute set by the Controller
                List<Student> studentList = (List<Student>) request.getAttribute("students");
                
                // Iterate through the list and print each row
                if (studentList != null && !studentList.isEmpty()) {
                    for (Student student : studentList) {
            %>
            <tr>
                <td><%= student.getId() %></td>
                <td><%= student.getName() %></td>
                <td><%= student.getGpa() %></td>
            </tr>
            <% 
                    }
                } else {
            %>
            <tr>
                <td colspan="3">No students found in the database.</td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
</div>