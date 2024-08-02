package desafio.picpay.domain.service.strategy;

import desafio.picpay.api.dto.TransferInputDTO;

public interface UserStrategy {
    void validate(TransferInputDTO dto);
}
