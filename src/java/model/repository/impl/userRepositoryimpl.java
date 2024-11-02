package model.repository.impl;

import Converter.userConverter;
import db.ConnectDB;
import model.Entity.User;
import controller.dto.userDTO;
import model.repository.userRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class userRepositoryimpl implements userRepository {

    @Override
    public void Register(userDTO userdto) {

        String sql = "INSERT INTO master.users (Username, email, Dob,Active, Pass, phonenumber) VALUES (?, ?, ?, ?, ?, ?)";
        userConverter converter = new userConverter();
        User user = converter.convertUserDTOtoUserEntityToRegister(userdto);
            try {
                ConnectDB db = new ConnectDB();
                Connection con = db.openConnecion();
                PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, user.getUsername());
                preparedStatement.setString(2, user.getEmail() );
                preparedStatement.setString(3, user.getDob());
                preparedStatement.setInt(4, user.getActive());
                preparedStatement.setString(5, user.getPass());
                preparedStatement.setString(6, user.getPhonenumber());
                preparedStatement.executeUpdate();

                try (ResultSet rs = preparedStatement.getGeneratedKeys()) {
                    if (rs.next()) {
                        user.setUserid(rs.getInt(1));
                    }
                }

                userRoleRepositoryImpl userRoleRepository = new userRoleRepositoryImpl();
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
    public List<User> getAllUsers()  {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * From master.users";
        Connection con = null;
        try {
            ConnectDB db = new ConnectDB();
             con = db.openConnecion();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUsername(rs.getString("Username"));
                user.setEmail(rs.getString("email"));
                user.setPhonenumber(rs.getString("phonenumber"));
                user.setDob(rs.getString("Dob"));
                user.setUserid(rs.getInt("Userid"));
                user.setPass(rs.getString("Pass"));
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


    public byte LoginCheck(String username, String password){
        String sql = "SELECT * FROM users WHERE Username LIKE  ? AND Pass LIKE ?";
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
                sql = "SELECT ur.Roleid FROM userrole ur WHERE Userid =?";
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

    public User findUserbyName(String name) {
        User user = new User();
        String sql = "SELECT * FROM master.users WHERE Username LIKE '%" + name + "%'";
        ConnectDB db = ConnectDB.getInstance();
        Connection con ;
        try {
            con = db.openConnecion();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                user.setUserid(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setEmail(rs.getString(3));
                user.setDob(rs.getString(4));
                user.setActive(rs.getByte(5));
                user.setPass(rs.getString(6));
                user.setPhonenumber(rs.getString(7));
                user.setTotalAmount(rs.getFloat(8));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User findUserByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email LIKE ?";
        int idUser = 0;
        try {
            ConnectDB db = ConnectDB.getInstance();
            Connection con = db.openConnecion();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, "%"+email+"%");
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                User user = new User();
                user.setUserid(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setEmail(rs.getString(3));
                user.setDob(rs.getString(4));
                user.setActive(rs.getByte(5));
                user.setPass(rs.getString(6));
                user.setPhonenumber(rs.getString(7));
                user.setTotalAmount(rs.getFloat(8));
                return user;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null ;
    }

    public void updateUserPassword(User user) {
        String sql = " UPDATE users SET Pass =? WHERE Userid = " + user.getUserid();
        ConnectDB db = ConnectDB.getInstance();
        Connection con ;
        try {
            con = db.openConnecion();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, user.getPass());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
