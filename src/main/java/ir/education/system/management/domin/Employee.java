package ir.education.system.management.domin;


import ir.education.system.management.domin.base.BaseUser;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;


@Entity
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee extends BaseUser {
    Long salary;
    String hiredData;

    public Employee(Integer integer) {
        super(integer);
    }

    public Employee(String firstname, String lastname, Integer age, String username,
                    String password, String email, String mobileNumber, Long salary, String hiredData) {
        super(firstname, lastname, age, username, password, email, mobileNumber);
        this.salary = salary;
        this.hiredData = hiredData;
    }
}
