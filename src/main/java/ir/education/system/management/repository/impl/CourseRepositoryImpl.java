package ir.education.system.management.repository.impl;



import ir.education.system.management.base.repository.impl.BaseEntityRepositoryImpl;
import ir.education.system.management.domin.Course;
import ir.education.system.management.repository.CourseRepository;

import javax.persistence.EntityManager;

public class CourseRepositoryImpl extends BaseEntityRepositoryImpl<Integer, Course> implements CourseRepository {


    public CourseRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Course> getEntityClass() {
        return Course.class;
    }
}
