package ir.education.system.management.service.base.impl;

import ir.education.system.management.base.service.impl.BaseEntityServiceImpl;
import ir.education.system.management.domin.base.BaseUser;
import ir.education.system.management.repository.base.BaseUserRepository;
import ir.education.system.management.service.base.BaseUserService;

import java.util.Optional;

public class BaseUserServiceImpl<T extends BaseUser,R extends BaseUserRepository<T>> extends BaseEntityServiceImpl<Integer,T,R> implements BaseUserService<T> {
    public BaseUserServiceImpl(R baseRepository) {
        super(baseRepository);
    }



    @Override
    public Optional<T> login(String username, String password) {
        return baseRepository.login(username,password);
    }

    @Override
    public boolean existsByUsername(String username) {
        return baseRepository.existsByUsername(username);
    }
}
