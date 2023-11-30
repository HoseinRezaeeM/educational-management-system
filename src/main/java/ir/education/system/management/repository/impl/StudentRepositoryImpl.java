package ir.education.system.management.repository.impl;

import ir.education.system.management.domin.Student;
import ir.education.system.management.repository.StudentRepository;
import ir.education.system.management.repository.base.impl.BaseUserRepositoryImpl;

import javax.persistence.EntityManager;

public class StudentRepositoryImpl extends BaseUserRepositoryImpl<Student> implements StudentRepository {
    public StudentRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Student> getEntityClass() {
        return Student.class;
    }
}
