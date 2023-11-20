package kg.test.testproject.dto.request;

import lombok.Builder;
import lombok.Getter;

@Builder
public record ManagerRequest(
        String fullName,
        String phoneNumber,
        String email,
        String password
) {
}
