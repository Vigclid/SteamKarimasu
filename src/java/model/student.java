package model;

import java.time.LocalDate;

public class student {
    private String id,name;
    private LocalDate dob;
    private byte gender;

    public student(String id, String name,  byte gender, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
    }
    public student(){
        id =  "";
        name = "";
        dob = null;
        gender = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public byte getGender() {
        return gender;
    }

    public void setGender(byte gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", gender=" + gender +
                '}';
    }
}
