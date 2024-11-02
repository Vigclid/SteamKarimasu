package controller;

import common.ResetService;
import model.Entity.TokenForgetPassword;
import model.Entity.User;
import model.repository.impl.TokenForgotRepositoryImpl;
import model.repository.impl.userRepositoryimpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class ResetPasword extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Final Project</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Login at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String Email = request.getParameter("confirm_email");
        User user = new userRepositoryimpl().findUserByEmail(Email);
        if (user == null) {
            request.setAttribute("mess", "Email not Exist");
            request.getRequestDispatcher("forgot.jsp").forward(request, response);
        }
            ResetService resetService = new ResetService();
            String token = resetService.generateToken();
            String resetLink = "http://localhost:5000/StudentManagement_Web_exploded/ResetPasword/token=" + token;
                TokenForgetPassword tokenForgetPassword = new TokenForgetPassword(user.getUserid(), false,resetLink, LocalDateTime.MIN);

            TokenForgotRepositoryImpl tokenForgotRepository = new TokenForgotRepositoryImpl();
            boolean isInsert = tokenForgotRepository.insertTokenForgot(tokenForgetPassword);
            if(!isInsert) {
                    request.setAttribute("mess", "Error insert TokenForgot");
                    request.getRequestDispatcher("forgot.jsp").forward(request, response);
                    return;
            }
            boolean checkSendEmail = resetService.SendMail(Email, resetLink, user.getUsername());
            if(!checkSendEmail) {
                request.setAttribute("mess", "Error send Email");
                request.getRequestDispatcher("forgot.jsp").forward(request, response);
                return;
            }
            request.setAttribute("mess", "Email sent successfully. Please check your email to reset password.");
            request.getRequestDispatcher("forgot.jsp").forward(request,response);

    }
}
