package ir.education.system.management.menu;


import ir.education.system.management.domin.Course;
import ir.education.system.management.domin.Professor;
import ir.education.system.management.domin.SelectedCourse;
import ir.education.system.management.domin.Student;
import ir.education.system.management.domin.enumeration.CourseStatus;
import ir.education.system.management.util.ApplicationContex;

import static ir.education.system.management.menu.BaseMenu.optionalProfessor;
import static ir.education.system.management.menu.BaseMenu.scanner;

@SuppressWarnings("unchecked")
public class ProfessorMenu {
    public static Professor professor = optionalProfessor.get();


    protected static void openMenuProfessor() {
        System.out.println("----- Professor Menu -----\n");
        System.out.println("1. Professor Information ");
        System.out.println("2. Register students' grades ");
        System.out.println("3. Professor Payslip");
        System.out.println("4. Exit ");
        int select = scanner.nextInt();
        scanner.nextLine();
        switch (select) {
            case 1:
                findProfessorInformation();
                break;
            case 2:
                registerStudentsGrade();
                break;
            case 3:
                findProfessorPayslip();
                break;
            default:
                System.out.println("Error");
        }
    }

    private static void findProfessorPayslip() {
        System.out.println("Enter SemesterNumber :");
        int semesterNumber =scanner.nextInt();
        System.out.println("Enter SemesterYear :");
        String semesterYear =scanner.next();
        Professor p =new Professor(professor.getId());
        ApplicationContex.getSemesterProfessorServiceImpl()
                .findProfessorPayslip(semesterNumber,semesterYear, p).forEach(System.out::println);

    }

    private static void registerStudentsGrade() {
        System.out.println("Please Enter Grade Student :\n");
        System.out.println("Enter Grade :");
        double grade = scanner.nextDouble();
        System.out.println("Enter Selectedcourse ID:");
        int idSelectedCourse = scanner.nextInt();
        System.out.println("Enter Course ID :");
        int courseId =scanner.nextInt();
        Course course =new Course(courseId);
        System.out.println("Enter Student ID :");
        int studentId=scanner.nextInt();
        Student student =new Student(studentId);
        System.out.println("Enter Semester :");
        int semester =scanner.nextInt();
        SelectedCourse selectedCourse = new SelectedCourse(grade, semester,student,course);
        ApplicationContex.getSelectedCourseSreviceImpl().update(selectedCourse, idSelectedCourse);
        System.out.println(" Grade Saved ...");
    }

    private static void findProfessorInformation() {
        ApplicationContex.getProfessorServiceImpl().
                findById(professor.getId()).ifPresent(System.out::println);

    }
}
