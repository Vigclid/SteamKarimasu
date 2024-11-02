package repository.impl;

import common.LoginSession;
import db.ConnectDB;
import model.Entity.CoinBill;
import model.Entity.user;
import repository.CoinBillRepository;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CoinBillRepositoryImpl implements CoinBillRepository {

    @Override
    public boolean checkMGD(String mgd, HttpServletRequest request) {
        user user = new LoginSession().getLoginSession(request);

        String sql = "SELECT * FROM CoinBill WHERE CoinBillid LIKE ? and Userid LIKE ?";
        ConnectDB db = ConnectDB.getInstance();
        Connection con ;
        try {
            con = db.openConnecion();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,mgd);
            stmt.setInt(2,user.getUserId());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                return true;
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public void addBill(float amount, String mgd, int UserID) {
        String sql =  "INSERT INTO [dbo].[CoinBill] (CoinBillid, Userid, statusBill, DateOfCreate, currency) VALUES (?,?,?,?,?);";
        ConnectDB db = ConnectDB.getInstance();
        Connection con ;
        LocalDate currentdate = LocalDate.now();
        try {
            con = db.openConnecion();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1,mgd);
            stmt.setInt(2,UserID);
            stmt.setString(3,"success");
            stmt.setDate(4, Date.valueOf(currentdate));
            stmt.setFloat(5,amount);
            stmt.executeQuery();

            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<CoinBill> getDepositHistory(int UserID) {
        List<CoinBill> coinBills = new ArrayList<>();

        String sql = "SELECT * FROM CoinBill WHERE  Userid LIKE ?";
        ConnectDB db = ConnectDB.getInstance();
        Connection con ;
        try {
            con = db.openConnecion();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1,UserID);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                CoinBill temp_coin = new CoinBill();

                temp_coin.setCoinBillId(rs.getString(1));
                temp_coin.setUserId(rs.getInt(2));
                temp_coin.setStatusBill(rs.getString(3));
                temp_coin.setDateOfCrate(rs.getDate(4).toLocalDate());
                temp_coin.setCurrency(rs.getFloat(5));

                coinBills.add(temp_coin);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return coinBills;
    }


}
