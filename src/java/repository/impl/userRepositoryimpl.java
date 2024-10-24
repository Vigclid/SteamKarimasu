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
            PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getEmail() );
            preparedStatement.setString(3, user.getDob());
            preparedStatement.setInt(4, user.isActive());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setString(6, user.getPhoneNumber());

            try (ResultSet rs = preparedStatement.getGeneratedKeys()) {
                if (rs.next()) {
                    user.setUserId(rs.getInt(1));
                }
            }

            addUserRole(user);

            preparedStatement.execute();
            preparedStatement.close();
            con.close();
        } catch (SQLException e) {
            // Kiểm tra SQLState để bắt lỗi RAISERROR từ SQL Server (mã lỗi 50000)
            if (e.getErrorCode() == 50000) {
                System.out.println("Trigger đã phát hiện trùng lặp username.");
            } else {
                e.printStackTrace();
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
    public void addUserRole(user user) {
        String sql = "INSERT INTO Userrole(Userid,Roleid) VALUES (?,?) ";

        try {
            ConnectDB db = new ConnectDB();
            Connection con = db.openConnecion();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, user.getUserId());
            stmt.setInt(2, 2); // Assuming roleId 2 corresponds to 'USER' role in the database

            stmt.executeUpdate();
            stmt.close();
            con.close();

        }catch (Exception e) {
            e.printStackTrace();
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