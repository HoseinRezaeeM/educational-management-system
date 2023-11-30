package ir.education.system.management.service;

import ir.education.system.management.base.service.BaseEntityService;
import ir.education.system.management.domin.Professor;
import ir.education.system.management.domin.SemesterProfessor;

import java.util.List;
import java.util.Optional;

public interface SemesterProfessorService extends BaseEntityService<Integer, SemesterProfessor> {
    List findProfessorPayslip(int semester, String yearSemester, Professor professor);
}
