
package controller;


import model.Entity.product;
import repository.DAO.ProductsDAO;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Admin//
 */
public class CategoryServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sortCriteria = request.getParameter("command");
        List<product> products = new ProductsDAO().getProductsSortedBy(sortCriteria);
        request.setAttribute("products",products);

        request.getRequestDispatcher("categoryPage.jsp").include(request,response);

    }

}
