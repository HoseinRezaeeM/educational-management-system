package ir.education.system.management.menu;

import ir.education.system.management.domin.Course;
import ir.education.system.management.domin.SelectedCourse;
import ir.education.system.management.domin.Student;
import ir.education.system.management.util.ApplicationContex;


import static ir.education.system.management.menu.BaseMenu.*;


public class StudentMenu {

    public static Student studentEntity = optionalStudent.get();

    protected static void openMenuStudent() {
        System.out.println("----- Student Menu -----\n");
        System.out.println("1. Student Information ");
        System.out.println("2. View list of courses ");
        System.out.println("3. Select course unit ");
        System.out.println("4. Report Card ");
        System.out.println("5. Exit ");
        int select = scanner.nextInt();
        scanner.nextLine();
        switch (select) {
            case 1:
                findStudentInformation();
                break;
            case 2:
                findAllCourseList();
                break;
            case 3:
                selectCourseUnitStudent();
                break;
            case 4:
                findSelectedCourseStudentAndGrade();
                break;
            case 5:
                System.out.println("Exit-------------------->");
                break;
            default:
                System.out.println("Error");
        }

    }

    private static void findSelectedCourseStudentAndGrade() {
        System.out.println("Enter Semester Number :");
        Integer semester = scanner.nextInt();
        Student student = new Student(studentEntity.getId());
        ApplicationContex.getSelectedCourseSreviceImpl()
                .selectedCourseStudentAndGrade(semester, student).forEach(System.out::println);

    }

    private static void selectCourseUnitStudent() {
        final Student student = new Student(studentEntity.getId());
        System.out.println("Enter New semester Number :");
        final int semester = scanner.nextInt();
        final Double avg = ApplicationContex.getSelectedCourseSreviceImpl().avgPerviousSemester(semester - 1, student);
        long countUnit=0;
        if (avg >= 18) {
            while (true) {
                System.out.println("Enter Course ID :");
                int id = scanner.nextInt();
                Course course = new Course(id);
                if (id==0){
                    break;
                }
                SelectedCourse selectedCourse = new SelectedCourse(semester, student, course);
                if (ApplicationContex.getSelectedCourseSreviceImpl().notExistByCourseId(semester, course, student) < 1
                        && ApplicationContex.getSelectedCourseSreviceImpl().selectCourseFail(student,course) < 1 ) {
                    ApplicationContex.getSelectedCourseSreviceImpl().save(selectedCourse);
                }else {
                    System.out.println("Duplicate Course Or Exist Course !!!!!!");
                }
                countUnit = ApplicationContex.getSelectedCourseSreviceImpl().countUnitCourseForSelectByStudentNextSemester(semester, student);
                if(countUnit > 24){
                    System.out.println("Maximum unit full !!!!");
                    ApplicationContex.getSelectedCourseSreviceImpl().deleteById(selectedCourse.getId());
                    break;
                }
            }
        }else if(avg < 18){
            while (true) {
                System.out.println("Enter Course ID :");
                int id = scanner.nextInt();
                Course course = new Course(id);
                SelectedCourse selectedCourse = new SelectedCourse(semester, student, course);
                if (id==0){
                    break;
                }
                if (ApplicationContex.getSelectedCourseSreviceImpl().notExistByCourseId(semester, course, student) < 1
                        && ApplicationContex.getSelectedCourseSreviceImpl().selectCourseFail(student,course) < 1 ) {
                    ApplicationContex.getSelectedCourseSreviceImpl().save(selectedCourse);
                }else {
                    System.out.println("Duplicate Course Or Exist Course !!!!!!");
                }
                countUnit = ApplicationContex.getSelectedCourseSreviceImpl().countUnitCourseForSelectByStudentNextSemester(semester, student);
                if(countUnit > 20){
                    System.out.println("Maximum unit full !!!!");
                    ApplicationContex.getSelectedCourseSreviceImpl().deleteById(selectedCourse.getId());
                    break;
                }
            }
        }

    }

    private static void findAllCourseList() {
        System.out.println(ApplicationContex.getCourseServiceImpl()
                .findAll());
    }

    public static void findStudentInformation() {
        ApplicationContex.getStudentServiceImpl()
                .findById(studentEntity.getId()).ifPresent(System.out::println);

    }
}
