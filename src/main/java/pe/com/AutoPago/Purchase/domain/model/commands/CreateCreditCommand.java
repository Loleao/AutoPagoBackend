package pe.com.AutoPago.Purchase.domain.model.commands;

public record CreateCreditCommand(String currency, Double vehiclePrice, Long feeNumber, Double initialFeePercentage, Double finalFeePercentage,
                                  String url, String gracePeriodType, Long gracePeriodFeeNumber, String interestRateType,
                                  Double interestRatePercentage, Double notarialCost, Double registerCost, Double gps, Double ports,
                                  Double administrationBills, Double lifeInsurancePercentage, Double riskInsurancePercentage, Double cok,
                                  String initialDate, String finalDate, Long userId) {
}
