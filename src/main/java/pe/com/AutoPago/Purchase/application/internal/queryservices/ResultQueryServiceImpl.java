package pe.com.AutoPago.Purchase.application.internal.queryservices;

import org.springframework.stereotype.Service;
import pe.com.AutoPago.Purchase.domain.model.aggregates.Result;
import pe.com.AutoPago.Purchase.domain.model.queries.GetAllResultsQuery;
import pe.com.AutoPago.Purchase.domain.model.queries.GetResultByIdQuery;
import pe.com.AutoPago.Purchase.domain.services.ResultQueryService;
import pe.com.AutoPago.Purchase.infrastructure.persistence.jpa.repositories.ResultRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ResultQueryServiceImpl implements ResultQueryService {
    private final ResultRepository resultRepository;

    public ResultQueryServiceImpl(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    @Override
    public List<Result> handle(GetAllResultsQuery query) {
        return resultRepository.findAll();
    }

    @Override
    public Optional<Result> handle(GetResultByIdQuery query) {
        return resultRepository.findById(query.id());
    }
}
