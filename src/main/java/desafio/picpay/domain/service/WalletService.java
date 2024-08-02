package desafio.picpay.domain.service;

import desafio.picpay.api.dto.WalletInputDTO;
import desafio.picpay.api.dto.WalletOutputDTO;
import desafio.picpay.domain.exception.PicPayException;
import desafio.picpay.domain.model.Wallet;
import desafio.picpay.domain.repository.WalletRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class WalletService {

    private WalletRepository walletRepository;
    private ModelMapper modelMapper;

    public ResponseEntity<WalletOutputDTO> save(WalletInputDTO dto) {
        Optional<Wallet> verify = walletRepository.findByCpfOrEmail(dto.getCpf(), dto.getEmail());

        if (verify.isPresent()) throw new PicPayException("Cpf ou Email já existe");

        Wallet wallet = walletRepository.save(modelMapper.map(dto, Wallet.class));

        return ResponseEntity.ok(modelMapper.map(wallet, WalletOutputDTO.class));
    }


    public List<WalletOutputDTO> showAll() {
        List<Wallet> wallets = walletRepository.findAll();

        if (wallets.isEmpty()) throw new PicPayException("Nenhum usuário cadastrado");

        return wallets.stream()
                .map(w -> modelMapper.map(w, WalletOutputDTO.class)).collect(Collectors.toList());
    }
}
