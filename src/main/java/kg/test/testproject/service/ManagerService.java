package kg.test.testproject.service;

import kg.test.testproject.dto.request.ManagerRequest;
import kg.test.testproject.dto.request.ManagerUpdateRequest;
import kg.test.testproject.dto.response.ManagerResponse;
import kg.test.testproject.dto.response.SimpleResponse;

import java.util.List;

public interface ManagerService {
    SimpleResponse saveManager(ManagerRequest request);
    SimpleResponse deleteManager(Long id);
    SimpleResponse updateManager(ManagerUpdateRequest request,Long id);
    List<ManagerResponse>getAllManager();
}
