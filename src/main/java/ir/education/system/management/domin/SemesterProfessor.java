package ir.education.system.management.domin;

import ir.education.system.management.base.domin.BaseEntity;
import ir.education.system.management.domin.enumeration.ProfessorType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class SemesterProfessor extends BaseEntity<Integer> {
    Integer semesterNumber;
    @Column(nullable = false)
    Integer unitNumber;
    String  semesterYear;
    @Column(nullable = false)
    Double salary;
    @Enumerated(value = EnumType.STRING)
    ProfessorType professorType;
    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    public SemesterProfessor(Integer semesterNumber, Integer unitNumber, String semesterYear, ProfessorType professorType, Professor professor) {
        this.semesterNumber = semesterNumber;
        this.unitNumber = unitNumber;
        this.semesterYear = semesterYear;
        this.salary = calculateSalary(semesterNumber);
        this.professorType = professorType;
        this.professor = professor;
    }

    public Double calculateSalary(Integer semesterNumber){
        double salary = 0;
        assert professorType != null;
        assert  unitNumber!=null;
        if(professorType==ProfessorType.FullPROFESSOR){
            salary = 5000000 + (unitNumber * 1000000);
        } else {
            salary = unitNumber * 1000000;
        }
        return salary;
    }
}
