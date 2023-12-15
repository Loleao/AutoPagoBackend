package pe.com.AutoPago.Profile.interfaces.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.AutoPago.Profile.domain.model.queries.GetUserByEmailQuery;
import pe.com.AutoPago.Profile.domain.model.queries.GetUserByIdQuery;
import pe.com.AutoPago.Profile.domain.services.UserCommandService;
import pe.com.AutoPago.Profile.domain.services.UserQueryService;
import pe.com.AutoPago.Profile.interfaces.rest.resources.CreateUserResource;
import pe.com.AutoPago.Profile.interfaces.rest.resources.UserResource;
import pe.com.AutoPago.Profile.interfaces.rest.transform.CreateUserCommandFromResourceAssembler;
import pe.com.AutoPago.Profile.interfaces.rest.transform.UserResourceFromEntityAssembler;

@RestController
@RequestMapping(value = "/api/v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Users", description = "Users Management Endpoints")
public class UserController {
    private final UserQueryService userQueryService;
    private final UserCommandService userCommandService;

    public UserController(UserQueryService userQueryService, UserCommandService userCommandService) {
        this.userQueryService = userQueryService;
        this.userCommandService = userCommandService;
    }

    @PostMapping
    public ResponseEntity<UserResource> createUser(@RequestBody CreateUserResource resource){
        var createUserCommand = CreateUserCommandFromResourceAssembler.toCommandFromResource(resource);

        var userId = userCommandService.handle(createUserCommand);

        if(userId == 0L) {
            return ResponseEntity.badRequest().build();
        }

        var getUserIdByQuery = new GetUserByIdQuery(userId);
        var user = userQueryService.handle(getUserIdByQuery);

        if(user.isEmpty()){
            return ResponseEntity.badRequest().build();
        }

        var userResource = UserResourceFromEntityAssembler.toResourceFromEntity(user.get());
        return new ResponseEntity<>(userResource, HttpStatus.CREATED);
    }

    @GetMapping("/{email}")
    public ResponseEntity<UserResource> getUserByEmail(@PathVariable String email) {
        var getUserByEmailQuery = new GetUserByEmailQuery(email);
        var user = userQueryService.handle(getUserByEmailQuery);
        if(user.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        var userResource = UserResourceFromEntityAssembler.toResourceFromEntity(user.get());
        return ResponseEntity.ok(userResource);
    }
}
