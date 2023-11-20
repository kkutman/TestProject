package kg.test.testproject.entity;

import jakarta.persistence.*;
import kg.test.testproject.entity.enums.Status;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "apartments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Apartment {
    @Id
    @SequenceGenerator(name = "apartment_gen", sequenceName = "apartment_seq",
            allocationSize = 1, initialValue = 5)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "apartment_gen")
    private Long id;
    private int floor;
    private int apartmentNumber;
    private LocalDate date;
    @Enumerated(EnumType.STRING)
    private Status status;
    private BigDecimal price;
    private String clientFullName;
    private String statusApartment;
    private int contractNumber;
    @ManyToOne
    private Manager manager;
    @ManyToOne
    private ApartmentLocation apartmentLocation;
}
