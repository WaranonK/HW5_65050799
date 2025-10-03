/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;
import model.StudentTable;
/**
 *
 * @author User
 */
@WebServlet(name = "AddStudentServlet", urlPatterns = {"/addstudent"})
public class AddStudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double gpa = Double.parseDouble(request.getParameter("gpa"));

        Student student = new Student(id, name, gpa);

        boolean success = StudentTable.insertStudent(student);

        request.setAttribute("students", StudentTable.findAllStudents());

        if (success) {
            request.setAttribute("student", student);
            RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("fail.jsp");
            rd.forward(request, response);
        }
    }
}
