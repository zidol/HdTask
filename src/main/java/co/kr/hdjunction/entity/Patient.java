package co.kr.hdjunction.entity;


import co.kr.hdjunction.dto.PatientDto;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static co.kr.hdjunction.entity.QPatient.patient;

/**
 * 환자 Entity
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Long id;

    //환자 명
    @Setter
    @Column(name = "patient_name", length = 45, nullable = false)
    private String patientName;

    //환자 등록 번호
    @Setter
    @Column(name = "patient_reg_no", length = 13, nullable = false)
    private String patientRegNo;

    //성별
    @Setter
    @Column(length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    //생년월일
    @Setter
    @Column(length = 10)
    private String birth;

    //휴대전화 번호
    @Setter
    @Column(length = 20)
    private String mobile;


    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id", foreignKey = @ForeignKey(name = "fk_hospital_patient_id"))
    private Hospital hospital;

    @OneToMany(mappedBy = "patient")
    private List<PatientVisit> patientVisits = new ArrayList<>();

    public void changePatient(PatientDto patientDto) {
        this.setPatientName(patientDto.getPatientName());
        this.setPatientRegNo(patientDto.getPatientRegNo());
        this.setGender(patientDto.getGender());
        this.setBirth(patientDto.getBirth());
        this.setMobile(patientDto.getMobile());
    }

}
