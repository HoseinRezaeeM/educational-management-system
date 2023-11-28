package ir.education.system.management.repository.impl;

import ir.education.system.management.domin.base.BaseUser;
import ir.education.system.management.repository.UserRepository;
import ir.education.system.management.repository.base.impl.BaseUserRepositoryImpl;

import javax.persistence.EntityManager;

public class UserRepositoryImpl extends BaseUserRepositoryImpl<BaseUser> implements UserRepository {
    public UserRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<BaseUser> getEntityClass() {
        return BaseUser.class;
    }
}
