package repository.impl;

import Converter.ProductConverter;
import common.ImageUtils;
import controller.dto.ProductDTO;
import db.ConnectDB;
import model.Entity.product;
import repository.ProductRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {

    @Override
    public void addProduct(ProductDTO productDTO) {
        String sql = "INSERT INTO [dbo].[Products] (Productname, Prodcutimage, ProductDescription, DateOfUpdate, LinkKeyGame, Price, Userid, Typeid) Values (?,?,?,?,?,?,?,?)";
        ImageUtils imageUtils = new ImageUtils();
        try{
            product product = new ProductConverter().convertProductDTOToProductEntity(productDTO);
            imageUtils.saveThumbnail(productDTO, product);
            ConnectDB db = new ConnectDB();
            Connection con = db.openConnecion();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, product.getProductName());
            stmt.setString(2, product.getProductImage());
            stmt.setString(3, product.getProdcuctDescription());
            stmt.setString(4, product.getDateOfUpdate());
            stmt.setString(5, product.getLinkKeyGame());
            stmt.setDouble(6, product.getPrice());
            stmt.setInt(7,product.getUserId());
            stmt.setInt(8,product.getTypeId());
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
    public List<product> ListProductByName() {
        String sql = "SELECT * FROM master.products ";
        List<product> products = new ArrayList<>();
        product product = new product();
        try {
            ConnectDB db = new ConnectDB();
            Connection con = db.openConnecion();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                product.setProductId(rs.getInt(1));
                product.setProductName(rs.getString(2));
                products.add(product);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return products;
    }
}