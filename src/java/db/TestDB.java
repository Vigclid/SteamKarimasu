package db;

import model.Entity.product;
import repository.DAO.ProductsDAO;
import repository.impl.ProductRepositoryImpl;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestDB implements DatabaseInfo{
    public static void main(String[] args) throws Exception {
        ProductRepositoryImpl productRepository = new ProductRepositoryImpl();
        List<product> products = productRepository.ListProductByName();
        for (product p : products){
            System.out.println(p);
        }
    }

}
