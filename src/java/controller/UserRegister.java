


package controller;

import model.dto.userDTO;
import model.repository.impl.userRepositoryimpl;
import model.repository.userRepository;

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
public class UserRegister extends HttpServlet {




    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");



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
        String Username = null;
        String password = null;
        String Email = null;
        String phone = null;
        String day = null;
        String month = null;
        String year = null;
        String confirmpassword = null;



        Username = request.getParameter("username");
        Email = request.getParameter("email");
        day = request.getParameter("day");
        month = request.getParameter("month");
        year = request.getParameter("year");
        phone = request.getParameter("phonenumber");
        password = request.getParameter("password");
        confirmpassword = request.getParameter("comfirm_password");
        int a = 1;
        userDTO user = new userDTO(Username, Email, day, month, year, phone, password, confirmpassword);

        userRepositoryimpl urimpl = new userRepositoryimpl();
        urimpl.Register(user);
        request.getRequestDispatcher("index.jsp").forward(request, response);


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
    public static void main(String[] args) {
        userDTO u = new userDTO();
        u.setUsername("khang");
        u.setEmail("khang@gmail.com");
        u.setPhonenumber("09055577689");
        u.setDay("14");
        u.setMonth("02");
        u.setYear("2004");
        u.setPassword("123456");
        u.setComfirmPassword("123456");
        userRepositoryimpl userRepository = new userRepositoryimpl();
        userRepository.Register(u);
    }
}
