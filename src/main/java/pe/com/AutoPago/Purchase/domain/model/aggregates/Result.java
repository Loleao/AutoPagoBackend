package pe.com.AutoPago.Purchase.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import pe.com.AutoPago.Purchase.domain.model.entities.Credit;

@Entity
@Table(name="results")
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    private Long n;

    @Getter
    private String graceType;

    @Getter
    private Double cok;

    @Getter
    private Double balanceFinalFee;

    @Getter
    private Double interestFinalFee;

    @Getter
    private Double amortizationFinalFee;

    @Getter
    private Double lifeInsuranceFinalFee;

    @Getter
    private Double finalBalanceFinalFee;

    @Getter
    private Double interest;

    @Getter
    private Double lifeInsurance;

    @Getter
    private Double fee;

    @Getter
    private Double amortization;

    @Getter
    private Double balance;

    @Getter
    private Double finalBalance;

    @Getter
    private Double flow;

    @Getter
    private Double riskInsurance;

    @Getter
    private Double gps;

    @Getter
    private Double ports;

    @Getter
    private Double adminBills;

    @Getter
    @ManyToOne
    @JoinColumn(name = "credit_id", nullable = false)
    private Credit credit;

    public Result() {
    }

    public Result(Long n, String graceType, Double cok, Double balanceFinalFee, Double interestFinalFee, Double amortizationFinalFee,
                  Double lifeInsuranceFinalFee, Double finalBalanceFinalFee, Double interest, Double lifeInsurance, Double fee,
                  Double amortization, Double balance, Double finalBalance, Double flow, Double riskInsurance,
                  Double gps, Double ports, Double adminBills, Credit credit) {
        this.n = n;
        this.graceType = graceType;
        this.cok = cok;
        this.balanceFinalFee = balanceFinalFee;
        this.interestFinalFee = interestFinalFee;
        this.amortizationFinalFee = amortizationFinalFee;
        this.lifeInsuranceFinalFee = lifeInsuranceFinalFee;
        this.finalBalanceFinalFee = finalBalanceFinalFee;
        this.interest = interest;
        this.lifeInsurance = lifeInsurance;
        this.fee = fee;
        this.amortization = amortization;
        this.balance = balance;
        this.finalBalance = finalBalance;
        this.flow = flow;
        this.riskInsurance = riskInsurance;
        this.gps = gps;
        this.ports = ports;
        this.adminBills = adminBills;
        this.credit = credit;
    }
}
