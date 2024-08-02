package desafio.picpay.domain.service.strategy;

import desafio.picpay.api.dto.TransferInputDTO;

public interface TransferStrategy {
    void validate(TransferInputDTO dto);
}
