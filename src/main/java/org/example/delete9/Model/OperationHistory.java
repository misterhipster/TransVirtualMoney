package org.example.delete9.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.delete9.Model.Enums.IdentificatorType;
import org.example.delete9.Model.Enums.OperationResult;
import org.example.delete9.Model.Enums.TransactionTool;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class OperationHistory{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Card senderCard;
    @ManyToOne
    private Card receiverCard;

    private BigDecimal operationSumm;
    private Date date;
    private OperationResult operationResult;
    private TransactionTool transactionMethod;
    private IdentificatorType identificatorType;

}
