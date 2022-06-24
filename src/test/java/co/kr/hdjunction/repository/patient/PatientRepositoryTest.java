package co.kr.hdjunction.repository.patient;

import co.kr.hdjunction.entity.Gender;
import co.kr.hdjunction.entity.Hospital;
import co.kr.hdjunction.entity.Patient;
import co.kr.hdjunction.repository.hospital.HospitalRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PatientRepositoryTest {

    @Autowired
    HospitalRepository hospitalRepository;

    @Autowired
    PatientRepository patientRepository;

    @Test
    @DisplayName("환자 등록 및 조회 테스트")
    @Transactional
    void patientCreateAndFindTest() throws Exception {

        //given
        Hospital hospital = Hospital.builder()
                .hospitalName("지돌병원")
                .hospitalHeadName("안지혁")
                .nursingHomeNo("111AAABBBCCC")
                .build();
        Hospital savedHospital = hospitalRepository.save(hospital);

        Hospital findHospital = hospitalRepository.findById(savedHospital.getId()).orElseThrow(() -> new Exception("찾으신 결과가 없습니다."));

        //when
        Patient patient = Patient.builder()
                .patientName("환자명1")
                .patientRegNo("202200001")
                .gender(Gender.M)
                .birth("19880621")
                .mobile("010-1111-2222")
                .hospital(findHospital)
                .build();

        Patient savedPatient = patientRepository.save(patient);

        Patient findPatient = patientRepository.findById(savedPatient.getId()).orElseThrow(() -> new Exception("찾으신 결과가 없습니다."));

        //then
        assertThat(savedPatient.getId()).isEqualTo(findPatient.getId());
        assertThat(savedPatient.getPatientName()).isEqualTo(findPatient.getPatientName());
        assertThat(savedPatient.getPatientRegNo()).isEqualTo(findPatient.getPatientRegNo());
    }
}