package desafio.picpay.api.dto;

import desafio.picpay.domain.model.WalletType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class WalletOutputDTO {
    private Long id;
    private String name;
    private String cpf;
    private String email;
    private String password;
    private BigDecimal balance;
    private WalletType type;
}
