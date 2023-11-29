package ir.education.system.management.domin;

import ir.education.system.management.base.domin.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@PrimaryKeyJoinColumn(name = "course_id")
public class Course extends BaseEntity<Integer> {
    String name;
    Integer unit;
    String startData;
    String examData;
    @OneToOne
    Professor professor;
    @ToString.Exclude
    @OneToMany(mappedBy = "course")
    List<SelectedCourse> courseList;

    public Course(Integer integer) {
        super(integer);
    }

    public Course(String name, Integer unit, String startData, String examData, Professor professor) {
        this.name = name;
        this.unit = unit;
        this.startData = startData;
        this.examData = examData;
        this.professor = professor;
    }

}
