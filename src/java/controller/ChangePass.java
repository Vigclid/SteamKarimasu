package controller;


import common.LoginSession;

import model.Entity.user;
import repository.impl.userRepositoryimpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


public class ChangePass extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        String oldPass = request.getParameter("old-password");
        String newPass = request.getParameter("new-password");
        String confirmPass = request.getParameter("confirm-password");

        user user = new LoginSession().getLoginSession(request);
//        if ((user.getPass().equals(oldPass) && newPass.equals(confirmPass)) || !oldPass.isEmpty() || !newPass.isEmpty() || !confirmPass.isEmpty() || oldPass != null ) {
//            user.setPass(newPass);
//            userRepositoryimpl userRepositoryimpl = new userRepositoryimpl();
//            userRepositoryimpl.updateUserPassword(user);
//            writer.println("<script>");
//            writer.println("alert('Password changed successfully');");
//            writer.println("location='profilePage.jsp';");
//            writer.println("</script>");
//        }
        if (!oldPass.equals(user.getPassword()) || !newPass.equals(confirmPass) ) {
            writer.println("<script>");
            writer.println("alert('Error. Your Password is incorrect');");
            writer.println("location='changePassPage.jsp';");
            writer.println("</script>");
        } else if (oldPass.isEmpty() || oldPass == null || newPass.isEmpty() || newPass == null || confirmPass.isEmpty() || confirmPass == null) {
            writer.println("<script>");
            writer.println("alert('Error. Enter full required field');");
            writer.println("location='changePassPage.jsp';");
            writer.println("</script>");
        }
        else {
            user.setPassword(newPass);
            userRepositoryimpl userRepositoryimpl = new userRepositoryimpl();
            userRepositoryimpl.updateUserPassword(user);
            writer.println("<script>");
            writer.println("alert('Password changed successfully');");
            writer.println("location='profilePage.jsp';");
            writer.println("</script>");
        }
    }
}
