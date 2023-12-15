package pe.com.AutoPago.Purchase.interfaces.rest.transform;

import pe.com.AutoPago.Purchase.domain.model.aggregates.Result;
import pe.com.AutoPago.Purchase.interfaces.rest.resources.ResultResource;

public class ResultResourceFromEntityAssembler {
    public static ResultResource toResourceFromEntity(Result entity) {
        return new ResultResource(entity.getId(), entity.getN(), entity.getGraceType(), entity.getCok(), entity.getBalanceFinalFee(),
                entity.getInterestFinalFee(), entity.getAmortizationFinalFee(), entity.getLifeInsuranceFinalFee(), entity.getFinalBalanceFinalFee(),
                entity.getInterest(), entity.getLifeInsurance(), entity.getFee(), entity.getAmortization(),
                entity.getBalance(), entity.getFinalBalance(), entity.getFlow(), entity.getRiskInsurance(), entity.getGps(),
                entity.getPorts(), entity.getAdminBills(), entity.getCredit().getId());
    }
}
