
package controller;

import common.CookieUtils;
import repository.DAO.LoginDAO;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin//
 */
public class LoginServlet extends HttpServlet {

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
//        request.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html;charset=UTF-8");
//        String username = CookieUtils.get("username",request);
//
//        if (username != null && !username.isEmpty()) {
//            request.setAttribute("message","Login ổn");
//            HttpSession session = request.getSession();
//            session.setAttribute("username", username);
//            request.getRequestDispatcher("dashboard.jsp").forward(request, response);
//            return;
//        }
//
//        request.getRequestDispatcher("login.jsp").forward(request, response);
        processRequest(request,response);
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
        response.setContentType("text/html;charset  =UTF-8");
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember_me");
//        if (username != null && password != null){
//            if (new CookieUtils().get(username,request) != null){
//                HttpSession session = request.getSession();
//                session.setAttribute("username", username);
//
//            }
//        }
        int check = new LoginDAO().LoginCheck(username,password);
        if (check == 0) {
            request.setAttribute("message", "Sai tên đăng nhập hoặc mật khẩu");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            // Tạo session cho người dùng
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            // Nếu chọn "Remember me", lưu cookie
            if ("on".equals(remember)) {
                CookieUtils.add("username", username, 1, response);
            }

            // Chuyển hướng tùy thuộc vào loại người dùng
            if (check == 1) {
                response.sendRedirect("mainPage.jsp");
            } else if (check == 2) {
                response.sendRedirect("mainPage.jsp");
            }
        }

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
