package repository.DAO;

import db.ConnectDB;
import model.Entity.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductsDAO {
    public int getTotalProducts() throws Exception {
        int rows = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ConnectDB db = ConnectDB.getInstance();
        String query = "select count(*) from Products";

        try {
            conn = db.openConnecion();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                rows = rs.getInt(1);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            conn.close();
            rs.close();
            ps.close();
        }
        return rows;
    }
    public List<product> getProducts(int page, int pageSize) {
        List<product> products = new ArrayList<>();
        int offset = (page - 1) * pageSize;
        String sql = "SELECT * FROM Products ORDER BY Productname LIMIT ? OFFSET ?";
        ConnectDB db = ConnectDB.getInstance();
        Connection con;
        try {
            con = db.openConnecion();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1,pageSize);
            stmt.setInt(2,offset);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                product product = new product();
                product.setProductId(rs.getInt("Productid"));
                product.setProductName(rs.getString("Productname"));
                product.setProductImage(rs.getString("Productimage"));
                product.setProdcuctDescription(rs.getString("ProductDescription"));
                product.setDateOfUpdate(rs.getString("DateOfUpdate"));
                product.setLinkKeyGame(rs.getString("LinkKeyGame"));
                product.setPrice(rs.getFloat("Price"));
                product.setUserId(rs.getInt("UserId"));
                product.setTypeId(rs.getInt("TypeId"));
                products.add(product);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return products;
    }
    public List<product> getProducts(){
        List<product> products = new ArrayList<product>();

        String sql = "SELECT * FROM [dbo].[Products]";
        ConnectDB db = ConnectDB.getInstance();
        Connection con ;
        try {
            con = db.openConnecion();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                product product = new product();
                product.setProductId(rs.getInt("Productid"));
                product.setProductName(rs.getString("Productname"));
                product.setProductImage(rs.getString("Productimage"));
                product.setProdcuctDescription(rs.getString("ProductDescription"));
                product.setDateOfUpdate(rs.getString("DateOfUpdate"));
                product.setLinkKeyGame(rs.getString("LinkKeyGame"));
                product.setPrice(rs.getFloat("Price"));
                product.setUserId(rs.getInt("UserId"));
                product.setTypeId(rs.getInt("TypeId"));
                products.add(product);
            }
            rs.close();
            stmt.close();
            con.close();
            return products;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }



    public static List<product> getProductsSortedBy(String sortCriteria, int page, int pageSize) {
        String query = "SELECT * FROM [dbo].[Products] ORDER BY ";

        // Determine the sorting column based on the sortCriteria
        switch (sortCriteria) {
            case "Price":
                query += "Price";
                break;
            case "Name":
                query += "Productname";
                break;
            case "mostRecent":
                query += "DateOfUpdate DESC";
                break;
            default:
                query += "Productid";
        }

        // Add pagination to the query
        int offset = (page - 1) * pageSize;
        query += " OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

        List<product> products = new ArrayList<>();
        ConnectDB db = ConnectDB.getInstance();

        try (Connection con = db.openConnecion();
             PreparedStatement stmt = con.prepareStatement(query)) {

            // Set the pagination parameters
            stmt.setInt(1, offset);
            stmt.setInt(2, pageSize);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    products.add(new product(
                            rs.getInt("Productid"),
                            rs.getString("Productname"),
                            rs.getString("Productimage"),
                            rs.getString("ProductDescription"),
                            rs.getString("DateOfUpdate"),
                            rs.getString("LinkKeyGame"),
                            rs.getFloat("Price"),
                            rs.getInt("UserId"),
                            rs.getInt("TypeId")
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return products;
    }

}
