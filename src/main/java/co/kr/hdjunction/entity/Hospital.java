package co.kr.hdjunction.entity;

import lombok.*;

import javax.persistence.*;

/**
 * 병원 Entity
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hospital_id")
    private Long id;

    //병원명
    @Setter
    @Column(name = "hospital_name", length = 45, nullable = false)
    private String hospitalName;

    //요양기관번호
    @Setter
    @Column(name = "nursing_home_no", length = 20, nullable = false)
    private String nursingHomeNo;

    //병원장명
    @Setter
    @Column(name = "hospital_head_name", length = 10, nullable = false)
    private String hospitalHeadName;




}
