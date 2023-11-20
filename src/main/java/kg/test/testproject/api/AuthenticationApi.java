package kg.test.testproject.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kg.test.testproject.dto.request.AuthenticateRequest;
import kg.test.testproject.dto.response.AuthenticationResponse;
import kg.test.testproject.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "Authentication || Аутентификация ", description = "The User Authentication API || Аутентификация пользователя API")
@RequestMapping("/api/auth")
public class AuthenticationApi {
    private final AuthenticationService service;
    @Operation(summary = "User Authentication || Аутентификация пользователя",
            description = "This endpoint authenticates the user || Этот метод аутентификации пользователя")
    @PostMapping("/sign_in")
    public AuthenticationResponse authenticate (@RequestBody AuthenticateRequest authenticateRequest){
        return service.authenticate(authenticateRequest);
    }
}
