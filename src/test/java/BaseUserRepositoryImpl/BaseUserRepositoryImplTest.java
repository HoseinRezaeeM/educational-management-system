package BaseUserRepositoryImpl;

import ir.education.system.management.domin.Employee;
import ir.education.system.management.util.ApplicationContex;
import ir.education.system.management.util.EntityManerFactoryProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BaseUserRepositoryImplTest {

    EntityManager entityManager;

    @BeforeEach
    void createObject() {
        entityManager = EntityManerFactoryProvider.getEntityManagerFactory().createEntityManager();
    }

    @Test
    void login() {
        Employee employee = new Employee(72);
        Optional<Employee> login = ApplicationContex.getEmployeeServiceImpl().login("HRRB", "QAa1@234");

        Assertions.assertEquals(employee.getId(), login.get().getId());
    }

    @Test
    void existsByUsername() {

        boolean existsByUsername = ApplicationContex.getEmployeeServiceImpl().existsByUsername("HRRB");
        Assertions.assertTrue(existsByUsername);
    }
}