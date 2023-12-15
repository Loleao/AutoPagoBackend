package pe.com.AutoPago.Profile.interfaces.rest.transform;

import pe.com.AutoPago.Profile.domain.model.commands.CreateUserCommand;
import pe.com.AutoPago.Profile.interfaces.rest.resources.CreateUserResource;

public class CreateUserCommandFromResourceAssembler {
    public static CreateUserCommand toCommandFromResource(CreateUserResource resource){
        return new CreateUserCommand(resource.email(), resource.password());
    }
}
