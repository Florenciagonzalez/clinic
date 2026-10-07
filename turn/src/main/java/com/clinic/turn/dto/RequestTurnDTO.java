package com.clinic.turn.dto;

import lombok.*;

import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestTurnDTO {
    private LocalDate date;
    private String treatment;
    private String dni;
}
