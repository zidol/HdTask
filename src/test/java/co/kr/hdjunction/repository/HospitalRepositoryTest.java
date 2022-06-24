package co.kr.hdjunction.repository;

import co.kr.hdjunction.entity.Hospital;
import co.kr.hdjunction.repository.hospital.HospitalRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class HospitalRepositoryTest {

    @Autowired
    HospitalRepository hospitalRepository;

    @Test
    @DisplayName("병원 생성 및 조회 테스트")
    void hospitalCreateTest() throws Exception {

        //given
        Hospital newHospital = Hospital.builder()
                .hospitalName("지돌 병원")
                .nursingHomeNo("123ABC")
                .hospitalHeadName("지돌이")
                .build();

        Hospital savedHospital = hospitalRepository.save(newHospital);

        //when
        Hospital findHospital = hospitalRepository.findById(savedHospital.getId()).orElseThrow(() -> new Exception("조회 걀과가 없습니다."));

        //that
        assertThat(savedHospital.getId()).isEqualTo(findHospital.getId());
        assertThat(savedHospital.getHospitalName()).isEqualTo(findHospital.getHospitalName());
        assertThat(savedHospital.getHospitalHeadName()).isEqualTo(findHospital.getHospitalHeadName());
    }
}