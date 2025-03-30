package org.example.delete9.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.delete9.Model.Enums.IdentificatorType;
import org.example.delete9.Model.Enums.OperationStatus;
import org.example.delete9.Model.Enums.TransactionMethod;

import java.util.Date;

@Entity
@Getter
@Setter
public class OperationHistory{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Card senderCard;
    @ManyToOne
    private Card receiverCard;

    private Integer operationSumm;
    private Date date;
    private OperationStatus status;
    private TransactionMethod transactionMethod;
    private IdentificatorType identificatorType;

}
