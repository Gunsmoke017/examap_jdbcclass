package view;

import interfaceimplements.ResultMethods;
import interfaceimplements.StudentMethods;
import model.Result;
import model.Student;

import java.util.Scanner;

public class View {
    Scanner a = new Scanner(System.in).useDelimiter("\n");
    Scanner b = new Scanner(System.in).useDelimiter("\n");
    int choice =0;

    StudentMethods studentMethods = new StudentMethods();
    ResultMethods resultMethods = new ResultMethods();

    Student student = new Student();
    Result result = new Result();


    public void menu(){
        do {
        System.out.println("==================================================");
        System.out.println("                    >> Student <<                 ");
        System.out.println("==================================================");
        System.out.println();
        System.out.println("  >>  Enter an operation  <<   \n >> (1) Register student\n >> (2) View student by email" +
                "\n >> (3) Update student by email\n >> (4) Delete student by email\n >> (5) Back to main menu");
        choice = a.nextInt();
        switch (choice){
            case 1:
                System.out.println("  >>  Enter student email");
                student.setEmail(b.next());
                System.out.println("  >>  Enter student firstname");
                student.setFirstname(b.next());
                System.out.println("  >>  Enter student lastname");
                student.setLastname(b.next());
                System.out.println("  >>  Enter student date of birth");
                student.setDob(b.next());
                System.out.println("  >>  Enter student phone number");
                student.setPhoneNumber(a.nextLong());
                System.out.println(studentMethods.registerStudent(student));
                break;
            case 2:
                System.out.println("  >>  Enter student email: ");
                student.setEmail( b.next());
                System.out.println(studentMethods.retrieveStudent(student.getEmail()));
                break;
            case 3:
                System.out.println("  >>  Enter student email");
                student.setEmail(b.next());
                System.out.println("  >>  Enter student firstname");
                student.setFirstname(b.next());
                System.out.println("  >>  Enter student lastname");
                student.setLastname(b.next());
                System.out.println(studentMethods.updateStudent(student));
                break;
            case 4:
                System.out.println("  >>  Enter the student email");
                student.setEmail( b.next());
                System.out.println("  >>  Do you wish to delete student with email " + student.getEmail()+" ?\n  >>  Y/N" );
                System.out.println(studentMethods.deleteStudent(student.getEmail(), b.next()));
                break;
            case 5:
                System.out.println(" >>  Goodbye");
                break;
            default:
                System.out.println("  >>  Enter valid option");
        }
        } while(choice != 5);
    }

    public void resultMethods(){
        int choice=0;
        do {
            System.out.println("==================================================");
            System.out.println("                    >> Student <<                 ");
            System.out.println("==================================================");
            System.out.println();
            System.out.println("  >>  Enter a selection: ");
            System.out.println("  >>  (1) Enter result\n  >>  (2) View result\n  >>  (3) Back to main menu");
            switch (choice){
                case 1:
                    System.out.println("  >>  Enter Student email");
                    result.setEmail(b.next());
                    System.out.println("  >>  Enter Student math score");
                    result.setMath(a.nextInt());
                    System.out.println("  >>  Enter Student english score");
                    result.setEnglish(a.nextInt());
                    System.out.println("  >>  Enter Student chemistry");
                    result.setChemistry(a.nextInt());
                    System.out.println("  >>  Enter Student physics score");
                    result.setPhysics(a.nextInt());
                    resultMethods.enterResult(result);
                    break;
                case 2:
                    System.out.println("  >>  Enter student email");
                    result.setEmail(b.next());
                    resultMethods.viewStudentResult(result.getEmail());
                    break;
                case 3:
                    System.out.println("  >>  Goodbye");
                    break;
                default:
                    System.out.println("Enter valid choice");
            }

        } while(choice != 3);
    }

    public void menuHolder(){
        int choice;
        do{
            System.out.println("==================================================");
            System.out.println("                    >> Student <<                 ");
            System.out.println("==================================================");
            System.out.println();
            System.out.println("  >>  Enter a selection: ");
            System.out.println("  >>  (1) Students\n  >>  (2) Results\n  >>  (3) Exit");
            choice = b.nextInt();
            switch (choice){
                case 1:
                    menu();
                    break;
                case 2:
                    resultMethods();
                    break;
                case 3:
                    System.out.println("  >>  Goodbye");
                    break;
                default:
                    System.out.println("Enter valid choice");
            }

        } while (choice !=3);
    }
}
