package com.clinic.patient.controller;

import com.clinic.patient.dto.PatientDTO;
import com.clinic.patient.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
    @Autowired
    private IPatientService service;

    @GetMapping("")
    public ResponseEntity<List<PatientDTO>> getAllPatients(){
        return ResponseEntity.ok(service.getAllPatients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping("")
    public ResponseEntity<PatientDTO> save(@RequestBody PatientDTO p){
        PatientDTO newPatient = service.save(p);
        return ResponseEntity.created(URI.create("/api/patients/" + newPatient.getId())).body(newPatient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientDTO> update(@RequestBody PatientDTO p, @PathVariable Long id){
        return ResponseEntity.ok(service.update(p, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/dni/{dni}")
    public ResponseEntity<PatientDTO> findByDni(@PathVariable String dni){
        return ResponseEntity.ok(service.findByDni(dni));
    }


}
