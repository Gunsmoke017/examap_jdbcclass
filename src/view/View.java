package view;

import interfaceimplements.StudentMethods;
import model.Student;

import java.util.Scanner;

public class View {
    Scanner a = new Scanner(System.in);
    Scanner b = new Scanner(System.in);
    int choice =0;
    String email;
    StudentMethods studentMethods = new StudentMethods();
    Student student = new Student();
    public void menu(){


        System.out.println("==================================================");
        System.out.println("                    >> Student <<                 ");
        System.out.println("==================================================");
        System.out.println();
        System.out.println("Enter an operation \n >> (1) Register student\n >> (2) View student by email" +
                "\n >> (3) Update student by email\n >> (4) Delete student by email\n >> (5) Exit");
        choice = a.nextInt();
        switch (choice){
            case 1:
//                studentMethods.registerStudent()
                break;
            case 2:
                System.out.println("  >>  Enter student email: ");
                student.setEmail( b.nextLine());
                studentMethods.retrieveStudent(student.getEmail());
                break;
            case 3:
//                studentMethods.updateStudent()
                break;
            case 4:
                System.out.println("Enter the student email");
                student.setEmail( b.nextLine());
                studentMethods.deleteStudent(student.getEmail());
                break;
            case 5:
                System.out.println(" >>  Goodbye");
                break;
            default:
                System.out.println("Enter valid option");
        }
    }
}
