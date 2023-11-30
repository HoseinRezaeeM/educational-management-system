package ir.education.system.management.menu;

//Hosein Rezaei
import ir.education.system.management.domin.*;
import ir.education.system.management.domin.enumeration.ProfessorType;
import ir.education.system.management.util.ApplicationContex;
import ir.education.system.management.validation.CourseValidation;
import ir.education.system.management.validation.SelectedCourseValidation;

import static ir.education.system.management.menu.BaseMenu.*;

public class EmployeeMenu {
    public static Employee employee = optionalEmployee.get();

    public static void findEmployeePayslip() {
        ApplicationContex.getEmployeeServiceImpl()
                .findById(employee.getId()).ifPresent(System.out::println);

    }

    public static void performCourseInformation() {
        System.out.println(" -- Course Information -- ");
        System.out.println("1. Save Course");
        System.out.println("2. Update Course");
        System.out.println("3. Delete Course");
        int select = scanner.nextInt();
        scanner.nextLine();
        switch (select) {
            case 1:
                saveCourse();
                break;
            case 2:
                updateCouse();
                break;
            case 3:
                deleteCourse();
                break;
            default:
                System.out.println("Error-->");
        }
    }

    public static void deleteCourse() {
        System.out.println("Please Enter Information for Delete :\n");
        System.out.println("Which Delete ID course ?");
        int id = scanner.nextInt();
        ApplicationContex.getCourseServiceImpl().deleteById(id);
        System.out.println("SUCESSFULLY DELETE ...");
    }

    public static void updateCouse() {
        System.out.println("Please Enter Information for Update :\n");
        System.out.println("name :");
        String name = scanner.next();
        System.out.println("unit :");
        int unit = scanner.nextInt();
        System.out.println("start Data :");
        String startData = scanner.next();
        System.out.println("exam Data :");
        String examData = scanner.next();
        System.out.println("professor id :");
        Integer id = scanner.nextInt();
        Professor professor = new Professor(id);
        Course course = new Course(name, unit, startData, examData, professor);
        System.out.println("Which Update Course ID ?");
        int idUpdate = scanner.nextInt();
        ApplicationContex.getCourseServiceImpl().update(course, idUpdate);
        System.out.println("SUCESSFULLY UPDATE ...");
    }

    public static void saveCourse() {
        System.out.println("Please Enter Information for Save :\n");
        System.out.println("Enter name :");
        String name = scanner.next();
        System.out.println("Enter unit :");
        int unit = scanner.nextInt();
        System.out.println("Enter start Data :");
        String startData = scanner.next();
        System.out.println("Enter exam Data :");
        String examData = scanner.next();
        System.out.println("Enter professor id :");
        Integer id = scanner.nextInt();
        Professor professor = new Professor(id);
        Course course = new Course(name, unit, startData, examData, professor);
        ApplicationContex.getCourseServiceImpl().save(course);
        System.out.println("SUCESSFULLY SAVE ...");
    }

    public static void performEmployeeInformation() {
        System.out.println(" -- Employee Information -- ");
        System.out.println("1. Save Employee");
        System.out.println("2. Update Employee");
        System.out.println("3. Delete Employee");
        int select = scanner.nextInt();
        scanner.nextLine();
        switch (select) {
            case 1:
                saveEmployee();
                break;
            case 2:
                updateEmployee();
                break;
            case 3:
                deleteEmployee();
                break;
            default:
                System.out.println("Error-->");
        }
    }

    public static void updateEmployee() {
        System.out.println("Please Enter Information for Update :\n");
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
        System.out.println("Which Update employee ID ?");
        int idUpdate = scanner.nextInt();
        ApplicationContex.getEmployeeServiceImpl().update(employee, idUpdate);
        System.out.println("SUCESSFULLY UPDATE ...");
    }

    public static void saveEmployee() {
        System.out.println("Please Enter Information for Save :\n");
        signup();
    }

    public static void deleteEmployee() {
        System.out.println("Please Enter Information for Delete :\n");
        System.out.println("Which Delete ID Employee ?");
        int id = scanner.nextInt();
        ApplicationContex.getEmployeeServiceImpl().deleteById(id);
        System.out.println("SUCESSFULLY DELETE ...");
    }

    public static void performProfessorInformation() {
        System.out.println(" -- Professor Information -- ");
        System.out.println("1. Save Professor");
        System.out.println("2. Update Professor");
        System.out.println("3. Delete Professor");
        System.out.println("4. Select semester professor");
        int select = scanner.nextInt();
        scanner.nextLine();
        switch (select) {
            case 1:
                saveProfessor();
                break;
            case 2:
                updateProfessor();
                break;
            case 3:
                deleteProfessor();
                break;
            case 4:
                selectSemesterProfessor();
                break;
            default:
                System.out.println("Error-->");
        }
    }

