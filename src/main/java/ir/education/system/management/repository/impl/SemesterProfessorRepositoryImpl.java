package ir.education.system.management.repository.impl;

import ir.education.system.management.base.repository.impl.BaseEntityRepositoryImpl;
import ir.education.system.management.domin.Professor;
import ir.education.system.management.domin.SemesterProfessor;
import ir.education.system.management.repository.SemesterProfessorRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
@SuppressWarnings("unchecked")
public class SemesterProfessorRepositoryImpl extends BaseEntityRepositoryImpl<Integer, SemesterProfessor> implements SemesterProfessorRepository {
    public SemesterProfessorRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<SemesterProfessor> getEntityClass() {
        return SemesterProfessor.class;
    }

    @Override
    public List findProfessorPayslip(int semesterNumber, String semesterYear, Professor professor) {
         Query query = entityManager.createQuery("SELECT s FROM SemesterProfessor s " +
                "WHERE s.semesterNumber =: semesterNumber AND s.semesterYear =:semesterYear AND s.professor =:professor");
         query.setParameter("semesterNumber",semesterNumber);
         query.setParameter("semesterYear",semesterYear);
         query.setParameter("professor",professor);
         if (query.getResultList().isEmpty()){
             System.out.println("No Information !!!");
         }
        return query.getResultList();
    }
}
