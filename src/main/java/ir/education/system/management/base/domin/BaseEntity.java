package ir.education.system.management.base.domin;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class BaseEntity<ID extends Serializable> {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    ID id;

}
