
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
        int page = 1;
        int pageSize = 10;
        String sortCriteria = "Name";


        String pageParam = request.getParameter("page");
        if (pageParam != null) {
            page = Integer.parseInt(pageParam);
        }

        String commandParam = request.getParameter("command");
        if (commandParam != null && !commandParam.isEmpty()) {
            sortCriteria = commandParam;
        }

        ProductsDAO productDAO = new ProductsDAO();
        List<product> products = productDAO.getProductsSortedBy(sortCriteria, page, pageSize);

        int totalProducts = 0;
        try {
            totalProducts = productDAO.getTotalProducts();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        int totalPages = (int) Math.ceil((double) totalProducts / pageSize);

        request.setAttribute("products", products);
        request.setAttribute("currentPage", page);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("sortCriteria", sortCriteria);

        request.getRequestDispatcher("categoryPage.jsp").forward(request, response);
    }

}
