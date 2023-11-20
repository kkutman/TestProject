package kg.test.testproject.dto.request;

import lombok.Builder;

@Builder
public record ManagerUpdateRequest(
        String fullName,
        String phoneNumber,
        String email
) {
}
