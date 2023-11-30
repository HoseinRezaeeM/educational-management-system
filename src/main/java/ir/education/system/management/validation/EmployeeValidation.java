package ir.education.system.management.validation;

import ir.education.system.management.domin.Employee;
import ir.education.system.management.util.ApplicationContex;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class EmployeeValidation {

    public static void validationforSaveOrUpdateEmployee(Employee employee){
        ValidatorFactory factory;
        factory= Validation.byDefaultProvider().configure()
                .messageInterpolator(new ParameterMessageInterpolator())
                .buildValidatorFactory();
        Validator validator ;
        validator=factory.usingContext()
                .messageInterpolator(new ParameterMessageInterpolator())
                .getValidator();
//Hosein Rezaei
        Set<ConstraintViolation<Employee>> violations = validator.validate(employee);

        if (violations.isEmpty()) {
            ApplicationContex.getEmployeeServiceImpl().save(employee);
            System.out.println("Employee saved successfully.");
        } else {
            for (ConstraintViolation<Employee> violation : violations) {
                System.out.println(violation.getPropertyPath() + ": " + violation.getMessage());
            }
            System.out.println("Employee validation failed. Not saving to the database.");
        }

        factory.close();
    }
    }

