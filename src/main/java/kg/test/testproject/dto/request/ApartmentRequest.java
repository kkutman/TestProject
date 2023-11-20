package kg.test.testproject.dto.request;

import kg.test.testproject.entity.enums.Status;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ApartmentRequest(
        String fullName,
        Long locationId,
        int floor,
        int apartmentNumber,
        Status status,
        BigDecimal price,
        String apartmentStatus,
        int contractNumber
) {
}
