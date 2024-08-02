package desafio.picpay.api.controller;

import desafio.picpay.api.dto.WalletInputDTO;
import desafio.picpay.api.dto.WalletOutputDTO;
import desafio.picpay.domain.service.WalletService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("wallets")
@AllArgsConstructor
public class WalletController {

    private WalletService walletService;

    @PostMapping
    public ResponseEntity<WalletOutputDTO> save(@RequestBody @Valid WalletInputDTO dto){
        return walletService.save(dto);
    }

    @GetMapping
    public List<WalletOutputDTO> showAll() {
        return walletService.showAll();
    }
}
