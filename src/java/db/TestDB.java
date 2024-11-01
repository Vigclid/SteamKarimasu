package db;

import model.Entity.product;
import repository.DAO.ProductsDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TestDB implements DatabaseInfo{
    public static void main(String[] args) throws Exception {
        ProductsDAO dao = new ProductsDAO();
        List<product> products = new ArrayList<product>();
        products = dao.getProducts();
        for (product p : products) {
            System.out.println(p);
        }
    }

}
