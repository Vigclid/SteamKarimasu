package model.Entity;

import java.time.LocalDateTime;

public class TokenForgetPassword {
    private int id, userId;
    private boolean isUser;
    private String token;
    private LocalDateTime expiryTime;

    public TokenForgetPassword() {
    }

    public TokenForgetPassword(int id, int userId, boolean isUser, String token, LocalDateTime expiryTime) {
        this.id = id;
        this.userId = userId;
        this.isUser = isUser;
        this.token = token;
        this.expiryTime = expiryTime;
    }

    public TokenForgetPassword(int userId, boolean isUser, String token, LocalDateTime expiryTime) {
        this.userId = userId;
        this.isUser = isUser;
        this.token = token;
        this.expiryTime = expiryTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isUser() {
        return isUser;
    }

    public void setUser(boolean user) {
        isUser = user;
    }

    public LocalDateTime getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(LocalDateTime expiryTime) {
        this.expiryTime = expiryTime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
