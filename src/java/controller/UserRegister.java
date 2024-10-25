
package controller;

import model.Entity.User;
import model.repository.impl.userRepositoryimpl;
import controller.dto.userDTO;
import model.repository.impl.userRoleRepositoryImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static java.awt.SystemColor.window;

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
        PrintWriter out = response.getWriter();
        String Username = request.getParameter("username");
        String Email = request.getParameter("email");
        String day = request.getParameter("day");
        String month = request.getParameter("month");
        String year = request.getParameter("year");
        String phone = request.getParameter("phonenumber");
        String Pass = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm_password");

        if (Username == null || Email == null || phone == null || Pass == null || confirmPassword == null || day == null || month == null || year == null ||
                Username.isEmpty() || Email.isEmpty() || phone.isEmpty() || Pass.isEmpty() || confirmPassword.isEmpty() || day.isEmpty() || month.isEmpty() || year.isEmpty()) {
            out.println("<script type=\"text/javascript\">");
            out.println("location='register.jsp';");
            out.println("alert('Error. Please fill all fields');");
            out.println("</script>");
            return; // Dừng thực thi
        } else if (!Pass.equals(confirmPassword)) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Error. Passwords do not match');");
            out.println("location='register.jsp';");
            out.println("</script>");
            return;
        }
        else if(phone.length() != 10 &&  !phone.startsWith("0"))  {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Error. Phone number must have (10 - 12) number characters and start with 0')");
            out.println("location='register.jsp';");
            out.println("</script>");
            return; // Dừng thực thi
        }
        userDTO user = new userDTO(Username, Email, phone, day, month, year, Pass, confirmPassword);
        userRepositoryimpl urimpl = new userRepositoryimpl();
        List<User> userList = urimpl.getAllUsers();
        boolean userExists = false;
        for (User ur : userList) {
            if (ur.getPhonenumber().equals(user.getPhonenumber()) || ur.getEmail().equals(user.getEmail()) || ur.getUsername().equals(user.getUsername())) {
                userExists = true;
                break; // Nếu đã tìm thấy, không cần kiểm tra nữa
            }
        }

        if (userExists) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Error. Username or Email already exists');");
            out.println("location='register.jsp';");
            out.println("</script>");
        } else {
            urimpl.Register(user);
            out.println("<script type=\"text/javascript\">");
            out.println("alert('User registered successfully');");
            out.println("location='login.jsp';");
            out.println("</script>");
        }

    }
}
