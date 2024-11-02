

package controller;

import common.LoginSession;
import common.cookieUtils;
import controller.dto.ProductDTO;
import model.Entity.Product;
import model.Entity.User;
import model.repository.impl.ProductRepositoryImpl;
import model.repository.impl.userRepositoryimpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 *
 * @author Admin//
 */
public class AddGame extends HttpServlet {

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
            out.println("<title>Final Project</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Login at " + request.getContextPath() + "</h1>");
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
        PrintWriter out = response.getWriter();
        String nameGame = request.getParameter("game-name");
        String Image = request.getParameter("file-img");
        String gameDescription = request.getParameter("game-description");
        String gameLink = request.getParameter("game-link");
        String Price = request.getParameter("game-price");
        User user = new LoginSession().getLoginSession(request);
        int userId = user.getUserid();
        LocalDate date =LocalDate.now();
        String dateCreated = date.toString();

        ProductRepositoryImpl productRepository = new ProductRepositoryImpl();
        ProductDTO productDTO = new ProductDTO(nameGame, Image, gameDescription, gameLink, Price,userId, dateCreated);
        List<Product> products = productRepository.ListProduct();
        boolean check = false;
        for(Product product : products) {
            if (product.getProductName().equals(nameGame)) {
                check = true;
                break;
            }
        }

        if (nameGame.isEmpty() || gameDescription.isEmpty() || gameLink.isEmpty() || Price.isEmpty()
        || nameGame == null || gameDescription == null || gameLink == null || Price == null) {
            out.println("<script>alert('Please fill in all fields!');</script>");
            RequestDispatcher rd = request.getRequestDispatcher("AddGame.jsp");
            rd.include(request, response);
        }

        if (check) {
            out.println("<script>alert('Game already exists!');</script>");
            RequestDispatcher rd = request.getRequestDispatcher("AddGame.jsp");
            rd.include(request, response);
        }

        else {
            productRepository.addProduct(productDTO);
            out.println("<script>alert('Game added successfully!');</script>");
            RequestDispatcher rd = request.getRequestDispatcher("ListGame.jsp");
            rd.include(request, response);
        }

    }



}


