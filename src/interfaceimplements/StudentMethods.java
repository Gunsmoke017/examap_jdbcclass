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
        int upd ;
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
                    System.out.println("  >>  Student not inserted");
                    return  false;
                } else{
                    System.out.println("  >>  Student inserted successfully");
                }

            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return true;
    }

    @Override
    public String updateStudent(Student student) {
        PreparedStatement ps;

        String UPDATE =  "UPDATE student SET firstname =?, lastname = ? WHERE email = ?";
        String SEARCH = "SELECT * FROM student WHERE email = ?";
        String status = "";

        if (examAppConnection.connectToDatabase()){
            try{
                pr = examAppConnection.getConnections().prepareStatement(SEARCH);
                pr.setString(1 ,student.getEmail());
                res = pr.executeQuery();
                if(res.next()){
                    ps = examAppConnection.getConnections().prepareStatement(UPDATE);
                    ps.setString(1, student.getFirstname());
                    ps.setString(2,student.getLastname());
                    ps.setString(3,student.getEmail());

                    int upd = ps.executeUpdate();
                    if(upd == 0){
                        status = "  >>  Update failed";
                        return status;
                    } else {
                        status = "  >>  Update completed";
                    }
                } else{
                status = "  >>  Record not found";
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    return  status;
    }

    @Override
    public String retrieveStudent(String email) {
        Student student = new Student();
        if(examAppConnection.connectToDatabase()){
            String DISPLAY_ALL = "SELECT * FROM student WHERE email = ?";
            try{
                pr = examAppConnection.getConnections().prepareStatement(DISPLAY_ALL);
                pr.setString(1,email);
                res = pr.executeQuery();
                if(res.next()){
                    student.setEmail(res.getString("email"));
                    student.setFirstname(res.getString("firstname"));
                    student.setLastname(res.getString("lastname"));
                    student.setDob(res.getString("dob"));
                    student.setPhoneNumber(res.getLong("phone_no"));
                }
            } catch (SQLException e ){
                e.printStackTrace();
            }
        }
    return student.toString();
    }

    @Override
    public String deleteStudent(String email, String confirm) {
        String status ="";

        int upd =0;
        String DELETE_STUDENT = "DELETE FROM student WHERE email = ?";
        if(examAppConnection.connectToDatabase()){
            try{
            pr = examAppConnection.getConnections().prepareStatement(DELETE_STUDENT);
            pr.setString(1,email);
            if(confirm.equalsIgnoreCase("y")){
            upd = pr.executeUpdate();
            } else {
                System.out.println("  >>  Operation aborted");
            }

            if(upd == 0){
                status ="  >>  Deletion not successful";
                return status;
            } else {
                status="  >>  Student deleted successfully";
            }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return status;
    }
}
