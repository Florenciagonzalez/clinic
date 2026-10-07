package com.clinic.turn.service;


import com.clinic.turn.dto.RequestTurnDTO;
import com.clinic.turn.dto.ResponseTurnDTO;

import java.util.List;

public interface ITurnService {
    List<ResponseTurnDTO> getAllTurns();
    ResponseTurnDTO findById(Long id);
    ResponseTurnDTO save(RequestTurnDTO t);
    void delete(Long id);
    void update(Long id, ResponseTurnDTO t);

}
