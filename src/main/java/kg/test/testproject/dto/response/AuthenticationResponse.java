package kg.test.testproject.dto.response;

import kg.test.testproject.entity.enums.Role;
import lombok.Builder;

@Builder
public record AuthenticationResponse (
        String username,
        Role role,
        String token
) {
}
