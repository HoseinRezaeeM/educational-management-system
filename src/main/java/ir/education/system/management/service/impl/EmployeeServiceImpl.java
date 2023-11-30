package ir.education.system.management.service.impl;


import ir.education.system.management.domin.Employee;
import ir.education.system.management.repository.EmployeeRepository;
import ir.education.system.management.service.EmployeeService;
import ir.education.system.management.service.base.impl.BaseUserServiceImpl;

public class EmployeeServiceImpl extends BaseUserServiceImpl< Employee, EmployeeRepository> implements EmployeeService {
    public EmployeeServiceImpl(EmployeeRepository baseRepository) {
        super(baseRepository);
    }
}
