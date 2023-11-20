package kg.test.testproject.service.impl;

import kg.test.testproject.config.jwt.JwtService;
import kg.test.testproject.dto.request.AuthenticateRequest;
import kg.test.testproject.dto.response.AuthenticationResponse;
import kg.test.testproject.entity.UserInfo;
import kg.test.testproject.exception.exceptions.BadCredentialException;
import kg.test.testproject.exception.exceptions.BadRequestException;
import kg.test.testproject.repository.UserInfoRepository;
import kg.test.testproject.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserInfoRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public AuthenticationResponse authenticate(AuthenticateRequest request) {
        UserInfo user = userRepository.findByUsername(request.username())
                .orElseThrow(() -> {
                    log.error("User with username {} not found", request.username());
                    return new BadCredentialException("User not found");
                });

        if (!passwordEncoder.matches(request.password(), user.getPassword())) {
            log.error("Invalid password for user {}", user.getUsername());
            throw new BadRequestException("Invalid password");
        }

        authenticateUser(request.username(), request.password());

        log.info("User {} successfully authenticated", user.getUsername());
        String token = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .username(user.getUsername())
                .role(user.getRole())
                .token(token)
                .build();
    }

    private void authenticateUser(String username, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
