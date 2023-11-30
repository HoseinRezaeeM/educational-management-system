package ir.education.system.management.domin;

import ir.education.system.management.base.domin.BaseEntity;
import ir.education.system.management.domin.enumeration.CourseStatus;
import ir.education.system.management.domin.Course;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;


@Entity
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class SelectedCourse extends BaseEntity<Integer> {
    @DecimalMin(value = "0.0")
    @DecimalMax(value = "20.00")
    Double grade;
    Integer semester;
    @Enumerated(value = EnumType.STRING)
    CourseStatus courseStatus;
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "student_id")
    Student student;
    @ManyToOne
    @JoinColumn(name = "course_id")
    Course course;

    public SelectedCourse(Integer semester, Student student, Course course) {
        this.semester = semester;
        this.student = student;
        this.course = course;
    }


    public SelectedCourse(Double grade, Integer semester, Student student, Course course) {
        this.grade = grade;
        this.semester = semester;
        this.courseStatus = passOrFailSelectedCourse();
        this.student = student;
        this.course = course;
    }
    public CourseStatus passOrFailSelectedCourse(){
        CourseStatus courseStatus;
        if (grade > 10) {
            courseStatus = CourseStatus.PASS;
        } else {
            courseStatus = CourseStatus.FAIL;
        }
        return courseStatus;
    }
}
