package model.repository.impl;

import db.ConnectDB;
import model.Entity.User;
import model.Entity.UserRole;
import model.repository.userRoleRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class userRoleRepositoryImpl implements userRoleRepository {

    @Override
    public void addUserRole(User user) {
        String sql = "INSERT INTO userrole(Userid,Roleid) VALUES (?,?) ";

        try {
            ConnectDB db = new ConnectDB();
            Connection con = db.openConnecion();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, user.getUserid());
            stmt.setInt(2, 2); // Assuming roleId 2 corresponds to 'USER' role in the database

            stmt.executeUpdate();
            stmt.close();
            con.close();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int findRoleIdbyUserId(int userId) {
        UserRole userRole = new UserRole();
        String sql = "SELECT u.Roleid FROM userrole u WHERE u.Userid = " + userId;
        int roleId = 0;
        try {
            ConnectDB db = new ConnectDB();
            Connection con = db.openConnecion();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                roleId = rs.getInt(1);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return roleId;
    }
}
