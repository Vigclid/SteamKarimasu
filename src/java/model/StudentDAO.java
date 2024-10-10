package model;

import db.ConnectDB;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentDAO {
    public List<student> getStudents(){
        List<student> students = new ArrayList<>();
        ConnectDB db = ConnectDB.getInstance();
        String sql = "SELECT * FROM Student";
        try {
            Connection con = db.openConnecion();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                String id = rs.getString(1);
                String name = rs.getString(2);
                LocalDate date = LocalDate.parse(rs.getString(4));
                Byte Gender = Byte.parseByte(rs.getString(3));
                students.add(new student(id,name,Gender,date));
            }
            con.close();
            stmt.close();
            rs.close();
        } catch (Exception ex){
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE,null, ex);
        }
        return students;
    }
    public void addStudent(student student){
        String sql = "INSERT INTO Student (StudentID,StudentName,Gender,DOB) VALUES(?,?,?,?);";
        ConnectDB db = ConnectDB.getInstance();
        Connection con;

        try {
            con = db.openConnecion();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, student.getId());
            stmt.setString(2, student.getName());

            stmt.setByte(3, student.getGender());

            stmt.setDate(4, Date.valueOf(student.getDob()));

            stmt.execute();
            stmt.close();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void deleteStudent(String id){
        String sql = "DELETE FROM Student WHERE StudentID = ?";
        ConnectDB db = ConnectDB.getInstance();
        try {
            Connection con = db.openConnecion();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,id);
            stmt.execute();
            con.close();
            stmt.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void updateStudent(student student){
        String sql = "UPDATE Student SET StudentName = ?, Gender = ?, DOB = ? WHERE StudentID = ?";
        ConnectDB db = ConnectDB.getInstance();
        try {
            Connection con = db.openConnecion();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, student.getName());
            stmt.setString(4, student.getId());

            stmt.setByte(2, student.getGender());

            stmt.setDate(3, Date.valueOf(student.getDob()));

            stmt.execute();
            stmt.close();
            con.close();
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    public List<student> searchStudents(String id, String name, Byte Gender, LocalDate dob){
            List<student> result = new ArrayList<>();
            for (student student : getStudents()) {
                boolean matches = true;
                if (id != null && !id.isEmpty() && !student.getId().equalsIgnoreCase(id)) {
                    matches = false;
                }
                if (name != null && !name.isEmpty() && !student.getName().contains(name)) {
                    matches = false;
                }
                if (Gender != null && !String.valueOf(student.getGender()).equals(Gender.toString())) {
                    matches = false;
                }
                if (dob != null && !student.getDob().equals(dob)) {
                    matches = false;
                }

                if (matches) {
                    result.add(student);
                }
            }
            return result;
        }

}
