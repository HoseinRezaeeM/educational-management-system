package ir.education.system.management.validation;

import ir.education.system.management.domin.Professor;
import ir.education.system.management.util.ApplicationContex;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class ProfessorValidation {
    public static void validationforSaveOrUpdateProfessor(Professor professor){
        ValidatorFactory factory;
        factory= Validation.byDefaultProvider().configure()
                .messageInterpolator(new ParameterMessageInterpolator())
                .buildValidatorFactory();
        Validator validator ;
        validator=factory.usingContext()
                .messageInterpolator(new ParameterMessageInterpolator())
                .getValidator();
//Hosen Rezaei
        Set<ConstraintViolation<Professor>> violations = validator.validate(professor);

        if (violations.isEmpty()) {
            ApplicationContex.getProfessorServiceImpl().save(professor);
            System.out.println("Professor saved successfully.");
        } else {
            for (ConstraintViolation<Professor> violation : violations) {
                System.out.println(violation.getPropertyPath() + ": " + violation.getMessage());
            }
            System.out.println("Professor validation failed. Not saving to the database.");
        }

        factory.close();
    }
    }

