package com.clinic.patient.service;

import com.clinic.patient.dto.PatientDTO;
import com.clinic.patient.mapper.PatientMapper;
import com.clinic.patient.model.Patient;
import com.clinic.patient.repository.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService implements IPatientService{
    @Autowired
    private IPatientRepository repository;

    @Override
    public List<PatientDTO> getAllPatients() {
        return repository.findAll().stream().map(PatientMapper::toDTO).toList();
    }

    @Override
    public PatientDTO save(PatientDTO p) {
        Patient patient = Patient.builder()
                .name(p.getName())
                .surname(p.getSurname())
                .birthDate(p.getBirthDate())
                .dni(p.getDni())
                .tel(p.getTel())
                .build();

        repository.save(patient);

        return PatientMapper.toDTO(patient);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)){
            throw new RuntimeException("El paciente no fue encontrado.");
        }
       repository.deleteById(id);
    }

    @Override
    public PatientDTO findById(Long id) {
        Patient p = repository.findById(id).orElseThrow(() -> new RuntimeException("El paciente no fue encontrado."));
        return PatientMapper.toDTO(p);
    }

    @Override
    public PatientDTO update(PatientDTO p, Long id) {
        if (!repository.existsById(id)){
            throw new RuntimeException("El paciente no fue encontrado.");
        }

        Patient updated = Patient.builder()
                .id(p.getId())
                .name(p.getName())
                .surname(p.getSurname())
                .birthDate(p.getBirthDate())
                .dni(p.getDni())
                .tel(p.getTel())
                .build();

        repository.save(updated);
        return PatientMapper.toDTO(updated);
    }
}
