package pe.com.AutoPago.Purchase.application.internal.queryservices;

import org.springframework.stereotype.Service;
import pe.com.AutoPago.Purchase.domain.model.entities.Credit;
import pe.com.AutoPago.Purchase.domain.model.queries.GetAllCreditsQuery;
import pe.com.AutoPago.Purchase.domain.model.queries.GetCreditByIdQuery;
import pe.com.AutoPago.Purchase.domain.services.CreditQueryService;
import pe.com.AutoPago.Purchase.infrastructure.persistence.jpa.repositories.CreditRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CreditQueryServiceImpl implements CreditQueryService {
    private final CreditRepository creditRepository;

    public CreditQueryServiceImpl(CreditRepository creditRepository) {
        this.creditRepository = creditRepository;
    }

    @Override
    public List<Credit> handle(GetAllCreditsQuery query) {
        return this.creditRepository.findAll();
    }

    @Override
    public Optional<Credit> handle(GetCreditByIdQuery query) {
        return this.creditRepository.findById(query.id());
    }
}
