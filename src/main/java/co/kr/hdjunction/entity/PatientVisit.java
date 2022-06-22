package co.kr.hdjunction.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 환자방문 Entity
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class PatientVisit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_visit_id")
    private Long id;

    //접수 일시
    private LocalDateTime receptionDate;

    //방문상태코드
    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private VisitStatus visitStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id", foreignKey = @ForeignKey(name = "fk_patient_PatientVisit_id"))
    private Hospital hospital;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", foreignKey = @ForeignKey(name = "fk_patient_PatientVisit_id"))
    private Patient patient;

    //연관관계 편의 메서드
    public void changePatient(Patient patient) {
        this.patient = patient;
        patient.getPatientVisits().add(this);
    }
}
