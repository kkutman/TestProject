package kg.test.testproject.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ManagerResponse {
    private String fullName;
    private String phoneNumber;
    private String username;
    private LocalDate createdAt;
    private Long apartmentCount;
}

