package org.example.delete9.repository;

import org.example.delete9.Model.BankAccount;
import org.example.delete9.Model.OperationHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
}
