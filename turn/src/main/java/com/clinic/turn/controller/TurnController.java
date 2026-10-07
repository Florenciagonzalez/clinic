package com.clinic.turn.controller;

import com.clinic.turn.dto.RequestTurnDTO;
import com.clinic.turn.dto.ResponseTurnDTO;
import com.clinic.turn.service.ITurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/turns")
public class TurnController {
    @Autowired
    private ITurnService service;

    @GetMapping("")
    public ResponseEntity<List<ResponseTurnDTO>> getAll(){
        return ResponseEntity.ok(service.getAllTurns());
    }

    @PostMapping("")
    public ResponseEntity<ResponseTurnDTO> save(@RequestBody RequestTurnDTO t){
        ResponseTurnDTO newTurn = service.save(t);
        return ResponseEntity.created(URI.create("/api/turns/" + newTurn.getId())).body(newTurn);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseTurnDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }
}
