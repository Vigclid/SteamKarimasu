
package repository.impl;

import Converter.userConverter;
import db.ConnectDB;
import model.Entity.user;
import controller.dto.userDTO;
import repository.userRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class userRepositoryimpl implements userRepository {

    @Override
    public void Register(userDTO userdto) {

        String sql = "INSERT INTO master.users (Username, email, Dob,Active, Pass, phonenumber) VALUES (?, ?, ?, ?, ?, ?)";
        userConverter converter = new userConverter();
        user user = converter.convertUserDTOtoUserEntity(userdto);
        try {
            ConnectDB db = new ConnectDB();
            Connection con = db.openConnecion();
            PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getEmail() );
            preparedStatement.setString(3, user.getDob());
            preparedStatement.setInt(4, user.isActive());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setString(6, user.getPhoneNumber());
            preparedStatement.executeUpdate();

            try (ResultSet rs = preparedStatement.getGeneratedKeys()) {
                if (rs.next()) {
                    user.setUserId(rs.getInt(1));
                }
            }

            UserRoleRepositoryImpl userRoleRepository = new UserRoleRepositoryImpl();
            userRoleRepository.addUserRole(user);
            preparedStatement.close();
            con.close();
        } catch (SQLException e) {
            if (e.getSQLState().equals("45000")) {
                System.out.println("Trigger đã phát hiện trùng lặp username.");
            } else {
                e.printStackTrace();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public List<user> getAllUsers()  {
        List<user> users = new ArrayList<>();
        String sql = "SELECT * From master.users";
        Connection con = null;
        try {
            ConnectDB db = new ConnectDB();
            con = db.openConnecion();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                user user = new user();
                user.setUsername(rs.getString("Username"));
                user.setEmail(rs.getString("email"));
                user.setPhoneNumber(rs.getString("phonenumber"));
                user.setDob(rs.getString("Dob"));
                user.setUserId(rs.getInt("Userid"));
                user.setPassword(rs.getString("Pass"));
                user.setActive(rs.getByte("Active"));

                users.add(user);
            }
            preparedStatement.close();
            con.close();
            rs.close();
        } catch (SQLException e) {
            // Log lỗi hoặc xử lý chi tiết
            System.err.println("SQL Error: " + e.getMessage());
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    // Log lỗi hoặc xử lý chi tiết
                    System.err.println("Error closing connection: " + e.getMessage());
                }
            }
        }
        return users;
    }

    @Override
    public int findIdProductByName(String name)  {
        try {
            ConnectDB db = new ConnectDB();
            Connection con = db.openConnecion();
            String sql = "SELECT Productid FROM product WHERE Productname LIKE '%" + name + "%'";
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

    public byte LoginCheck(String username, String password){
        String sql = "SELECT * FROM Users WHERE Username LIKE  ? AND Pass LIKE ?";
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
                sql = "SELECT ur.Roleid FROM Userrole ur WHERE Userid =?";
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

        } catch (Exception e) {
            e.printStackTrace();
        }



        return 0;

    }

    public user findUserbyName(String name) {
        user user = new user();
        String sql = "SELECT * FROM [dbo].[Users] WHERE Username like ? ";
        ConnectDB db = ConnectDB.getInstance();
        Connection con ;
        try {
            con = db.openConnecion();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, "%"+name+"%");
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                user.setUserId(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setEmail(rs.getString(3));
                user.setDob(rs.getString(4));
                user.setActive(rs.getByte(5));
                user.setPassword(rs.getString(6));
                user.setPhoneNumber(rs.getString(7));
                user.setTotalAmount(rs.getFloat(8));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public void updateUserPassword(user user) {
        String sql = " UPDATE Users SET Pass =? WHERE Userid = " + user.getUserId();
        ConnectDB db = ConnectDB.getInstance();
        Connection con ;
        try {
            con = db.openConnecion();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, user.getPassword());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void increaseKcoin(float amount , int userId) {
        String sql = "EXEC increaseTotalAmount @Userid= ? , @Amount = ?;";
        ConnectDB db = ConnectDB.getInstance();
        Connection con ;
        try {
            con = db.openConnecion();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1,userId);
            stmt.setFloat(2,amount);

            stmt.executeQuery();

            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
