package com.clinic.patient.service;

import com.clinic.patient.dto.PatientDTO;

import java.util.List;

public interface IPatientService {
    List<PatientDTO> getAllPatients();
    PatientDTO save(PatientDTO p);
    void delete(Long id);
    PatientDTO findById(Long id);
    PatientDTO update(PatientDTO p, Long id);
    PatientDTO findByDni(String dni);
}
