package ir.education.system.management.domin;

import ir.education.system.management.domin.base.BaseUser;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@PrimaryKeyJoinColumn(name = "professor_id")
public class Professor extends BaseUser {

    @ToString.Exclude
    @OneToMany(mappedBy = "professor")
    List<SemesterProfessor> professorList;

    public Professor(String firstname, String lastname, Integer age, String username,
                     String password, String email, String mobileNumber) {
        super(firstname, lastname, age, username, password, email, mobileNumber);

    }

    public Professor(Integer integer) {
        super(integer);
    }

    @Override
    public String toString() {
        return "Professor "+super.toString();
    }
}
