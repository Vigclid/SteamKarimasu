package repository.impl;

import db.ConnectDB;
import model.Entity.ListRent;
import model.Entity.user;
import repository.ListRentRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ListRentRepositoryImpl implements ListRentRepository {


    @Override
    public void addListRent(int productID, int userID) {
        String sql = "INSERT INTO [dbo].[ListRent] (Userid, Productid) VALUES (?,?)";
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
        String sql = "select * from [dbo].[ListRent] WHERE Userid like ? and Productid like ?";
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


    @Override
    public List<ListRent> getListRent(int idProduct) {
        List<ListRent> list = new ArrayList<ListRent>();
        String sql = "SELECT * from [dbo].[ListRent] where Productid = " + idProduct;
        try {
            ConnectDB db = new ConnectDB();
            Connection conn = db.openConnecion();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ListRent rent = new ListRent();
                rent.setListRentId(rs.getInt(1));
                rent.setUserId(rs.getInt(2));
                rent.setProductId(rs.getInt(3));
                list.add(rent);
            }
            rs.close();
            ps.close();
            conn.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }




    @Override
    public void deleteByListRentId(int id) {
        String sql = "Delete from listrent where idList = ?";
        try {
            ConnectDB db = new ConnectDB();
            Connection conn = db.openConnecion();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
