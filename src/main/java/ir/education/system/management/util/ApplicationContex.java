package ir.education.system.management.util;

import ir.education.system.management.repository.*;
import ir.education.system.management.repository.impl.*;
import ir.education.system.management.service.*;
import ir.education.system.management.service.impl.*;

import javax.persistence.EntityManager;

public class ApplicationContex {

    private final static EntityManager entityManager;
    private static final EmployeeRepository employeeRepository;
    private static final EmployeeService employeeService;
    private static final ProfessorRepository professorRepository;
    private static final ProfessorService professorService;
    private static final CourseRepository courseRepository;
    private static final CourseService courseService;
    private static final StudentRepository studentRepository;
    private static final StudentService studentService;
    private static final SelectedCourseRepository selectedCourseRepository;
    private static final SelectedCourseSrevice selectedCourseSrevice;
    private static final SemesterProfessorRepository semesterProfessorRepository;
    private static final SemesterProfessorService semesterProfessorService;
    private static final UserRepository userRepository;
    private static final UserService userService;




    static {
        entityManager = EntityManagerFactoryProvider.getEntityManagerFactory().createEntityManager();
        employeeRepository = new EmployeeRepositoryImpl(entityManager);
        employeeService = new EmployeeServiceImpl(employeeRepository);
        professorRepository = new ProfessorRepositoryImpl(entityManager);
        professorService = new ProfessorServiceImpl(professorRepository);
        courseRepository = new CourseRepositoryImpl(entityManager);
        courseService = new CourseServiceImpl(courseRepository);
        studentRepository = new StudentRepositoryImpl(entityManager);
        studentService = new StudentServiceImpl(studentRepository);
        selectedCourseRepository = new SelectedCourseRepositoryImpl(entityManager);
        selectedCourseSrevice = new SelectedCourseServiceImpl(selectedCourseRepository);
        semesterProfessorRepository = new SemesterProfessorRepositoryImpl(entityManager);
        semesterProfessorService = new SemesterProfessorSeriveImpl(semesterProfessorRepository);
        userRepository = new UserRepositoryImpl(entityManager);
        userService = new UserServiceImpl(userRepository);

    }

    public static EmployeeService getEmployeeServiceImpl() {
        return employeeService;
    }

    public static ProfessorService getProfessorServiceImpl() {
        return professorService;
    }

    public static CourseService getCourseServiceImpl() {
        return courseService;
    }

    public static SelectedCourseSrevice getSelectedCourseSreviceImpl() {
        return selectedCourseSrevice;
    }

    public static SemesterProfessorService getSemesterProfessorServiceImpl() {
        return semesterProfessorService;
    }

    public static StudentService getStudentServiceImpl() {
        return studentService;
    }

    public static UserService getUserService() {
        return userService;
    }

}
