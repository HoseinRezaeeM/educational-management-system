package ir.education.system.management.validation;


import ir.education.system.management.domin.Student;
import ir.education.system.management.util.ApplicationContex;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class StudentValidation {
    public static void validationStuentForSaveOrUpdate(Student student){
        ValidatorFactory factory;
        factory= Validation.byDefaultProvider().configure()
                .messageInterpolator(new ParameterMessageInterpolator())
                .buildValidatorFactory();
        Validator validator ;
        validator=factory.usingContext()
                .messageInterpolator(new ParameterMessageInterpolator())
                .getValidator();
//Hosein Rezaei
        Set<ConstraintViolation<Student>> violations = validator.validate(student);

        if (violations.isEmpty()) {
            ApplicationContex.getStudentServiceImpl().save(student);
            System.out.println("Teacher saved successfully.");
        } else {
            for (ConstraintViolation<Student> violation : violations) {
                System.out.println(violation.getPropertyPath() + ": " + violation.getMessage());
            }
            System.out.println("Teacher validation failed. Not saving to the database.");
        }

        factory.close();
    }
    }

