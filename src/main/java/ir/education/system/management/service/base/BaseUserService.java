package ir.education.system.management.service.base;

import ir.education.system.management.base.service.BaseEntityService;
import ir.education.system.management.domin.base.BaseUser;

import java.util.Optional;

public interface BaseUserService<T extends BaseUser> extends BaseEntityService<Integer,T> {
    Optional<T> login(String username, String password);

    boolean existsByUsername(String username);
}
