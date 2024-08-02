package desafio.picpay.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Wallet {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank @Column(unique = true)
    private String cpf;

    @NotBlank @Column(unique = true)
    private String email;

    @NotBlank
    private String password;

    @NotNull
    private BigDecimal balance;

    @NotNull @Enumerated(value = EnumType.STRING)
    private WalletType type;

    public Wallet decreaseBalance(BigDecimal value) {
        this.balance = this.balance.subtract(value);
        return this;
    }

    public Wallet increaseBalance(BigDecimal value) {
        this.balance = this.balance.add(value);
        return this;
    }
}
