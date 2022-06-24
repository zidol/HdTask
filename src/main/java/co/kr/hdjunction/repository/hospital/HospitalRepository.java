package co.kr.hdjunction.repository.hospital;

import co.kr.hdjunction.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *  병원 관련 Repository
 */
public interface HospitalRepository extends JpaRepository<Hospital, Long> {

}
