package ir.education.system.management.repository.base.impl;

import ir.education.system.management.base.repository.impl.BaseEntityRepositoryImpl;
import ir.education.system.management.domin.base.BaseUser;
import ir.education.system.management.repository.base.BaseUserRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.Optional;

public abstract class BaseUserRepositoryImpl <T extends BaseUser> extends BaseEntityRepositoryImpl<Integer,T> implements BaseUserRepository<T> {

    public BaseUserRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }


    @Override
        public Optional<T> login(String username, String password) {
            try {
                return Optional.ofNullable(entityManager.createQuery("SELECT u FROM "
                                + getEntityClass().getSimpleName()
                                + " u WHERE u.username = :username AND u.password = :password", getEntityClass())
                        .setParameter("username", username)
                        .setParameter("password", password)
                        .getSingleResult());
            } catch (NoResultException e) {
                return Optional.empty();
            }
        }



    @Override
    public boolean existsByUsername(String username) {
        TypedQuery<Long> query = entityManager.createQuery(
                "select count(u) from "
                        + getEntityClass().getSimpleName()
                        + " u where u.username = :username",
                Long.class
        );
        query.setParameter("username", username);
        return query.getSingleResult() > 0;
    }
}
