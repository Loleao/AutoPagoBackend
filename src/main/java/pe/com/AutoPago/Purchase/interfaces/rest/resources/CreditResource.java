package pe.com.AutoPago.Purchase.interfaces.rest.resources;

public record CreditResource(Long id, String currency, Long vehiclePrice, Long feeNumber, Long initialFeePercentage, Long finalFeePercentage,
                             String url, String gracePeriodType, Long gracePeriodFeeNumber, String interestRateType, Long interestRatePercentage,
                             Long notarialCost, Long registerCost, Long gps, Long ports, Long administrationBills, Long lifeInsurancePercentage,
                             Long riskInsurancePercentage, Long cok, String initialDate, String finalDate) {
}
