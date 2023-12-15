package pe.com.AutoPago.Purchase.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.com.AutoPago.Purchase.domain.model.aggregates.Result;
import pe.com.AutoPago.Purchase.domain.model.commands.CreateResultCommand;
import pe.com.AutoPago.Purchase.domain.model.queries.GetCreditByIdQuery;
import pe.com.AutoPago.Purchase.domain.services.CreditQueryService;
import pe.com.AutoPago.Purchase.domain.services.ResultCommandService;
import pe.com.AutoPago.Purchase.infrastructure.persistence.jpa.repositories.ResultRepository;

@Service
public class ResultCommandServiceImpl implements ResultCommandService {
    private final ResultRepository resultRepository;
    private final CreditQueryService creditQueryService;

    public ResultCommandServiceImpl(ResultRepository resultRepository, CreditQueryService creditQueryService) {
        this.resultRepository = resultRepository;
        this.creditQueryService = creditQueryService;
    }

    @Override
    public Long handle(CreateResultCommand command) {
        var getCreditByIdQuery = new GetCreditByIdQuery(command.creditId());
        var credit = creditQueryService.handle(getCreditByIdQuery).orElseThrow();
        var result = new Result(command.n(), command.graceType(), command.cok(), command.balanceFinalFee(), command.interestFinalFee(),
                command.amortizationFinalFee(), command.lifeInsuranceFinalFee(), command.finalBalanceFinalFee(), command.interest(),
                command.lifeInsurance(), command.fee(), command.amortization(), command.balance(), command.finalBalance(),
                command.flow(),command.riskInsurance(),command.gps(), command.ports(),command.adminBills(), credit);
        resultRepository.save(result);
        return result.getId();
    }
}
