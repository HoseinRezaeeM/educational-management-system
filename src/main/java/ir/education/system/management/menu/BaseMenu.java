package ir.education.system.management.menu;


import ir.education.system.management.domin.*;
import ir.education.system.management.util.ApplicationContex;
import ir.education.system.management.validation.RegexValidation;

import java.sql.SQLException;
import java.util.Optional;
import java.util.Scanner;

import static ir.education.system.management.menu.EmployeeMenu.*;

public class BaseMenu {
    public static Optional<Student> optionalStudent;
    public static Optional<Professor> optionalProfessor;
    public static Optional<Employee> optionalEmployee;
    public static SemesterProfessor semesterProfessor;

    public static final Scanner scanner = new Scanner(System.in);


    public void fistMenu() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n*************************************************************");
        System.out.println("|         - WELCOMT TO EDUCATION SYSTEM MANAGEMENT -          |");
        System.out.println("|                 Develope By Hosein Rezaei                   |");
        System.out.println("*************************************************************\n");
        System.out.println("1- Sign in");
        System.out.println("2- Sign up");
        System.out.println("3- Exit\n");
        System.out.println("Enter your select:");
        try {
            int select = scanner.nextInt();
            scanner.nextLine();
            switch (select) {
                case 1 -> login();
                case 2 -> signup();
                case 3 -> {
                    System.out.println("exit");
                    break;
                }
                default -> System.out.println("---Eror404---");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("!!!WRONG!!!");
        }

    }

    public static void signup() {
        System.out.println("Enter firstName :  ");
        String firstName = scanner.next();
        System.out.println("Enter lastName : ");
        String lastName = scanner.next();
        System.out.println("Enter age :");
        int age = scanner.nextInt();
        System.out.println("Enter username : ");
        String username = scanner.next();
        System.out.println("Enter password : ");
        String password;
        password = validationPassword();
        System.out.println("Enter email : ");
        String email;
        email = validationEmail();
        System.out.println("Enter MobileNumber : ");
        String mobileNumber;
        mobileNumber = validationMoblieNumber();
        System.out.println("Enter hiredData :");
        String hiredData = scanner.next();
        Employee employee = new Employee(firstName, lastName, age, username, password, email, mobileNumber, hiredData);
        ApplicationContex.getEmployeeServiceImpl().save(employee);
        System.out.println("ADD to DataBase SUCESSFULLY");

    }

    public static String validationPassword() {
        String password = null;
        boolean isTrue = true;
        while (isTrue) {
            password = scanner.next();
            if (RegexValidation.validatonPassword(password)) {
                isTrue = false;
            } else {
                System.out.println("Enter valid password!!!!");
            }
        }
        return password;
    }

    public static String validationEmail() {
        String email = null;
        boolean isTrue = true;
        while (isTrue) {
            email = scanner.next();
            if (RegexValidation.validaitonEmail(email)) {
                isTrue = false;
            } else {
                System.out.println("Enter validation Email!!!!");
            }
        }
        return email;
    }

    public static String validationMoblieNumber() {
        String mobileNumber = null;
        boolean isTrue = true;
        while (isTrue) {
            mobileNumber = scanner.next();
            if (RegexValidation.validationMobileNumber(mobileNumber)) {
                isTrue = false;
            } else {
                System.out.println("Enter validation MobileNumber!!!!");
            }
        }
        return mobileNumber;
    }

    public void login() {
        System.out.println("Select User :");
        System.out.println("1. Employee Education");
        System.out.println("2. Professor ");
        System.out.println("3. Student");
        int select = scanner.nextInt();
        scanner.nextLine();
        switch (select) {
            case 1:
                loginEmployee();
                break;
            case 2:
                loginProfessor();
                break;
            case 3:
                loginStudent();
                break;
            default:
                System.out.println("Error---");
        }
    }


    public static void loginStudent() {
        boolean isTrue = true;
        while (isTrue) {
            System.out.println("Enter username :");
            String username = scanner.next();
            System.out.println("Enter Password : ");
            String password = scanner.next();
            optionalStudent = ApplicationContex.getStudentServiceImpl().login(username, password);
            if (optionalStudent.isPresent()) {
                StudentMenu.openMenuStudent();
                StudentMenu.studentEntity = optionalStudent.get();
                isTrue = false;
            } else {
                System.out.println("username and password UnCorrect !!!!\n");
                System.out.println("Please Again ... ");
            }

        }
    }

    private void loginProfessor() {
        boolean isTrue = true;
        while (isTrue) {
            System.out.println("Enter username :");
            String username = scanner.next();
            System.out.println("Enter Password : ");
            String password = scanner.next();
            optionalProfessor = ApplicationContex.getProfessorServiceImpl().login(username, password);
            if (optionalProfessor.isPresent()) {
                ProfessorMenu.openMenuProfessor();
                ProfessorMenu.professor = optionalProfessor.get();
                isTrue = false;
            } else {
                System.out.println("username and password UnCorrect !!!!\n");
                System.out.println("Please Again ... ");
            }
        }
    }

    private void loginEmployee() {
        boolean isTrue = true;
        while (isTrue) {
            System.out.println("Enter username :");
            String username = scanner.next();
            System.out.println("Enter Password : ");
            String password = scanner.next();
            optionalEmployee = ApplicationContex.getEmployeeServiceImpl().login(username, password);
            if (optionalEmployee.isPresent()) {
                openMenuEmployee();
                EmployeeMenu.employee = optionalEmployee.get();
                isTrue = false;
            } else {
                System.out.println("username and password UnCorrect !!!!\n");
                System.out.println("Please Again ... ");
            }
        }
    }

    private void openMenuEmployee() {
        System.out.println("----- Employee Menu -----\n");
        System.out.println("1. Student Information ");
        System.out.println("2. Professor Information ");
        System.out.println("3. Employee Infomation ");
        System.out.println("4. Course Information ");
        System.out.println("5. Employee Payslip ");
        System.out.println("6. Exit \n");
        System.out.println("Select an item :");
        int choose = scanner.nextInt();
        scanner.nextLine();
        switch (choose) {
            case 1 -> performStudentInformation();
            case 2 -> performProfessorInformation();
            case 3 -> performEmployeeInformation();
            case 4 -> performCourseInformation();
            case 5 -> {
                findEmployeePayslip();
                break;
            }
            case 6 -> {
                System.out.println("Exit ------------->");
                break;
            }
            default -> System.out.println("---Eror404---");
        }
    }


}