package desafio.picpay.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transfer {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotNull
    private BigDecimal amount;

    @NotNull @ManyToOne @JoinColumn(name = "payer_id")
    private Wallet payer;

    @NotNull @ManyToOne @JoinColumn(name = "payee_id")
    private Wallet payee;

    public Transfer(BigDecimal amount, Wallet payer, Wallet payee) {
        this.amount = amount;
        this.payer = payer;
        this.payee = payee;
    }
}
