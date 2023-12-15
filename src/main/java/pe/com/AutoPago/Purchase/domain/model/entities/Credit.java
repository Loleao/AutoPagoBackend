package pe.com.AutoPago.Purchase.domain.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;

@Entity
@Table(name="credits")
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    private String currency;

    @PositiveOrZero
    @Getter
    private Double vehiclePrice;

    @PositiveOrZero
    @Getter
    private Long feeNumber;

    @PositiveOrZero
    @Getter
    private Double initialFeePercentage;

    @PositiveOrZero
    @Getter
    private Double finalFeePercentage;

    @Getter
    private String url;

    @Getter
    private String gracePeriodType;

    @PositiveOrZero
    @Getter
    private Long gracePeriodFeeNumber;

    @Getter
    private String interestRateType;

    @PositiveOrZero
    @Getter
    private Double interestRatePercentage;

    @PositiveOrZero
    @Getter
    private Double notarialCost;

    @PositiveOrZero
    @Getter
    private Double registerCost;

    @PositiveOrZero
    @Getter
    private Double gps;

    @PositiveOrZero
    @Getter
    private Double ports;

    @PositiveOrZero
    @Getter
    private Double administrationBills;

    @PositiveOrZero
    @Getter
    private Double lifeInsurancePercentage;

    @PositiveOrZero
    @Getter
    private Double riskInsurancePercentage;

    @Getter
    private Double cok;

    @Getter
    private String initialDate;

    @Getter
    private String finalDate;

    public Credit() {
    }

    public Credit(String currency, Double vehiclePrice, Long feeNumber, Double initialFeePercentage, Double finalFeePercentage, String url, String gracePeriodType,
                  Long gracePeriodFeeNumber, String interestRateType, Double interestRatePercentage, Double notarialCost, Double registerCost,
                  Double gps, Double ports, Double administrationBills, Double lifeInsurancePercentage, Double riskInsurancePercentage,
                  Double cok, String initialDate, String finalDate) {
        this.currency = currency;
        this.vehiclePrice = vehiclePrice;
        this.feeNumber = feeNumber;
        this.initialFeePercentage = initialFeePercentage;
        this.finalFeePercentage = finalFeePercentage;
        this.url = url;
        this.gracePeriodType = gracePeriodType;
        this.gracePeriodFeeNumber = gracePeriodFeeNumber;
        this.interestRateType = interestRateType;
        this.interestRatePercentage = interestRatePercentage;
        this.notarialCost = notarialCost;
        this.registerCost = registerCost;
        this.gps = gps;
        this.ports = ports;
        this.administrationBills = administrationBills;
        this.lifeInsurancePercentage = lifeInsurancePercentage;
        this.riskInsurancePercentage = riskInsurancePercentage;
        this.cok = cok;
        this.initialDate = initialDate;
        this.finalDate = finalDate;
    }
}
