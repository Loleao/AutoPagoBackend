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
    private Long vehiclePrice;

    @PositiveOrZero
    @Getter
    private Long feeNumber;

    @PositiveOrZero
    @Getter
    private Long initialFeePercentage;

    @PositiveOrZero
    @Getter
    private Long finalFeePercentage;

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
    private Long interestRatePercentage;

    @PositiveOrZero
    @Getter
    private Long notarialCost;

    @PositiveOrZero
    @Getter
    private Long registerCost;

    @PositiveOrZero
    @Getter
    private Long gps;

    @PositiveOrZero
    @Getter
    private Long ports;

    @PositiveOrZero
    @Getter
    private Long administrationBills;

    @PositiveOrZero
    @Getter
    private Long lifeInsurancePercentage;

    @PositiveOrZero
    @Getter
    private Long riskInsurancePercentage;

    @Getter
    private Long cok;

    @Getter
    private String initialDate;

    @Getter
    private String finalDate;

    public Credit() {
    }

    public Credit(String currency, Long vehiclePrice, Long feeNumber, Long initialFeePercentage, Long finalFeePercentage, String url, String gracePeriodType,
                  Long gracePeriodFeeNumber, String interestRateType, Long interestRatePercentage, Long notarialCost, Long registerCost,
                  Long gps, Long ports, Long administrationBills, Long lifeInsurancePercentage, Long riskInsurancePercentage,
                  Long cok, String initialDate, String finalDate) {
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
