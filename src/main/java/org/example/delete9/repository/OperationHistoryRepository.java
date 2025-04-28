package org.example.delete9.repository;

import lombok.Builder;
import org.example.delete9.model.OperationHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Repository
public interface OperationHistoryRepository extends JpaRepository<OperationHistory, Long> {

}
