package co.kr.hdjunction.repository.patient;

import co.kr.hdjunction.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 환자 관련 Repository
 */
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
