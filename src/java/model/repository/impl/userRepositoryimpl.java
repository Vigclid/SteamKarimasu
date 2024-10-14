package model.repository.impl;

import Converter.userConverter;
import db.ConnectDB;
import model.Entity.User;
import model.dto.userDTO;
import model.repository.userRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class userRepositoryimpl implements userRepository {

    @Override
    public void Register(userDTO userdto) {

        String sql = "INSERT INTO master.users (Username, email, Dob, Pass, phonenumber) VALUES (?, ?, ?, ?, ?)";
        userConverter converter = new userConverter();
        User user = converter.convertUserDTOtoUserEntity(userdto);
//        checkExists(user);
        if (user.getUsername() != null && user.getEmail() != null && user.getPhoneNumber() != null && user.getPassword() != null && user.getDob() != null) {
            try {
                ConnectDB db = new ConnectDB();
                Connection con = db.openConnecion();
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, user.getUsername());
                preparedStatement.setString(2, user.getEmail());
                preparedStatement.setString(3, user.getDob());
                preparedStatement.setString(4, user.getPassword());
                preparedStatement.setString(5, user.getPhoneNumber());
                preparedStatement.execute();

                preparedStatement.close();
                con.close();
            } catch (SQLException e) {
                if (e.getSQLState().equals("45000")) {
                    // Đây là lỗi được phát sinh từ trigger
                    System.out.println("Trigger đã phát hiện trùng lặp username.");
                } else {
                    // Xử lý các lỗi SQL khác
                    e.printStackTrace();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
    }
    // CRATE A TRIGGER TO CHECK
//    public boolean checkExists(User user) {
//        List<User> userList = new ArrayList<>();
//        String sql = "SELECT u.Username, u.email, u.phonenumber, FROM master.users u";
//        try {
//            ConnectDB db = new ConnectDB();
//            Connection con = db.openConnecion();
//            Statement Statement = con.createStatement();
//            ResultSet rs = Statement.executeQuery(sql);
//            while (rs.next()) {
//                user.setUsername(rs.getString("Username"));
//                user.setEmail(rs.getString("email"));
//                user.setPhoneNumber(rs.getString("phonenumber"));
//                userList.add(user);
//            }
//        } catch (Exception e) {
//            System.out.println("User đã tồn tại xin bạn nhập lại");
//        }
//        for (User u : userList) {
//           if(u.getUsername().equals(user.getUsername()) && u.getEmail().equals(user.getEmail()) && u.getPhoneNumber().equals(user.getPhoneNumber())) {
//               return false;
//           }
//        }
//        return true;
//    }

    public static void main(String[] args) {
        userDTO u = new userDTO();
        u.setUsername("khang");
        u.setEmail("khang@gmail.com");
        u.setPhonenumber("09055577689");
        u.setDay("14");
        u.setMonth("02");
        u.setYear("2004");
        u.setPassword("123456");
        u.setComfirmPassword("123456");
        userRepositoryimpl userRepository = new userRepositoryimpl();
        userRepository.Register(u);
    }
}
