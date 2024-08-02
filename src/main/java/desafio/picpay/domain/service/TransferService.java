package desafio.picpay.domain.service;

import desafio.picpay.api.dto.TransferInputDTO;
import desafio.picpay.api.dto.TransferOutputDTO;
import desafio.picpay.domain.exception.PicPayException;
import desafio.picpay.domain.model.Transfer;
import desafio.picpay.domain.model.Wallet;
import desafio.picpay.domain.repository.TransferRepository;
import desafio.picpay.domain.repository.WalletRepository;
import desafio.picpay.domain.service.strategy.TransferStrategy;
import desafio.picpay.domain.service.strategy.UserStrategy;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TransferService {

    private WalletRepository walletRepository;
    private TransferRepository transferRepository;
    private ModelMapper modelMapper;
    private List<UserStrategy> userStrategies;
    private List<TransferStrategy> transferStrategies;

    @Transactional
    public ResponseEntity<TransferOutputDTO> realizeTransfer(TransferInputDTO dto) {
        userStrategies.forEach(s -> s.validate(dto));
        transferStrategies.forEach(s -> s.validate(dto));

        Wallet payer = walletRepository.findById(dto.getPayer()).get();
        Wallet payee = walletRepository.findById(dto.getPayee()).get();

        payer = walletRepository.save(payer.decreaseBalance(dto.getValue()));
        payee = walletRepository.save(payee.increaseBalance(dto.getValue()));

        Transfer transfer = new Transfer(dto.getValue(), payer, payee);
        transfer = transferRepository.save(transfer);

        return ResponseEntity.ok(new TransferOutputDTO(transfer));
    }

    public List<TransferOutputDTO> showTransfers() {
        List<Transfer> transfers = transferRepository.findAll();

        if (transfers.isEmpty()) throw new PicPayException("Lista de transferência vazia");

        return transfers.stream()
                .map(TransferOutputDTO::new).collect(Collectors.toList());
    }
}
