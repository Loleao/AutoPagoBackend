package pe.com.AutoPago.Profile.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.com.AutoPago.Profile.domain.model.commands.CreateUserCommand;
import pe.com.AutoPago.Profile.domain.model.entities.User;
import pe.com.AutoPago.Profile.domain.services.UserCommandService;
import pe.com.AutoPago.Profile.infrastructure.persistence.jpa.repositories.UserRepository;

@Service
public class UserCommandServiceImpl implements UserCommandService {
    private final UserRepository userRepository;

    public UserCommandServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Long handle(CreateUserCommand command) {
        var user = new User(command.email(),command.password());
        userRepository.save(user);
        return user.getId();
    }
}
