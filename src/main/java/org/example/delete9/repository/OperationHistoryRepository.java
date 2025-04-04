package org.example.delete9.repository;

import org.example.delete9.model.OperationHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationHistoryRepository extends JpaRepository<OperationHistory, Long> {

}
