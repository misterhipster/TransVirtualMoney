package org.example.delete9.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.delete9.model.Enums.IdentificatorType;
import org.example.delete9.model.Enums.OperationResult;
import org.example.delete9.model.Enums.TransactionTool;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OperationHistory{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private BankAccount senderCard;
    @ManyToOne
    private BankAccount receiverCard;

    private BigDecimal operationSumm;
    private Date date;
    private OperationResult operationResult;
    private TransactionTool transactionMethod;
    private IdentificatorType identificatorType;

}
