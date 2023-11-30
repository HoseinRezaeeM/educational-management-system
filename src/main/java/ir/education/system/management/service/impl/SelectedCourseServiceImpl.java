package ir.education.system.management.service.impl;

import ir.education.system.management.base.service.impl.BaseEntityServiceImpl;
import ir.education.system.management.domin.Course;
import ir.education.system.management.domin.SelectedCourse;
import ir.education.system.management.domin.Student;
import ir.education.system.management.repository.SelectedCourseRepository;
import ir.education.system.management.service.SelectedCourseSrevice;

import java.util.List;

public class SelectedCourseServiceImpl extends BaseEntityServiceImpl<Integer, SelectedCourse, SelectedCourseRepository> implements SelectedCourseSrevice {
    public SelectedCourseServiceImpl(SelectedCourseRepository baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<SelectedCourse> selectedCourseStudentAndGrade(Integer semester, Student student) {
        return baseRepository.selectedCourseStudentAndGrade(semester,student);
    }

    @Override
    public Long countUnitCourseForFirstSemester(Student student) {
        return baseRepository.countUnitCourseForFirstSemester(student);
    }

    @Override
    public Double avgPerviousSemester(int semester, Student student) {
        return baseRepository.avgPerviousSemester(semester,student);
    }

    @Override
    public Long countUnitCourseForSelectByStudentNextSemester(int semester, Student student) {
        return baseRepository.countUnitCourseForSelectByStudentNextSemester(semester,student);
    }

    @Override
    public Long notExistByCourseId(int semester, Course course, Student student) {
        return baseRepository.notExistByCourseId(semester,course,student);
    }

    @Override
    public Long selectCourseFail( Student student, Course course) {
        return baseRepository.selectCourseFail(student,course);
    }
}
