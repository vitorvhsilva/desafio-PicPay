package desafio.picpay.api.dto;

import desafio.picpay.domain.model.WalletType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class WalletInputDTO {
    @NotBlank
    private String name;

    @NotBlank
    private String cpf;

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotNull
    private BigDecimal balance;

    @NotNull
    private WalletType type;
}
