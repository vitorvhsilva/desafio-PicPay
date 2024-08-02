package desafio.picpay.domain.repository;

import desafio.picpay.domain.model.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<Transfer, String> {
}
