package baserepositorytest;

import ir.education.system.management.domin.Employee;
import ir.education.system.management.util.ApplicationContex;
import ir.education.system.management.util.EntityManerFactoryProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;

import java.util.Collection;
import java.util.Optional;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;

class BaseEntityRepositoryImplTest {

    EntityManager entityManager;

    @BeforeEach
    void createObject() {
        entityManager = EntityManerFactoryProvider.getEntityManagerFactory().createEntityManager();
    }

    @Test
    void save() {
        Employee employee = new Employee("Hosein", "Rezaei", 25, "HRRB", "QAa1@234", "rezaeen77@emial.com", "09125174512", "1401");
        ApplicationContex.getEmployeeServiceImpl().save(employee);
        boolean contains = ApplicationContex.getEmployeeServiceImpl().existsByUsername("HRRB");
        Assertions
                .assertTrue(contains);
    }

    @Test
    void update() {
        Employee employee = new Employee();
        Employee newEmployee =new Employee("Hassan", "Rezaei", 25, "HRRB", "QAa1@234", "rezaeen77@emial.com", "09125174512", "1401");
        newEmployee.setFirstname("Hassan");
        ApplicationContex.getEmployeeServiceImpl().update(newEmployee,64);
        final Optional<Employee> optionalEmployee = ApplicationContex.getEmployeeServiceImpl().findById(64);
        Assertions
                .assertEquals(newEmployee.getFirstname(),optionalEmployee.get().getFirstname());
    }

    @Test
    void deleteById() {
        ApplicationContex.getEmployeeServiceImpl().deleteById(63);
        final Optional<Employee> optionalEmployee = ApplicationContex.getEmployeeServiceImpl().findById(63);
        Assertions.assertTrue(optionalEmployee.isEmpty());
    }

    @Test
    void findAll() {
        final Collection<Employee> all = ApplicationContex.getEmployeeServiceImpl().findAll();
        Assertions.assertNotNull(all);
    }
}