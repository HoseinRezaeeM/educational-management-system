package ir.education.system.management.domin.base;

import ir.education.system.management.base.domin.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;


import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseUser extends BaseEntity<Integer> {

    String firstname;
    String lastname;
    Integer age;
    String username;
    String password;
    String email;
    String mobileNumber;

    public BaseUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public BaseUser(Integer integer) {
        super(integer);
    }

    @Override
    public String toString() {
        return "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
    }
}
