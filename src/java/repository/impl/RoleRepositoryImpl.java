package repository.impl;
import db.ConnectDB;
import model.Entity.role;
import repository.RoleRepository;

import javax.management.relation.Role;
import java.sql.*;

public class RoleRepositoryImpl implements RoleRepository{

    @Override
    public String findRoleById(int id) {
        String sql = "SELECT * FROM Roles WHERE Roleid = " + id;
        String roleName = null;
        if (sql == null) {
            System.out.println("Role not found");
        }
        else try {
            role role = new role();
            ConnectDB db = new ConnectDB();
            Connection con = db.openConnecion();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                roleName = rs.getString(2);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return roleName;
    }

}
