package ir.education.system.management.service;

import ir.education.system.management.base.service.BaseEntityService;
import ir.education.system.management.domin.Course;
import ir.education.system.management.domin.SelectedCourse;
import ir.education.system.management.domin.Student;

import java.util.List;

public interface SelectedCourseSrevice extends BaseEntityService<Integer, SelectedCourse> {
    List<SelectedCourse> selectedCourseStudentAndGrade(Integer semester, Student student);

    Long countUnitCourseForFirstSemester(Student student);

    Double avgPerviousSemester(int semester, Student student);

    Long  countUnitCourseForSelectByStudentNextSemester(int semester, Student student);

    Long  notExistByCourseId(int semester, Course course, Student student);

    Long  selectCourseFail( Student student, Course course);
}
