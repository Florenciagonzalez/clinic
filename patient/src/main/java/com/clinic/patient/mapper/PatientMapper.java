package com.clinic.patient.mapper;

import com.clinic.patient.dto.PatientDTO;
import com.clinic.patient.model.Patient;

public class PatientMapper {

    public static PatientDTO toDTO(Patient p){
        return PatientDTO.builder()
                .id(p.getId())
                .name(p.getName())
                .surname(p.getSurname())
                .birthDate(p.getBirthDate())
                .dni(p.getDni())
                .tel(p.getTel())
                .build();
    }

}
