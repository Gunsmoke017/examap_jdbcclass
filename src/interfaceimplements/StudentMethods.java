package interfaceimplements;

import databaseconnection.ExamAppConnection;
import interfaces.IStudentMethods;
import model.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMethods implements IStudentMethods {

    PreparedStatement pr;
    ResultSet res;

    ExamAppConnection examAppConnection = new ExamAppConnection();

    @Override
    public boolean registerStudent(Student student) {
        boolean status = false;
        int upd;
        String INSERT = "INSERT INTO student (email, firstname, lastname, dob, phone_no) VALUES (?,?,?,?,?)";
        if(examAppConnection.connectToDatabase()){
            try{
                pr = examAppConnection.getConnections().prepareStatement(INSERT);
                pr.setString(1,student.getEmail());
                pr.setString(2,student.getFirstname());
                pr.setString(3,student.getLastname());
                pr.setString(4,student.getDob());
                pr.setLong(5,student.getPhoneNumber());

                upd = pr.executeUpdate();

                if(upd == 0){
                    System.out.println("Student not inserted");
                    return  false;
                } else{
                    System.out.println("Student inserted successfully");
                }

            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return true;
    }

    @Override
    public String updateStudent(Student student) {
    return  "";
    }

    @Override
    public Student retrieveStudent(String email) {
        Student student = new Student();
    return student;
    }

    @Override
    public String deleteStudent(String email) {
        return "";
    }
}
