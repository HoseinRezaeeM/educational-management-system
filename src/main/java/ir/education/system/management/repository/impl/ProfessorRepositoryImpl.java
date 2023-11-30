package ir.education.system.management.repository.impl;


import ir.education.system.management.domin.Professor;
import ir.education.system.management.repository.ProfessorRepository;
import ir.education.system.management.repository.base.impl.BaseUserRepositoryImpl;

import javax.persistence.EntityManager;

public class ProfessorRepositoryImpl extends BaseUserRepositoryImpl<Professor> implements ProfessorRepository {
    public ProfessorRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Professor> getEntityClass() {
        return Professor.class;
    }
}
