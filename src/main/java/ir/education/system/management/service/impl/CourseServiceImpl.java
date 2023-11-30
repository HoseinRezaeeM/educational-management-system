package ir.education.system.management.service.impl;

import ir.education.system.management.base.service.impl.BaseEntityServiceImpl;
import ir.education.system.management.domin.Course;
import ir.education.system.management.repository.CourseRepository;
import ir.education.system.management.service.CourseService;

public class CourseServiceImpl extends BaseEntityServiceImpl<Integer, Course, CourseRepository> implements CourseService {
    public CourseServiceImpl(CourseRepository baseRepository) {
        super(baseRepository);
    }
}
