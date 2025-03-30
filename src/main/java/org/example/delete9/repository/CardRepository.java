package org.example.delete9.repository;

import org.example.delete9.Model.Card;
import org.example.delete9.Model.OperationHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
}
