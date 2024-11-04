/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import common.LoginSession;
import model.Entity.product;
import model.Entity.user;
import repository.DAO.ProductsDAO;
import repository.ListRentRepository;
import repository.impl.ListRentRepositoryImpl;
import repository.impl.ProductBillRepositoryImpl;
import repository.impl.ProductRepositoryImpl;
import repository.impl.userRepositoryimpl;

import java.io.IOException;
import java.io.PrintWriter;
import javax.management.JMRuntimeException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class ProductServlet extends HttpServlet {

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
            out.println("<title>Servlet ProductServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductServlet at " + request.getParameter("name_product") + "</h1>");
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
        response.setContentType("text/html; charset=UTF-8");

        String command = request.getParameter("COMMAND");
        switch (command) {
            case "VIEWPAGE": {
                viewGamePage(request,response, command);
                break;
            }
            case "Purchase": {
                viewGamePage(request,response, command);
                break;
            }
            case "Confirm_Purchase": {
                confirmPurchaseGame(request,response);
                break;
            }
            case "Exit" :{
                request.getRequestDispatcher("mainPage.jsp").include(request,response);
                break;
            }
            case "Join" :{
                viewJoinPage(request,response);
                break;
            }
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    void viewGamePage(HttpServletRequest request, HttpServletResponse response , String command) throws ServletException, IOException  {

        product product = new ProductRepositoryImpl().findProductByName(request.getParameter("name_product"));
        request.setAttribute("profile_product",product);

        if (command.equals("VIEWPAGE")) {
            request.getRequestDispatcher("gamePage.jsp").include(request, response);
        }
        if (command.equals("Purchase")) {
            request.getRequestDispatcher("buyGamePage.jsp").include(request, response);
        }
    }

    void confirmPurchaseGame(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        product product = new ProductRepositoryImpl().findProductByName(request.getParameter("name_product"));
        user user = new LoginSession().getLoginSession(request);
        int checkError = new userRepositoryimpl().decreaseKcoin(product.getPrice(),user.getUserId());
        if (checkError == 50001) {
            request.getRequestDispatcher("notEnoughMoney.jsp").include(request,response);
        }

        if (checkError == 1) {
            new ProductBillRepositoryImpl().addProductBill(product.getProductId(),user.getUserId());
            request.setAttribute("profile_product",product);
            request.setAttribute("CheckBuy",true);
            request.getRequestDispatcher("buyGamePage.jsp").include(request,response);
        }


    }

    void viewJoinPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        product product = new ProductRepositoryImpl().findProductByName(request.getParameter("name_product"));
        request.setAttribute("profile_product",product);
        request.getRequestDispatcher("joinRentPage.jsp").include(request,response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
