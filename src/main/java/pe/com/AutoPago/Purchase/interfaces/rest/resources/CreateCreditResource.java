package pe.com.AutoPago.Purchase.interfaces.rest.resources;

public record CreateCreditResource(String currency, Double vehiclePrice, Long feeNumber, Double initialFeePercentage, Double finalFeePercentage, String url,
                                   String gracePeriodType, Long gracePeriodFeeNumber, String interestRateType, Double interestRatePercentage,
                                   Double notarialCost, Double registerCost, Double gps, Double ports, Double administrationBills,
                                   Double lifeInsurancePercentage, Double riskInsurancePercentage, Double cok, String initialDate, String finalDate, Long userId) {
}
