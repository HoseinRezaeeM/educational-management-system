package ir.education.system.management.base.service;

import ir.education.system.management.base.domin.BaseEntity;


import java.io.Serializable;
import java.util.Collection;
import java.util.Optional;

public interface BaseEntityService<ID extends Serializable,T extends BaseEntity<ID>> {
    T save(T entity);

    T update(T entity,ID id);

    void deleteById(ID id);

    Collection<T> findAll();

    Optional<T> findById(ID id);
    void beginTransaction();

    void commitTransaction();

    void rollBack();
}
