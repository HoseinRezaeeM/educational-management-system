package ir.education.system.management.validation;

import ir.education.system.management.domin.Course;
import ir.education.system.management.util.ApplicationContex;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class CourseValidation {

    public static void validatonforSaveOrUpdateCourse(Course course) {
        ValidatorFactory factory;
        factory = Validation.byDefaultProvider().configure()
                .messageInterpolator(new ParameterMessageInterpolator())
                .buildValidatorFactory();
        Validator validator;
        validator = factory.usingContext()
                .messageInterpolator(new ParameterMessageInterpolator())
                .getValidator();
//Hosein Rezaei
        Set<ConstraintViolation<Course>> violations = validator.validate(course);

        if (violations.isEmpty()) {
            ApplicationContex.getCourseServiceImpl().save(course);
            System.out.println("Teacher saved successfully.");
        } else {
            for (ConstraintViolation<Course> violation : violations) {
                System.out.println(violation.getPropertyPath() + ": " + violation.getMessage());
            }
            System.out.println("Teacher validation failed. Not saving to the database.");
        }

        factory.close();
    }
}

