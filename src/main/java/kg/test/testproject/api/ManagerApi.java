package kg.test.testproject.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kg.test.testproject.dto.request.ManagerRequest;
import kg.test.testproject.dto.request.ManagerUpdateRequest;
import kg.test.testproject.dto.response.ManagerResponse;
import kg.test.testproject.dto.response.SimpleResponse;
import kg.test.testproject.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Manager API", description = "The Manager API || Менеджер API")
@RequestMapping("/api/manager")
public class ManagerApi {
    private final ManagerService managerService;

    @Operation(summary = "Save Manager || Сохранение менеджера",
            description = "This endpoint saves a new manager || Этот метод сохраняет нового менеджера")
    @PostMapping("/save")
    SimpleResponse saveManager(ManagerRequest request) {
        return managerService.saveManager(request);
    }

    @Operation(summary = "Delete Manager || Удаление менеджера",
            description = "This endpoint deletes a manager by ID || Этот метод удаляет менеджера по идентификатору")
    @DeleteMapping("/delete")
    SimpleResponse deleteManager(Long id) {
        return managerService.deleteManager(id);
    }

    @Operation(summary = "Update Manager || Обновление менеджера",
            description = "This endpoint updates a manager by ID || Этот метод обновляет менеджера по идентификатору")
    @PutMapping("/update")
    SimpleResponse updateManager(ManagerUpdateRequest request, Long id) {
        return managerService.updateManager(request, id);
    }

    @Operation(summary = "Get All Managers || Получение всех менеджеров",
            description = "This endpoint retrieves a list of all managers || Этот метод возвращает список всех менеджеров")
    @GetMapping("/get")
    List<ManagerResponse> getAllManager() {
        return managerService.getAllManager();
    }


}
