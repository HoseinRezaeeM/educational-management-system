package ir.education.system.management.domin;

import ir.education.system.management.base.domin.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@PrimaryKeyJoinColumn(name = "course_id")
public class Course extends BaseEntity<Integer> {
    String name;
    Integer unit;
    String startData;
    String examData;
    @OneToOne(fetch = FetchType.EAGER)
    Professor professor;
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

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", unit=" + unit +
                ", startData='" + startData + '\'' +
                " Professor name ="+professor.getLastname()+
                ", examData='" + examData + '\'' +
                '}';
    }
}
