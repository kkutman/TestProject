package kg.test.testproject.repository;

import kg.test.testproject.dto.response.ApartmentLocationResponse;
import kg.test.testproject.entity.ApartmentLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApartmentLocationRepository extends JpaRepository<ApartmentLocation,Long> {

@Query("SELECT new kg.test.testproject.dto.response.ApartmentLocationResponse(a.id,a.name) FROM ApartmentLocation a")
    List<ApartmentLocationResponse>getAll();
}
