package kg.test.testproject.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import kg.test.testproject.dto.response.ApartmentLocationResponse;
import kg.test.testproject.entity.enums.Status;
import kg.test.testproject.repository.ApartmentLocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Enums API", description = "The Enums API")
@RequestMapping("/api/enums")
public class EnumsApi {
    private final ApartmentLocationRepository repository;
    @GetMapping("get_all_location")
    List<ApartmentLocationResponse>getAllLocation(){
        return repository.getAll();
    }
    @GetMapping("/get_all_status")
    Status[] getAllStatus(){
        return Status.values();
    }
}
