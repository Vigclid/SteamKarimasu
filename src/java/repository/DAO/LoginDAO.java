package repository.DAO;

import db.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static javax.management.Query.value;

public class LoginDAO {


    public byte LoginCheck(String username, String password){
        String sql = "SELECT * FROM [dbo].[Users] WHERE Username LIKE  ? AND Pass LIKE ?";
        ConnectDB db = ConnectDB.getInstance();
        Connection con ;
        try {
            con = db.openConnecion();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, "%"+username+"%");
            stmt.setString(2, "%"+password+"%");
            ResultSet rs = stmt.executeQuery();
            int Tempid = 0;
            Boolean success = false;
            if (rs.next()){
                Tempid = rs.getInt(1);
                if (rs.getByte(5) != 0)    success = true;
            }
            if (success) {
                sql = "SELECT Roleid FROM [dbo].[Userrole] WHERE Userid =?";
                stmt = con.prepareStatement(sql);
                stmt.setInt(1, Tempid);
                rs = stmt.executeQuery();

                if (rs.next()) {
                    int roleid = rs.getInt(1);
                    if (roleid == 1) {
                        return 1;
                    } else  return 2;
                }
            } else return 0;
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        

        return 0;

    }


    public static void main(String[] args) {
        LoginDAO loginDAO = new LoginDAO();
        byte result = loginDAO.LoginCheck("JohnDoe", "pass1234");
        System.out.println(result);
    }
}
