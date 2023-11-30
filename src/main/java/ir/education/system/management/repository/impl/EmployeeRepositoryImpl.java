package ir.education.system.management.repository.impl;


import ir.education.system.management.domin.Employee;
import ir.education.system.management.repository.EmployeeRepository;
import ir.education.system.management.repository.base.impl.BaseUserRepositoryImpl;

import javax.persistence.EntityManager;

public  class EmployeeRepositoryImpl extends BaseUserRepositoryImpl<Employee> implements EmployeeRepository {
    public EmployeeRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Employee> getEntityClass() {
        return Employee.class;
    }
}
