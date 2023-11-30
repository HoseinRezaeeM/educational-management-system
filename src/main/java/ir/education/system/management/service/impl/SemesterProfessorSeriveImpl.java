package ir.education.system.management.service.impl;

import ir.education.system.management.base.service.impl.BaseEntityServiceImpl;
import ir.education.system.management.domin.Professor;
import ir.education.system.management.domin.SemesterProfessor;
import ir.education.system.management.repository.SemesterProfessorRepository;
import ir.education.system.management.service.SemesterProfessorService;

import java.util.List;
import java.util.Optional;

public class SemesterProfessorSeriveImpl extends BaseEntityServiceImpl<Integer,SemesterProfessor, SemesterProfessorRepository> implements SemesterProfessorService {

    public SemesterProfessorSeriveImpl(SemesterProfessorRepository baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<SemesterProfessor> findProfessorPayslip(int semester, String yearSemester, Professor professor) {
        return baseRepository.findProfessorPayslip(semester,yearSemester,professor);
    }
}
