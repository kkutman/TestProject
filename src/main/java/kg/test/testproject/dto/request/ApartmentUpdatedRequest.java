package kg.test.testproject.dto.request;

import kg.test.testproject.entity.enums.Status;
import lombok.Builder;

@Builder
public record ApartmentUpdatedRequest(
        String fullName,
        String phoneNumber,
        int contractNumber,
        Status status

) {
}
