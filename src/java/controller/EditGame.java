package controller;

import Converter.ProductConverter;
import common.ImageUtils;
import common.ReadFileUtils;
import controller.dto.ProductDTO;
import model.Entity.product;
import repository.ProductBillRepository;
import repository.TypeProductRepository;
import repository.impl.ProductBillRepositoryImpl;
import repository.impl.ProductRepositoryImpl;
import repository.impl.TypeProductRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

public class EditGame extends HttpServlet {



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
        String action = request.getParameter("action");

        switch (action) {
            case "EDIT" : {
                editGame(request, response);
                break;
            }
            case "DELETE" :{
                deleteGame(request, response);
                break;
            }
        }
        processRequest(request, response);
    }



    protected void deleteGame(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ProductRepositoryImpl productRepository = new ProductRepositoryImpl();
        product product = productRepository.findProductById(id);
        if (product != null) {
            new ProductBillRepositoryImpl().DeleteProductBillByProductId(id);
            productRepository.deleteProductById(id);
            new TypeProductRepositoryImpl().deleteProductBillByProductId(id);
            response.sendRedirect("searchGamePage.jsp");
        }
        else {
            response.sendRedirect("editGamePages.jsp");
            return;
        }
    }
    protected void editGame(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nameProduct = request.getParameter("game-name");
        String imageProduct = request.getParameter("game-img");
        String descriptionProduct = request.getParameter("game-description");
        String linkProduct = request.getParameter("game-link");
        String priceProduct = request.getParameter("game-price");
        LocalDate date =LocalDate.now();
        String dateCreated = date.toString();

//        String nameProduct, String imageProduct,
//                String productDescription, String linkKeyProduct,String priceForBuyProduct, int userId,String dateCreated
        ProductDTO productDTO = new ProductDTO(id,nameProduct,imageProduct,descriptionProduct, dateCreated,linkProduct,priceProduct);
        List<product> products = new ProductRepositoryImpl().ListProduct();
        ProductRepositoryImpl productRepository = new ProductRepositoryImpl();
        boolean check = false;
        for (product product : products) {
            if (product.getProductId() == productDTO.getIdProduct()) {
                check = true;
                break;
            }
        }

        if (check) {
            productRepository.updateProduct(productDTO);
            response.sendRedirect("searchGamePage.jsp");
            return;
        }
        else {
            response.sendRedirect("EditGame.jsp");
            return;
        }

    }

}