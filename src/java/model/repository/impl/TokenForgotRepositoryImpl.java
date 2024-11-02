package model.repository.impl;

import db.ConnectDB;
import model.Entity.TokenForgetPassword;
import model.repository.TokenForgotRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TokenForgotRepositoryImpl implements TokenForgotRepository {

    @Override
    public boolean insertTokenForgot(TokenForgetPassword tokenForgetPassword) {
        String sql = "INSERT INTO master.tokenForgetPassword(token, expiryTime, isUser, Userid) Values(?,?,?,?)";
        try {
            ConnectDB db = new ConnectDB();
            Connection con = db.openConnecion();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, tokenForgetPassword.getToken());
            stmt.setTimestamp(2, Timestamp.valueOf(getFormatDate(tokenForgetPassword.getExpiryTime())));
            stmt.setBoolean(3, tokenForgetPassword.isUser());
            stmt.setInt(4, tokenForgetPassword.getUserId());
            int result = stmt.executeUpdate();

            if (result > 0) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String getFormatDate(LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formatteDate = formatter.format(date);
        return formatteDate;
    }
}
