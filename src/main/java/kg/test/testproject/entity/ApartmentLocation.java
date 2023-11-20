package kg.test.testproject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "apartment_location")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApartmentLocation {
    @Id
    @SequenceGenerator(name = "apartment_location_gen", sequenceName = "apartment_location_seq",
            allocationSize = 1, initialValue = 5)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "apartment_location_gen")
    private Long id;
    private String name;
    @OneToMany(mappedBy = "apartmentLocation")
    private List<Apartment> apartments;
}
