package desafio.picpay.domain.service.strategy;

import desafio.picpay.api.dto.TransferInputDTO;
import desafio.picpay.domain.exception.PicPayException;
import desafio.picpay.domain.repository.WalletRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ValidatePayer implements UserStrategy{
    private WalletRepository walletRepository;

    @Override
    public void validate(TransferInputDTO dto) {
        walletRepository.findById(dto.getPayer())
                .orElseThrow(() -> new PicPayException("Usuário mercador não encontrado"));
    }
}
