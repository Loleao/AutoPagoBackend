package pe.com.AutoPago.Purchase.interfaces.rest.transform;

import pe.com.AutoPago.Purchase.domain.model.entities.Credit;
import pe.com.AutoPago.Purchase.interfaces.rest.resources.CreditResource;

public class CreditResourceFromEntityAssembler {
    public static CreditResource toResourceFromEntity(Credit entity) {
        return new CreditResource(entity.getId(), entity.getCurrency(), entity.getVehiclePrice(), entity.getFeeNumber(),
                entity.getInitialFeePercentage(), entity.getFinalFeePercentage(), entity.getUrl(), entity.getGracePeriodType(), entity.getGracePeriodFeeNumber(),
                entity.getInterestRateType(), entity.getInterestRatePercentage(), entity.getNotarialCost(), entity.getRegisterCost(),
                entity.getGps(), entity.getPorts(), entity.getAdministrationBills(), entity.getLifeInsurancePercentage(),
                entity.getRiskInsurancePercentage(), entity.getCok(), entity.getInitialDate(), entity.getFinalDate(), entity.getUserId());
    }
}
