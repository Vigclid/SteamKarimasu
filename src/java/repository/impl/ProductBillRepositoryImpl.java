package repository.impl;

import db.ConnectDB;
import repository.ProductBillRepository;
import repository.ProductRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductBillRepositoryImpl implements ProductBillRepository {
    @Override
    public void DeleteProductBillByProductId(int productId) {
        String sql = "DELETE FROM productbill WHERE productid = " + productId;
        try{
            ConnectDB db = new ConnectDB();
            Connection conn = db.openConnecion();
            conn.createStatement().executeUpdate(sql);
            conn.close();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    @Override
    public void addProductBill(int productID, int userID) {
        String sql = "INSERT INTO [dbo].[Productbill] (Userid, Productid) VALUES (?,?)";
        try {
            ConnectDB db = new ConnectDB();
            Connection con = db.openConnecion();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, userID);
            stmt.setInt(2, productID);

            stmt.executeUpdate();
            stmt.close();
            con.close();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean checkUserHaveProduct(int productID, int userID) {
        String sql = "select * from [dbo].[Productbill] WHERE Userid like ? and Productid like ?";
        try {
            ConnectDB db = new ConnectDB();
            Connection con = db.openConnecion();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, userID);
            stmt.setInt(2, productID);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                return true;
            }

            rs.close();
            stmt.close();
            con.close();

        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
