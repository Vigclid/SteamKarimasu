package model.Entity;

public class User {
    private int userId;
    private String username;
    private String email;
    private String dob;  // Có thể sử dụng LocalDate nếu cần
    private boolean active;
    private String password;
    private String phoneNumber;

    // Constructor không tham số
    public User() {}

    // Constructor có tham số
    public User(int userId, String username, String email, String dob, boolean active, String password, String phoneNumber) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.dob = dob;
        this.active = active;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    // Getter và Setter
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Phương thức để hiển thị thông tin đối tượng User
    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", dob='" + dob + '\'' +
                ", active=" + active +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
