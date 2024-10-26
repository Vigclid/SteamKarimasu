package model.Entity;

public class User {
    private int Userid;
    private String Username;
    private String email;
    private String Dob;  // Có thể sử dụng LocalDate nếu cần
    private byte Active;
    private String Pass;
    private String phonenumber;
    private float totalAmount;

    // Constructor không tham số
    public User() {}

    // Constructor có tham số
    public User(int userId, String username, String email, String dob, byte active, String password, String phoneNumber) {
        this.Userid = userId;
        this.Username = username;
        this.email = email;
        this.Dob = dob;
        this.Active = active;
        this.Pass = password;
        this.phonenumber = phoneNumber;
    }

    // Getter và Setter

    public int getUserid() {
        return Userid;
    }

    public void setUserid(int userid) {
        Userid = userid;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return Dob;
    }

    public void setDob(String dob) {
        Dob = dob;
    }

    public byte getActive() {
        return Active;
    }

    public void setActive(byte active) {
        Active = active;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }
}
