package pe.com.AutoPago.Profile.domain.services;

import pe.com.AutoPago.Profile.domain.model.commands.CreateUserCommand;

public interface UserCommandService {
    Long handle(CreateUserCommand command);
}
