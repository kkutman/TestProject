package kg.test.testproject.service;

import kg.test.testproject.dto.request.*;
import kg.test.testproject.dto.response.ApartmentResponse;
import kg.test.testproject.dto.response.SimpleResponse;
import kg.test.testproject.entity.enums.Status;

import java.util.List;

public interface ApartmentService {
    SimpleResponse saveApartment(ApartmentRequest request);
    SimpleResponse updateApartment(ApartmentUpdatedRequest request,Long id);
    SimpleResponse deleteApartment(Long id);
    List<ApartmentResponse> getAllApartment(Status status,Long locationId);

}
