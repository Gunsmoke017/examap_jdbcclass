package interfaceimplements;

import databaseconnection.ExamAppConnection;
import interfaces.IResultMethods;
import model.Result;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultMethods implements IResultMethods {
    ExamAppConnection examAppConnection = new ExamAppConnection();
    ResultSet res;
    PreparedStatement pr;
    int upd =0;
    @Override
    public boolean enterResult(Result result) {
        String INSERT_RESULT = "INSERT INTO result(email,math,english,chemistry,physics,total) VALUES (?,?,?,?,?,?)";
            if(examAppConnection.connectToDatabase()){
                try{
                    pr = examAppConnection.getConnections().prepareStatement(INSERT_RESULT);
                    pr.setString(1,result.getEmail());
                    pr.setInt(2,result.getMath());
                    pr.setInt(3,result.getEnglish());
                    pr.setInt(4,result.getChemistry());
                    pr.setInt(5,result.getPhysics());
                    pr.setInt(6,result.getTotal());

                    upd = pr.executeUpdate();

                    if(upd == 0){
                        System.out.println("Not entered");
                        return  false;
                    } else{
                        System.out.println("Successful");
                    }
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
        return false;
    }

    @Override
    public String viewStudentResult(String email) {
        Result result = new Result();
        String VIEW_RESULT = "SELECT * FROM result WHERE email = ?";
        if (examAppConnection.connectToDatabase()){
            try{
                pr = examAppConnection.getConnections().prepareStatement(VIEW_RESULT);
                pr.setString(1,email);
                res = pr.executeQuery();

                if(res.next()){
                    result.setEmail(res.getString("email"));
                    result.setMath((res.getInt("math")));
                    result.setEnglish((res.getInt("english")));
                    result.setChemistry((res.getInt("chemistry")));
                    result.setPhysics((res.getInt("physics")));
                    result.setTotal((res.getInt("total")));
                }
            } catch(SQLException e){
                e.printStackTrace();

            }        } else {
            System.out.println("no connectionexception");
        }
        return result.toString();
    }
}
