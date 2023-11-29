package ir.education.system.management.domin;

import ir.education.system.management.domin.base.BaseUser;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name ="student")
public class Student extends BaseUser {
    String entriesData;
    @OneToMany(mappedBy = "student")
    List<SelectedCourse> list;

    public Student(String firstname, String lastname, Integer age, String username, String password,
                   String email, String mobileNumber, String entriesData) {
        super(firstname, lastname, age, username, password, email, mobileNumber);
        this.entriesData = entriesData;

    }

    public Student(Integer integer) {
        super(integer);
    }

    @Override
    public String toString() {
        return "Student{" +super.toString()+
                "entriesData='" + entriesData + '\'' +
                '}';
    }
}
