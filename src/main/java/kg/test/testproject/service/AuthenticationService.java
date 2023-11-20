package kg.test.testproject.service;

import kg.test.testproject.dto.request.AuthenticateRequest;
import kg.test.testproject.dto.response.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse authenticate(AuthenticateRequest request);

}
