package model.repository.impl;

import Converter.ProductConverter;
import common.ImageUtils;
import controller.dto.ProductDTO;
import db.ConnectDB;
import model.Entity.Product;
import model.repository.ProductRepository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {

    @Override
    public void addProduct(ProductDTO productDTO) {
        String sql = "INSERT INTO master.products (Productname, Productimage, ProductDescription, DateOfUpdate, LinkKeyGame,Price, Userid, Typeid) Values (?,?,?,?,?,?,?,?)";
        ImageUtils imageUtils = new ImageUtils();
        try{
            Product product = new ProductConverter().convertProductDTOToProductEntity(productDTO);
            imageUtils.saveThumbnail(productDTO, product);
            ConnectDB db = new ConnectDB();
            Connection con = db.openConnecion();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, product.getProductName());
            stmt.setString(2, product.getProductImage());
            stmt.setString(3, product.getDescription());
            stmt.setString(4, product.getDateOfUpdate());
            stmt.setDouble(6, product.getPrice());
            stmt.setInt(7,product.getUserId());
            stmt.setInt(8,product.getTypeProductId());
            stmt.setString(5, product.getLinkKeyGame());
            stmt.executeUpdate();
            con.close();
            stmt.close();
        }catch(Exception e){
         e.printStackTrace();}
    }

    public int findIdProductByName(String name)  {
        try {
            ConnectDB db = new ConnectDB();
            Connection con = db.openConnecion();
            String sql = "SELECT Productid FROM products WHERE Productname LIKE '%" + name + "%'";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, name);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return rs.getInt("Productid");
            }
            preparedStatement.close();
            con.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    @Override
    public List<Product> ListProduct() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM master.products ";
        try {
            ConnectDB db = new ConnectDB();
            Connection con = db.openConnecion();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getInt(1));
                product.setProductName(rs.getString(2));
                product.setProductImage(rs.getString(3));
                product.setDateOfUpdate(rs.getString(5));
                product.setDescription(rs.getString(4));
                product.setLinkKeyGame(rs.getString(6));
                product.setPrice(rs.getFloat(7));
                products.add(product);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public Product findProductById(int id) {
        String sql = "SELECT * FROM master.products WHERE Productid = " + id;
        try {
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.openConnecion();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getInt(1));
                product.setProductName(rs.getString(2));
                product.setProductImage(rs.getString(3));
                product.setDateOfUpdate(rs.getString(5));
                product.setDescription(rs.getString(4));
                product.setLinkKeyGame(rs.getString(6));
                product.setPrice(rs.getFloat(7));
                product.setUserId(rs.getInt(8));
                product.setTypeProductId(rs.getInt(9));
                return product;

            }
            rs.close();
            stmt.close();
            con.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Product findProductByName(String name) {
        String sql = "Select * from products where Productname Like '% " + name + "%'" ;
        try {
            Product product = new Product();
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.openConnecion();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                product.setProductId(rs.getInt(1));
                product.setProductName(rs.getString(2));
                product.setProductImage(rs.getString(3));
                product.setDescription(rs.getString(4));
                product.setDateOfUpdate(rs.getString(5));
                product.setLinkKeyGame(rs.getString(6));
                product.setPrice(rs.getFloat(7));
                product.setUserId(rs.getInt(8));
                product.setTypeProductId(rs.getInt(9));
                return product;
            }
            rs.close();
            stmt.close();
            con.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
