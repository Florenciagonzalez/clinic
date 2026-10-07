package com.clinic.turn.mapper;

import com.clinic.turn.dto.ResponseTurnDTO;
import com.clinic.turn.model.Turn;

public class TurnMapper {

    public static ResponseTurnDTO toDTO(Turn t){
        return ResponseTurnDTO.builder()
                .id(t.getId())
                .date(t.getDate())
                .patientFullname(t.getPatientFullname())
                .treatment(t.getTreatment())
                .build();
    }
}
