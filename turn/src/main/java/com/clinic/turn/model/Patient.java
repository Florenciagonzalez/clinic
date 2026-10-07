package com.clinic.turn.model;

import lombok.*;

import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Patient {
    private Long id;
    private String name;
    private String surname;
    private LocalDate birthDate;
    private String dni;
    private String tel;
}
