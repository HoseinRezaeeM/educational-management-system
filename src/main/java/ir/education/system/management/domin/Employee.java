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
                    String password, String email, String mobileNumber, String hiredData) {
        super(firstname, lastname, age, username, password, email, mobileNumber);
        this.salary = getSalary();
        this.hiredData = hiredData;
    }

    public Long getSalary() {
        return 15000000L;
    }

    @Override
    public String toString() {
        return  super.toString()+
                "salary=" + salary +
                ", hiredData='" + hiredData + '\'' +
                '}';
    }
}
