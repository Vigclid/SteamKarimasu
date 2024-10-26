package model.repository.impl;

import db.ConnectDB;
import model.Entity.Role;
import model.repository.roleRepository;

import java.sql.*;

public class roleRepositoryImpl implements roleRepository {


    @Override
    public void findRoleById(int id) {
        String sql = "SELECT * FROM Roles WHERE Roleid = " + id;
        if (sql == null) {
            System.out.println("Role not found");
        }
        else try {
            Role role = new Role();
            ConnectDB db = new ConnectDB();
            Connection con = db.openConnecion();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                role.setRoleName(rs.getString(2));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
