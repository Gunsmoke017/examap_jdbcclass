package interfaces;

import model.Student;

public interface IStudentMethods {
    public boolean registerStudent(Student student);
    public String updateStudent(Student student);
    public Student retrieveStudent(String email);
    public String deleteStudent(String email);
}
