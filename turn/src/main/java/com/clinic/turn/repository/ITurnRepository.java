package com.clinic.turn.repository;

import com.clinic.turn.model.Turn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITurnRepository extends JpaRepository<Turn, Long> {
}
