package controller.dto;

public class userDTO{
    private int id;
    private String username;
    private String Email;
    private String phonenumber;
    private String day;
    private String month;
    private String year;
    private String password;
    private String dob;
    private String comfirmPassword;
    private String Role;
    private String totalAmount;


    public userDTO() {

    }

    public userDTO(String username, String email, String phonenumber, String day, String month, String year, String password, String comfirmPassword) {
        this.password = password;
        this.year = year;
        this.month = month;
        this.day = day;
        this.phonenumber = phonenumber;
        this.Email = email;
        this.username = username;
        this.comfirmPassword = comfirmPassword;
    }

    public userDTO(int id, String role, String totalAmount, String email, String phonenumber, String dob, String username) {
        this.id = id;
        Role = role;
        this.totalAmount = totalAmount;
        Email = email;
        this.phonenumber = phonenumber;
        this.dob = dob;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getComfirmPassword() {
        return comfirmPassword;
    }

    public void setComfirmPassword(String comfirmPassword) {
        this.comfirmPassword = comfirmPassword;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }
}
