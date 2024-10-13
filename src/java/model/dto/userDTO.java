package model.dto;

public class userDTO{
    private int id;
    private String username;
    private String Email;
    private String phonenumber;
    private String day;
    private String month;
    private String year;
    private String password;

    public userDTO() {

    }

    public userDTO(String password, String year, String month, String day, String phonenumber, String email, String username) {
        this.password = password;
        this.year = year;
        this.month = month;
        this.day = day;
        this.phonenumber = phonenumber;
        Email = email;
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

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
