package co.kr.hdjunction.repository.patientvisit;

import co.kr.hdjunction.entity.PatientVisit;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *  환자방문 관련 Repository
 */
public interface PatientVisitRepository extends JpaRepository<PatientVisit, Long> {

}
