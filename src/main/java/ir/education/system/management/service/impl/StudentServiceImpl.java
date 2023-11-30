package ir.education.system.management.service.impl;


import ir.education.system.management.base.service.impl.BaseEntityServiceImpl;
import ir.education.system.management.domin.Student;
import ir.education.system.management.repository.StudentRepository;
import ir.education.system.management.service.StudentService;
import ir.education.system.management.service.base.impl.BaseUserServiceImpl;


public class StudentServiceImpl extends BaseUserServiceImpl<Student, StudentRepository> implements StudentService {

    public StudentServiceImpl(StudentRepository baseRepository) {
        super(baseRepository);
    }
}
