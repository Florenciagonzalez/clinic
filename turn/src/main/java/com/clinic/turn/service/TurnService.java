package com.clinic.turn.service;

import com.clinic.turn.dto.RequestTurnDTO;
import com.clinic.turn.dto.ResponseTurnDTO;
import com.clinic.turn.mapper.TurnMapper;
import com.clinic.turn.model.Patient;
import com.clinic.turn.model.Turn;
import com.clinic.turn.repository.ITurnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class TurnService implements ITurnService{
    @Autowired
    private ITurnRepository repository;
    @Autowired
    private RestTemplate apiPatients;

    @Override
    public List<ResponseTurnDTO> getAllTurns() {
        return repository.findAll().stream().map(TurnMapper::toDTO).toList();
    }

    @Override
    public ResponseTurnDTO findById(Long id) {
        Turn t = repository.findById(id).orElseThrow(() -> new RuntimeException("El turno no pudo ser encontrado."));
        return TurnMapper.toDTO(t);
    }

    @Override
    public ResponseTurnDTO save(RequestTurnDTO t) {
        Patient p = apiPatients.getForObject("http://localhost:9001/api/patients/dni/"+ t.getDni(), Patient.class);
        String fullName = p.getName() + " " + p.getSurname();

        Turn newTurn = Turn.builder()
                .date(t.getDate())
                .patientFullname(fullName)
                .treatment(t.getTreatment())
                .build();

        repository.save(newTurn);
        return TurnMapper.toDTO(newTurn);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)){
            throw new RuntimeException("El turno no fue encontrado");
        }
        repository.deleteById(id);
    }

    @Override
    public void update(Long id, ResponseTurnDTO t) {
        Turn updated = Turn.builder()
                .id(t.getId())
                .patientFullname(t.getPatientFullname())
                .date(t.getDate())
                .treatment(t.getTreatment())
                .build();

        repository.save(updated);
    }
}
