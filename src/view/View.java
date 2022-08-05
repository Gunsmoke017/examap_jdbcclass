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
    Student student;
    public void menu(){
        do {
//
        System.out.println("==================================================");
        System.out.println("                    >> Student <<                 ");
        System.out.println("==================================================");
        System.out.println();
        System.out.println("Enter an operation \n >> (1) Register student\n >> (2) View student by email" +
                "\n >> (3) Update student by email\n >> (4) Delete student by email\n >> (5) Exit");
        choice = a.nextInt();
        switch (choice){
            case 1:
                System.out.println("  >>  Enter student email");
                student.setEmail(b.nextLine());
                System.out.println("  >>  Enter student firstname");
                student.setFirstname(b.nextLine());
                System.out.println("  >>  Enter student lastname");
                student.setLastname(b.nextLine());
                System.out.println("  >>  Enter student date of birth");
                student.setDob(b.nextLine());
                System.out.println("  >>  Enter student phone number");
                student.setPhoneNumber(a.nextLong());
                studentMethods.registerStudent(student);
                break;
            case 2:
                System.out.println("  >>  Enter student email: ");
                student.setEmail( b.nextLine());
                studentMethods.retrieveStudent(student.getEmail());
                break;
            case 3:
                System.out.println("Enter student email");
                student.setEmail(b.nextLine());
                System.out.println("Enter student firstname");
                student.setFirstname(b.nextLine());
                System.out.println("Enter student lastname");
                student.setLastname(b.nextLine());
                studentMethods.updateStudent(student);
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
//
        } while(choice != 5);
    }
}
