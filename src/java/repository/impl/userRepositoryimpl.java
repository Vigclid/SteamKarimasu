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

        String sql = "INSERT INTO [dbo].[Users] (Username, email, Dob,Active, Pass, phonenumber) VALUES (?, ?, ?, ?, ?, ?)";
        userConverter converter = new userConverter();
        user user = converter.convertUserDTOtoUserEntity(userdto);
        try {
            ConnectDB db = new ConnectDB();
            Connection con = db.openConnecion();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getEmail() );
            preparedStatement.setString(3, user.getDob());
            preparedStatement.setInt(4, user.isActive());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setString(6, user.getPhoneNumber());
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
    public List<user> getAllUsers()  {
        List<user> users = new ArrayList<>();
        String sql = "SELECT * From [dbo].[Users]";
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


}