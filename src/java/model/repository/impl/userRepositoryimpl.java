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
        User user = converter.convertUserDTOtoUserEntity(userdto);
            try {
                ConnectDB db = new ConnectDB();
                Connection con = db.openConnecion();
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, user.getUsername());
                preparedStatement.setString(2, user.getEmail() );
                preparedStatement.setString(3, user.getDob());
                preparedStatement.setInt(4, user.getActive());
                preparedStatement.setString(5, user.getPass());
                preparedStatement.setString(6, user.getPhonenumber());
                preparedStatement.execute();

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


}
