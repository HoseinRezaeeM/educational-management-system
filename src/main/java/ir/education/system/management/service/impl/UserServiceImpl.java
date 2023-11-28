package ir.education.system.management.service.impl;

import ir.education.system.management.domin.base.BaseUser;
import ir.education.system.management.repository.UserRepository;
import ir.education.system.management.service.UserService;
import ir.education.system.management.service.base.impl.BaseUserServiceImpl;

public class UserServiceImpl extends BaseUserServiceImpl<BaseUser, UserRepository> implements UserService {

    public UserServiceImpl(UserRepository baseRepository) {
        super(baseRepository);
    }
}
