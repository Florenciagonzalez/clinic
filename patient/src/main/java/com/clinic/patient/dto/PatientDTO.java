package com.clinic.patient.dto;

import lombok.*;

import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientDTO {
    private Long id;
    private String name;
    private String surname;
    private LocalDate birthDate;
    private String dni;
    private String tel;
}
