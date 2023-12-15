package pe.com.AutoPago.Profile.application.internal.queryservices;

import org.springframework.stereotype.Service;
import pe.com.AutoPago.Profile.domain.model.entities.User;
import pe.com.AutoPago.Profile.domain.model.queries.GetUserByEmailQuery;
import pe.com.AutoPago.Profile.domain.model.queries.GetUserByIdQuery;
import pe.com.AutoPago.Profile.domain.services.UserQueryService;
import pe.com.AutoPago.Profile.infrastructure.persistence.jpa.repositories.UserRepository;

import java.util.Optional;

@Service
public class UserQueryServiceImpl implements UserQueryService {
    private final UserRepository userRepository;

    public UserQueryServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> handle(GetUserByEmailQuery query) {
        return userRepository.findUserByEmail(query.email());
    }

    @Override
    public Optional<User> handle(GetUserByIdQuery query) {
        return userRepository.findById(query.id());
    }
}
