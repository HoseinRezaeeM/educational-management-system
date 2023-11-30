package ir.education.system.management.validation;


import ir.education.system.management.domin.SelectedCourse;
import ir.education.system.management.util.ApplicationContex;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class SelectedCourseValidation {
    public static  void validationSelectedCourseForSaveOrUpdate(SelectedCourse selectedCourse){
        ValidatorFactory factory;
        factory= Validation.byDefaultProvider().configure()
                .messageInterpolator(new ParameterMessageInterpolator())
                .buildValidatorFactory();
        Validator validator ;
        validator=factory.usingContext()
                .messageInterpolator(new ParameterMessageInterpolator())
                .getValidator();
//Hosein Rezaei
        Set<ConstraintViolation<SelectedCourse>> violations = validator.validate(selectedCourse);

        if (violations.isEmpty()) {
            ApplicationContex.getSelectedCourseSreviceImpl().save(selectedCourse);
            System.out.println("SelectedCourse saved successfully.");
        } else {
            for (ConstraintViolation<SelectedCourse> violation : violations) {
                System.out.println(violation.getPropertyPath() + ": " + violation.getMessage());
            }
            System.out.println("SelectedCourse  validation failed. Not saving to the database.");
        }

        factory.close();
    }
    }

