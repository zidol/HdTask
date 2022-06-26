package co.kr.hdjunction.dto;

import co.kr.hdjunction.entity.Gender;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
public class PatientDto {

    @NotBlank
    @Max(45)
    private String patientName;

    @NotBlank
    @Max(13)
    private String patientRegNo;

    @NotNull
    private Gender gender;

    @NotBlank
    @Max(10)
    private String birth;

    @NotBlank
    @Max(20)
    private String mobile;
}
