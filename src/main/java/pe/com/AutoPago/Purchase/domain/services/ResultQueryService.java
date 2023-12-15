package pe.com.AutoPago.Purchase.domain.services;

import pe.com.AutoPago.Purchase.domain.model.aggregates.Result;
import pe.com.AutoPago.Purchase.domain.model.queries.GetAllResultsQuery;
import pe.com.AutoPago.Purchase.domain.model.queries.GetResultByIdQuery;

import java.util.List;
import java.util.Optional;

public interface ResultQueryService {
    List<Result> handle(GetAllResultsQuery query);
    Optional<Result> handle(GetResultByIdQuery query);
}
