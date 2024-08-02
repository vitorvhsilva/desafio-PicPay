package desafio.picpay.domain.service.strategy;

import desafio.picpay.api.dto.TransferInputDTO;
import desafio.picpay.domain.exception.PicPayException;
import desafio.picpay.domain.model.Wallet;
import desafio.picpay.domain.model.WalletType;
import desafio.picpay.domain.repository.WalletRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ValidateWalletType implements TransferStrategy{

    private WalletRepository walletRepository;

    @Override
    public void validate(TransferInputDTO dto) {
        Wallet user = walletRepository.findById(dto.getPayer()).get();

        if (user.getType().equals(WalletType.MERCHANT)) throw new PicPayException("Usuário mercador não pode transferir dinheiro!");

    }
}
