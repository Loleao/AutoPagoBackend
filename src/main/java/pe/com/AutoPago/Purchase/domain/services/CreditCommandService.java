package pe.com.AutoPago.Purchase.domain.services;

import pe.com.AutoPago.Purchase.domain.model.commands.CreateCreditCommand;

public interface CreditCommandService {
    Long handle(CreateCreditCommand command);
}
