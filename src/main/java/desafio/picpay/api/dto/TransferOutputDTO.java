package desafio.picpay.api.dto;

import desafio.picpay.domain.model.Transfer;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class TransferOutputDTO {

    private String id;
    private BigDecimal value;
    private Long payerId;
    private String payerName;
    private BigDecimal payerBalance;
    private Long payeeId;
    private String payeeName;
    private BigDecimal payeeBalance;

    public TransferOutputDTO(Transfer transfer) {
        this.id = transfer.getId();
        this.value = transfer.getAmount();
        this.payerId = transfer.getPayer().getId();
        this.payerName = transfer.getPayer().getName();
        this.payerBalance = transfer.getPayer().getBalance();
        this.payeeId = transfer.getPayee().getId();
        this.payeeName = transfer.getPayee().getName();
        this.payeeBalance = transfer.getPayee().getBalance();
    }

}
