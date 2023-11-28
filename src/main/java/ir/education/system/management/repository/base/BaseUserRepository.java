package ir.education.system.management.repository.base;

import ir.education.system.management.base.repository.BaseEntityRepository;
import ir.education.system.management.domin.base.BaseUser;

import java.util.Optional;

public interface BaseUserRepository<T extends BaseUser> extends BaseEntityRepository<Integer, T> {
    Optional<T> login(String username, String password);

    boolean existsByUsername(String username);
}
