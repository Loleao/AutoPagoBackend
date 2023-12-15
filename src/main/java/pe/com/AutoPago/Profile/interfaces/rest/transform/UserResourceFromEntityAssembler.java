package pe.com.AutoPago.Profile.interfaces.rest.transform;

import pe.com.AutoPago.Profile.domain.model.entities.User;
import pe.com.AutoPago.Profile.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User entity) {
        return new UserResource(entity.getId(), entity.getEmail(), entity.getPassword());
    }
}