    public static void selectSemesterProfessor() {
        System.out.println("Please Enter Information for Save :\n");
        System.out.println("Enter Professor ID:");
        Integer id = scanner.nextInt();
        Professor professor = new Professor(id);
        System.out.println("Enter Semester :");
        Integer semester = scanner.nextInt();
        System.out.println("Enter yearaSemester :");
        String year = scanner.next();
        System.out.println("Enter Professor Type :");
        String professorType = scanner.next();
        ProfessorType type = ProfessorType.valueOf(professorType);
        System.out.println("Enter unit Number :");
        Integer unitNumber = scanner.nextInt();
        SemesterProfessor semesterProfessor = new SemesterProfessor(semester, unitNumber, year, type, professor);
        ApplicationContex.getSemesterProfessorServiceImpl().save(semesterProfessor);
        System.out.println("SUCESSFULLY SAVE ...");
    }

    public static void deleteProfessor() {
        System.out.println("Please Enter Information for Delete :\n");
        System.out.println("Which Delete ID Professor ?");
        int id = scanner.nextInt();
        ApplicationContex.getProfessorServiceImpl().deleteById(id);
        System.out.println("SUCESSFULLY DELETE ...");
    }

    public static void updateProfessor() {
        System.out.println("Please Enter Information for Update :\n");
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
        Professor professor = new Professor(firstName, lastName, age, username, password, email, mobileNumber);
        System.out.println("Which Update professor ID ?");
        int idUpdate = scanner.nextInt();
        ApplicationContex.getProfessorServiceImpl().update(professor, idUpdate);
        System.out.println("SUCESSFULLY UPDATE ...");


    }

    public static void saveProfessor() {
        System.out.println("Please Enter Information for Save :\n");
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
        Professor professor = new Professor(firstName, lastName, age, username, password, email, mobileNumber);
        ApplicationContex.getProfessorServiceImpl().save(professor);
        System.out.println("SUCESSFULLY SAVE ...");
    }

    public static void performStudentInformation() {
        System.out.println(" -- Student Information -- ");
        System.out.println("1. Save Student");
        System.out.println("2. Update Student");
        System.out.println("3. Delete Student");
        System.out.println("4. Select Course first semester ");
        int select = scanner.nextInt();
        scanner.nextLine();
        switch (select) {
            case 1:
                saveStudent();
            case 2:
                updateStudent();
            case 3:
                deleteStudent();
            case 4:
                selectCourseForfirstSemester();
                break;
            default:
                System.out.println("Error-->");
        }
    }

    private static void selectCourseForfirstSemester() {
        boolean isTrue = true;
        Student student = null;
        long count = 0;
        while (true) {
            System.out.println("Please Enter Information for Select Course For first Semester :\n");
            System.out.println("Enter Student ID :");
            Integer id = scanner.nextInt();
            student = new Student(id);
            count= ApplicationContex.getSelectedCourseSreviceImpl().countUnitCourseForFirstSemester(student);
            if(count >= 16){
                System.out.println("Maximum unit full !!!!");
                break;
            }
            System.out.println("Enter Course ID :");
            Integer courseId = scanner.nextInt();
            Course course = new Course(courseId);
            SelectedCourse selectedCours = new SelectedCourse(1, student, course);
            ApplicationContex.getSelectedCourseSreviceImpl().save(selectedCours);
            System.out.println("SUCESSFULLY SAVE ...");
        }

    }

    public static void deleteStudent() {
        System.out.println("Please Enter Information for Delete :\n");
        System.out.println("Which Delete ID Student ?");
        int id = scanner.nextInt();
        ApplicationContex.getStudentServiceImpl().deleteById(id);
        System.out.println("SUCESSFULLY DELETE ...");
    }

    public static void updateStudent() {
        System.out.println("Please Enter Information for Update :\n");
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
        System.out.println("Enter entries Date :");
        String enterieData = scanner.next();
        Student student = new Student(firstName, lastName, age, username, password, email, mobileNumber, enterieData);
        System.out.println("Which Update student ID ?");
        int idUpdate = scanner.nextInt();
        ApplicationContex.getStudentServiceImpl().update(student, idUpdate);
        System.out.println("SUCESSFULLY UPDATE ...");

    }

    public static void saveStudent() {
        System.out.println("Please Enter Information for Save :\n");
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
        System.out.println("Enter entries Date :");
        String enterieData = scanner.next();
        Student student = new Student(firstName, lastName, age, username, password, email, mobileNumber, enterieData);
        ApplicationContex.getStudentServiceImpl().save(student);
        System.out.println("SUCESSFULLY SAVE ...");
    }
}
