package pe.com.AutoPago.Purchase.interfaces.rest.transform;

import pe.com.AutoPago.Purchase.domain.model.commands.CreateResultCommand;
import pe.com.AutoPago.Purchase.interfaces.rest.resources.CreateResultResource;

public class CreateResultCommandFromResourceAssembler {
    public static CreateResultCommand toCommandFromResource(CreateResultResource resource){
        return new CreateResultCommand(resource.n(), resource.graceType(), resource.cok(), resource.balanceFinalFee(), resource.interestFinalFee(),
                resource.amortizationFinalFee(), resource.lifeInsuranceFinalFee(), resource.finalBalanceFinalFee(),
                resource.interest(), resource.lifeInsurance(), resource.fee(), resource.amortization(),
                resource.balance(), resource.finalBalance(), resource.flow(), resource.riskInsurance(), resource.gps(),
                resource.ports(), resource.adminBills(), resource.creditId());
    }
}
