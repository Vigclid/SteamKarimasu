package model.Entity;

public class user {
    private int userId;
    private String username;
    private String email;
    private String dob;  // Có thể sử dụng LocalDate nếu cần
    private byte active;
    private String password;
    private String phoneNumber;

    private float totalAmount;

    // Constructor không tham số
    public user() {}

    // Constructor có tham số
    public user(int userId, String username, String email, String dob, byte active, String password, String phoneNumber) {
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

    public byte isActive() {
        return active;
    }

    public void setActive(byte active) {
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

    public byte getActive() {
        return active;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
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
