package co.kr.hdjunction.repository.patient;

import co.kr.hdjunction.dto.PatientDto;
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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

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
        Hospital savedHospital = saveHospital();

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

    private Hospital saveHospital() {
        Hospital hospital = Hospital.builder()
                .hospitalName("지돌병원")
                .hospitalHeadName("안지혁")
                .nursingHomeNo("111AAABBBCCC")
                .build();
        Hospital savedHospital = hospitalRepository.save(hospital);
        return savedHospital;
    }

    @Test
    void uuidTest() {
        System.out.println(LocalDateTime.now());
        System.out.println(Instant.now().getEpochSecond());
        System.out.println(Instant.now().getNano());
    }

    @Test
    @Transactional
    void changePatient() throws Exception {
        Hospital hospital = saveHospital();

        Hospital findHospital = hospitalRepository.findById(hospital.getId()).orElseThrow(() -> new Exception("찾으신 결과가 없습니다."));

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

        PatientDto changeData = PatientDto.builder()
                .patientName("환자명2")
                .patientRegNo("202200001")
                .gender(Gender.F)
                .birth("19880621")
                .mobile("010-2222-3333")
                .build();

        findPatient.changePatient(changeData);

        Patient findPatient2 = patientRepository.findById(savedPatient.getId()).orElseThrow(() -> new Exception("찾으신 결과가 없습니다."));

        assertThat(findPatient2.getPatientName()).isEqualTo("환자명2");
        assertThat(findPatient2.getPatientRegNo()).isEqualTo("202200001");
        assertThat(findPatient2.getGender()).isEqualTo(Gender.F);
        assertThat(findPatient2.getMobile()).isEqualTo("010-2222-3333");
    }
}