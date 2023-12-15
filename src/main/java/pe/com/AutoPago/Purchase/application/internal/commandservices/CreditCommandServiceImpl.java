package pe.com.AutoPago.Purchase.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.com.AutoPago.Purchase.domain.model.commands.CreateCreditCommand;
import pe.com.AutoPago.Purchase.domain.model.entities.Credit;
import pe.com.AutoPago.Purchase.domain.services.CreditCommandService;
import pe.com.AutoPago.Purchase.infrastructure.persistence.jpa.repositories.CreditRepository;

@Service
public class CreditCommandServiceImpl implements CreditCommandService {
    private final CreditRepository creditRepository;

    public CreditCommandServiceImpl(CreditRepository creditRepository) {
        this.creditRepository = creditRepository;
    }


    @Override
    public Long handle(CreateCreditCommand command) {
        var credit = new Credit(command.currency(), command.vehiclePrice(), command.feeNumber(),
                command.initialFeePercentage(), command.finalFeePercentage(), command.url(), command.gracePeriodType(), command.gracePeriodFeeNumber(),
                command.interestRateType(), command.interestRatePercentage(), command.notarialCost(), command.registerCost(),
                command.gps(), command.ports(), command.administrationBills(), command.lifeInsurancePercentage(),
                command.riskInsurancePercentage(), command.cok(), command.initialDate(), command.finalDate());
        creditRepository.save(credit);
        return credit.getId();
    }
}
