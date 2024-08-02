package desafio.picpay.api.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransferInputDTO {
    @NotNull
    private BigDecimal value;

    @NotNull
    private Long payer;

    @NotNull
    private Long payee;
}
