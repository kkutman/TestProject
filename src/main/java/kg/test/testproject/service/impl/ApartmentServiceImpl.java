package kg.test.testproject.service.impl;

import kg.test.testproject.dto.request.ApartmentRequest;
import kg.test.testproject.dto.request.ApartmentUpdatedRequest;
import kg.test.testproject.dto.response.ApartmentResponse;
import kg.test.testproject.dto.response.SimpleResponse;
import kg.test.testproject.entity.Apartment;
import kg.test.testproject.entity.ApartmentLocation;
import kg.test.testproject.entity.enums.Status;
import kg.test.testproject.exception.exceptions.NotFoundException;
import kg.test.testproject.repository.ApartmentLocationRepository;
import kg.test.testproject.repository.ApartmentRepository;
import kg.test.testproject.repository.sql.ApartmentSql;
import kg.test.testproject.service.ApartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ApartmentServiceImpl implements ApartmentService {
    private final ApartmentRepository apartmentRepository;
    private final ApartmentLocationRepository apartmentLocationRepository;
    private final JdbcTemplate jdbcTemplate;

    @Override
    public SimpleResponse saveApartment(ApartmentRequest request) {
        try {
            ApartmentLocation location = apartmentLocationRepository.findById(request.locationId())
                    .orElseThrow(() -> new NotFoundException("Location not found with id: " + request.locationId()));

            Apartment apartment = Apartment.builder()
                    .apartmentLocation(location)
                    .clientFullName(request.fullName())
                    .date(LocalDate.now())
                    .floor(request.floor())
                    .apartmentNumber(request.apartmentNumber())
                    .status(request.status())
                    .price(request.price())
                    .statusApartment(request.apartmentStatus())
                    .contractNumber(request.contractNumber())
                    .build();

            apartmentRepository.save(apartment);

            return SimpleResponse.builder().message("Apartment saved successfully with id: " + apartment.getId())
                    .httpStatus(HttpStatus.OK).build();
        } catch (NotFoundException e) {
            log.error(e.getMessage());
            return SimpleResponse.builder().message(e.getMessage()).httpStatus(HttpStatus.NOT_FOUND).build();
        }
    }

    @Override
    public SimpleResponse updateApartment(ApartmentUpdatedRequest request, Long id) {
        try {
            Apartment apartment = apartmentRepository.findById(id)
                    .orElseThrow(() -> new NotFoundException("Apartment not found with id: " + id));

            apartment.setClientFullName(request.fullName());
            apartment.setContractNumber(request.contractNumber());
            apartment.setStatus(request.status());
            apartment.setContractNumber(request.contractNumber());
            apartmentRepository.save(apartment);

            return SimpleResponse.builder().httpStatus(HttpStatus.OK).message("Apartment updated successfully").build();
        } catch (NotFoundException e) {
            log.error(e.getMessage());
            return SimpleResponse.builder().message(e.getMessage()).httpStatus(HttpStatus.NOT_FOUND).build();
        }
    }

    @Override
    public SimpleResponse deleteApartment(Long id) {
        try {
            Apartment apartment = apartmentRepository.findById(id)
                    .orElseThrow(() -> new NotFoundException("Apartment not found with id: " + id));

            apartmentRepository.delete(apartment);
            return SimpleResponse.builder().message("Apartment deleted successfully").httpStatus(HttpStatus.OK).build();
        } catch (NotFoundException e) {
            log.error(e.getMessage());
            return SimpleResponse.builder().message(e.getMessage()).httpStatus(HttpStatus.NOT_FOUND).build();
        }
    }

    @Override
    public List<ApartmentResponse> getAllApartment(Status status, Long locationId) {
        return ApartmentSql.getAllApartment(status, locationId, jdbcTemplate);
    }
}
