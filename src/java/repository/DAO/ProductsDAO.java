package repository.DAO;

import db.ConnectDB;
import model.Entity.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductsDAO {
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
                product.setProductImage(rs.getString("Prodcutimage"));
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



    public static List<product> getProductsSortedBy(String sortCriteria) {
        String query = "SELECT * FROM [dbo].[Products] ORDER BY ";
        switch (sortCriteria) {
            case "Price":
                query += "price";
                break;
            case "Name":
                query += "productName";
                break;
            case "mostRecent":
                query += "dateOfUpdate DESC";
                break;
            default:
                query += "productId";
        }

        List<product> products = new ArrayList<>();
        ConnectDB db = ConnectDB.getInstance();
        Connection con ;

        try {
            con = db.openConnecion();
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                products.add(new product(
                        rs.getInt("Productid"),
                        rs.getString("Productname"),
                        rs.getString("Prodcutimage"),
                        rs.getString("ProductDescription"),
                        rs.getString("DateOfUpdate"),
                        rs.getString("LinkKeyGame"),
                        rs.getFloat("Price"),
                        rs.getInt("UserId"),
                        rs.getInt("TypeId")
                ));
            }
        } catch (Exception ignore ){

        }

        return products;
    }
}
