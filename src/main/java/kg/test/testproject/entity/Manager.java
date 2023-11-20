package kg.test.testproject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "managers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class  Manager {
    @Id
    @SequenceGenerator(name = "manager_gen", sequenceName = "manager_seq",
            allocationSize = 1, initialValue = 5)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "manager_gen")
    private Long id;
    private String fullName;
    private String phoneNumber;
    private LocalDate createdAt;
    @OneToOne(mappedBy = "manager",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private UserInfo userInfo;
    @OneToMany(mappedBy = "manager")
    private List<Apartment>apartments;
}
