package pe.com.AutoPago.Purchase.domain.services;

import pe.com.AutoPago.Purchase.domain.model.entities.Credit;
import pe.com.AutoPago.Purchase.domain.model.queries.GetAllCreditsQuery;
import pe.com.AutoPago.Purchase.domain.model.queries.GetCreditByIdQuery;

import java.util.List;
import java.util.Optional;

public interface CreditQueryService {
    List<Credit> handle(GetAllCreditsQuery query);

    Optional<Credit> handle(GetCreditByIdQuery query);
}
