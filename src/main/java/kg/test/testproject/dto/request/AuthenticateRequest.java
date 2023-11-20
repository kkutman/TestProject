package kg.test.testproject.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record AuthenticateRequest(
        @NotBlank(message = "Имя пользователя не должна быть пустой!")
        String username,
        @NotBlank(message = "Пароль не должен быть пустым!")
        String password
) {
}
