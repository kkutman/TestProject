package kg.test.testproject.service.impl;

import kg.test.testproject.dto.request.ManagerRequest;
import kg.test.testproject.dto.request.ManagerUpdateRequest;
import kg.test.testproject.dto.response.ManagerResponse;
import kg.test.testproject.dto.response.SimpleResponse;
import kg.test.testproject.entity.Manager;
import kg.test.testproject.entity.UserInfo;
import kg.test.testproject.entity.enums.Role;
import kg.test.testproject.exception.exceptions.AlreadyExistException;
import kg.test.testproject.exception.exceptions.BadRequestException;
import kg.test.testproject.exception.exceptions.NotFoundException;
import kg.test.testproject.repository.ManagerRepository;
import kg.test.testproject.repository.UserInfoRepository;
import kg.test.testproject.service.ManagerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ManagerServiceImpl implements ManagerService {

    private final ManagerRepository managerRepository;
    private final UserInfoRepository userInfoRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public SimpleResponse saveManager(ManagerRequest request) {
        if (userInfoRepository.existsByUsername(request.email())) {
            log.error("Manager with email {} already exists", request.email());
            throw new AlreadyExistException(String.format("Manager with email %s already exists", request.email()));
        }

        String emailPrefix = request.email().split("@")[0];
        if (emailPrefix.equals(request.password())) {
            throw new BadRequestException("Create a more secure password");
        }

        Manager manager = Manager.builder()
                .fullName(request.fullName())
                .phoneNumber(request.phoneNumber())
                .createdAt(LocalDate.now())
                .build();

        UserInfo userInfo = UserInfo.builder()
                .manager(manager)
                .username(request.email())
                .password(passwordEncoder.encode(request.password()))
                .role(Role.MANAGER)
                .build();

        manager.setUserInfo(userInfo);
        managerRepository.save(manager);

        return SimpleResponse.builder().httpStatus(HttpStatus.OK).message("Manager added successfully").build();
    }

    @Override
    public SimpleResponse deleteManager(Long id) {
        Manager manager = managerRepository.findById(id).orElseThrow(() -> new NotFoundException("Manager not found"));
        managerRepository.delete(manager);
        return SimpleResponse.builder().message("Manager deleted successfully").httpStatus(HttpStatus.OK).build();
    }

    @Override
    public SimpleResponse updateManager(ManagerUpdateRequest request, Long id) {
        Manager manager = managerRepository.findById(id).orElseThrow(() -> new NotFoundException("Manager not found"));

        manager.setFullName(request.fullName());
        manager.setPhoneNumber(request.phoneNumber());
        manager.getUserInfo().setUsername(request.email());

        managerRepository.save(manager);

        return SimpleResponse.builder().httpStatus(HttpStatus.OK).message("Manager updated successfully").build();
    }

    @Override
    public List<ManagerResponse> getAllManager() {
        return managerRepository.getAllManager();
    }
}
