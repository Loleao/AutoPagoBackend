package pe.com.AutoPago.Profile.domain.services;

import pe.com.AutoPago.Profile.domain.model.entities.User;
import pe.com.AutoPago.Profile.domain.model.queries.GetUserByEmailQuery;
import pe.com.AutoPago.Profile.domain.model.queries.GetUserByIdQuery;

import java.util.Optional;

public interface UserQueryService {
    Optional<User> handle(GetUserByIdQuery query);
    Optional<User> handle(GetUserByEmailQuery query);
}
