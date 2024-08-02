package desafio.picpay.api.controller;

import desafio.picpay.api.dto.TransferInputDTO;
import desafio.picpay.api.dto.TransferOutputDTO;
import desafio.picpay.domain.service.TransferService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("transfers")
@AllArgsConstructor
public class TransferController {

    private TransferService transferService;

    @PostMapping
    public ResponseEntity<TransferOutputDTO> realizeTransfer(@RequestBody @Valid TransferInputDTO dto) {
        return transferService.realizeTransfer(dto);
    }

    @GetMapping
    public List<TransferOutputDTO> showTransfers() {
        return transferService.showTransfers();
    }
}
