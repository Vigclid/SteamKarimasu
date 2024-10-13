/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import model.Repository.StudentDAO;
import model.Entity.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class StudentServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet StudentServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StudentServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String command = request.getParameter("COMMAND");
        switch (command){
            case "LIST" -> studentList(request,response);
            case "ADD" -> addStudent(request,response);
            case "DELETE" -> deleteStudent(request,response);
            case "BEFORE_UPDATE" -> beforeUpdate(request,response);
            case "UPDATE" -> updateStudent(request,response);
            case "SEARCH" -> searchStudent(request,response);
        }
    }
    protected void studentList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StudentDAO studentDAO = new StudentDAO();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

   //     request.setAttribute("StudentList",studentDAO.getStudents());
        request.getRequestDispatcher("list.jsp").include(request,response);
    }

    protected void addStudent(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StudentDAO studentDAO = new StudentDAO();

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String id = request.getParameter("ID");
        Byte Gender = (byte) (request.getParameter("gender").equals("male") ? 0 : 1);
        LocalDate DOB = LocalDate.parse(request.getParameter("DOB"));
        studentDAO.addStudent(new student(id,name,Gender,DOB));
        studentList(request,response);
    }
    protected void deleteStudent(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StudentDAO studentDAO = new StudentDAO();
        studentDAO.deleteStudent(request.getParameter("studentId"));
        studentList(request,response);
    }
    protected void beforeUpdate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("studentId");
        request.setAttribute("StudentID",id);
        request.getRequestDispatcher("update.jsp").include(request,response);
    }
    protected void updateStudent(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StudentDAO studentDAO =  new StudentDAO();
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        Byte Gender = (byte) (request.getParameter("gender").equals("male") ? 0 : 1);
        LocalDate DOB = LocalDate.parse(request.getParameter("DOB"));
        studentDAO.updateStudent(new student(id,name,Gender,DOB));
        studentList(request,response);
    }
    protected void searchStudent(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StudentDAO studentDAO = new StudentDAO();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String id = request.getParameter("ID");
        String name = request.getParameter("name");
        Byte gender = null;
        LocalDate dob = null;

// Handle null or empty values for gender and DOB
        if (request.getParameter("gender") != null && !request.getParameter("gender").isEmpty()) {
            gender = (byte) (request.getParameter("gender").equals("male") ? 0 : 1);
        }
        if (request.getParameter("DOB") != null && !request.getParameter("DOB").isEmpty()) {
            try {
                dob = LocalDate.parse(request.getParameter("DOB"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        request.setAttribute("StudentList", studentDAO.searchStudents(id, name, gender, dob));
        request.getRequestDispatcher("list.jsp").include(request, response);
    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
