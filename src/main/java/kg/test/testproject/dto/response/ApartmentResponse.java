package kg.test.testproject.dto.response;

import kg.test.testproject.entity.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApartmentResponse {
    private Long id;
    private String locationName;
    private int floor;
    private int apartmentNumber;
    private LocalDate date;
    private Status status;
    private BigDecimal price;
    private String clientName;
    private String apartmentStatus;
}
