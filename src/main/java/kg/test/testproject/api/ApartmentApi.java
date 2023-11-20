package kg.test.testproject.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kg.test.testproject.dto.request.ApartmentRequest;
import kg.test.testproject.dto.request.ApartmentUpdatedRequest;
import kg.test.testproject.dto.response.ApartmentResponse;
import kg.test.testproject.dto.response.SimpleResponse;
import kg.test.testproject.entity.enums.Status;
import kg.test.testproject.service.ApartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Apartment API", description = "The Apartment API || Апартаменты API")
@RequestMapping("/api/apartment")
public class ApartmentApi {
    private final ApartmentService apartmentService;

    @Operation(summary = "Save Apartment || Сохранение апартамента",
            description = "This endpoint saves a new apartment || Этот метод сохраняет новый апартамент")
    @PostMapping("/save")
    public SimpleResponse saveApartment(ApartmentRequest request) {
        return apartmentService.saveApartment(request);
    }

    @Operation(summary = "Update Apartment || Обновление апартамента",
            description = "This endpoint updates an existing apartment || Этот метод обновляет существующий апартамент")
    @PutMapping("/updated")
    public SimpleResponse updateApartment(ApartmentUpdatedRequest request, Long id) {
        return apartmentService.updateApartment(request, id);
    }

    @Operation(summary = "Delete Apartment || Удаление апартамента",
            description = "This endpoint deletes an apartment by ID || Этот метод удаляет апартамент по идентификатору")
    @DeleteMapping("/deleted")
    public SimpleResponse deleteApartment(Long id) {
        return apartmentService.deleteApartment(id);
    }

    @Operation(summary = "Get All Apartments || Получение всех апартаментов",
            description = "This endpoint retrieves a list of all apartments || Этот метод возвращает список всех апартаментов")
    @GetMapping("get_all")
    public List<ApartmentResponse> getAllApartment(@RequestParam(required = false) Status status, @RequestParam(required = false) Long locationId) {
        return apartmentService.getAllApartment(status, locationId);
    }
}
