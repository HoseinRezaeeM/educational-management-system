package ir.education.system.management.repository;

import ir.education.system.management.base.repository.BaseEntityRepository;
import ir.education.system.management.domin.Professor;
import ir.education.system.management.domin.SemesterProfessor;

import java.util.List;
import java.util.Optional;

public interface SemesterProfessorRepository extends BaseEntityRepository<Integer, SemesterProfessor> {
    List<SemesterProfessor> findProfessorPayslip(int semester, String yearSemester, Professor professor);
}
