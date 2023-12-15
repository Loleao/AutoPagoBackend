package pe.com.AutoPago.Purchase.interfaces.rest.transform;

import pe.com.AutoPago.Purchase.domain.model.commands.CreateCreditCommand;
import pe.com.AutoPago.Purchase.interfaces.rest.resources.CreateCreditResource;

public class CreateCreditCommandFromResourceAssembler {
    public static CreateCreditCommand toCommandFromResource(CreateCreditResource resource){
        return new CreateCreditCommand(resource.currency(), resource.vehiclePrice(), resource.feeNumber(),
                resource.initialFeePercentage(), resource.finalFeePercentage(), resource.url(), resource.gracePeriodType(), resource.gracePeriodFeeNumber(),
                resource.interestRateType(), resource.interestRatePercentage(), resource.notarialCost(), resource.registerCost(),
                resource.gps(), resource.ports(), resource.administrationBills(), resource.lifeInsurancePercentage(),
                resource.riskInsurancePercentage(), resource.cok(), resource.initialDate(), resource.finalDate());
    }
}
