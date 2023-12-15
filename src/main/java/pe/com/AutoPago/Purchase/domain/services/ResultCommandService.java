package pe.com.AutoPago.Purchase.domain.services;

import pe.com.AutoPago.Purchase.domain.model.commands.CreateResultCommand;

public interface ResultCommandService {
    Long handle(CreateResultCommand command);
}
