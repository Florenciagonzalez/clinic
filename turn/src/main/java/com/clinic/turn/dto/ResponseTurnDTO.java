package com.clinic.turn.dto;

import lombok.*;

import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseTurnDTO {
    private Long id;
    private LocalDate date;
    private String patientFullname;
    private String treatment;
}
