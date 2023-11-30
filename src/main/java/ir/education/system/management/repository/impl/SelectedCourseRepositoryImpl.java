package ir.education.system.management.repository.impl;


import ir.education.system.management.base.repository.impl.BaseEntityRepositoryImpl;
import ir.education.system.management.domin.Course;
import ir.education.system.management.domin.SelectedCourse;
import ir.education.system.management.domin.Student;
import ir.education.system.management.repository.SelectedCourseRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@SuppressWarnings("unchecked")
public class SelectedCourseRepositoryImpl extends BaseEntityRepositoryImpl<Integer, SelectedCourse> implements SelectedCourseRepository {
    public SelectedCourseRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<SelectedCourse> getEntityClass() {
        return SelectedCourse.class;
    }

    @Override
    public List<SelectedCourse> selectedCourseStudentAndGrade(Integer semester, Student student) {
        Query query = entityManager
                .createQuery("FROM SelectedCourse s WHERE s.semester=:semester AND s.student=:student");
        query.setParameter("semester", semester);
        query.setParameter("student", student);
        return query.getResultList();
    }

    @Override
    public Long countUnitCourseForFirstSemester(Student student) {
        Query query = entityManager.createQuery(
                "SELECT SUM(c.unit) FROM Course c inner join SelectedCourse s on c.id=s.course.id WHERE s.semester=1 AND s.student =:student"
        );
        query.setParameter("student", student);
        return (Long) query.getSingleResult();
    }

    @Override
    public Double avgPerviousSemester(int semester, Student student) {
        Query query = entityManager.createQuery(
                "SELECT  AVG (grade) FROM SelectedCourse s WHERE s.semester=:semester AND s.student=:student"
        );
        query.setParameter("semester", semester);
        query.setParameter("student", student);
        return (Double) query.getSingleResult();
    }

    @Override
    public Long countUnitCourseForSelectByStudentNextSemester(int semester, Student student) {
        Query query = entityManager.createQuery(
                "SELECT SUM(c.unit) FROM Course c inner join SelectedCourse s on c.id=s.course.id WHERE s.semester=:semester AND s.student =:student"
        );
        query.setParameter("semester", semester);
        query.setParameter("student", student);
        return (Long) query.getSingleResult();
    }

    @Override
    public Long notExistByCourseId(int semester, Course course, Student student) {
        Query query = entityManager.createQuery(
                "SELECT COUNT(course)" +
                        " FROM SelectedCourse s WHERE s.semester=:semester AND s.student=:student AND s.course=:course");
        query.setParameter("semester", semester);
        query.setParameter("student", student);
        query.setParameter("course", course);

        return (Long)query.getSingleResult();
    }

    @Override
    public Long selectCourseFail( Student student, Course course) {
        Query query = entityManager.createQuery("SELECT COUNT(course.id) FROM" +
                " SelectedCourse s WHERE s.grade>=10 AND  s.course=:course AND s.student=:student");
       query.setParameter("student",student);
       query.setParameter("course",course);
       return (Long)query.getSingleResult() ; //>0;
    }

}
