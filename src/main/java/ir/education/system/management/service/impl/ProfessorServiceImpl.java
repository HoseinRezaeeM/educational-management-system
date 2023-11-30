package ir.education.system.management.service.impl;

import ir.education.system.management.base.service.impl.BaseEntityServiceImpl;
import ir.education.system.management.domin.Professor;
import ir.education.system.management.repository.ProfessorRepository;
import ir.education.system.management.service.ProfessorService;
import ir.education.system.management.service.base.impl.BaseUserServiceImpl;

public class ProfessorServiceImpl extends BaseUserServiceImpl< Professor, ProfessorRepository> implements ProfessorService {
    public ProfessorServiceImpl(ProfessorRepository baseRepository) {
        super(baseRepository);
    }
}
