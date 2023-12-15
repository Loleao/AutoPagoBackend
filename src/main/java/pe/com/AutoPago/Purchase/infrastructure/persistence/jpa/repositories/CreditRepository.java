package pe.com.AutoPago.Purchase.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.AutoPago.Purchase.domain.model.entities.Credit;

public interface CreditRepository extends JpaRepository<Credit, Long> {
}
