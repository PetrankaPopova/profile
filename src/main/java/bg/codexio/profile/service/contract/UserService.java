package bg.codexio.profile.service.contract;

import bg.codexio.profile.entity.User;
import bg.codexio.profile.payload.UserRequest;
import bg.codexio.profile.payload.UserResponse;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.util.List;

public interface UserService {
    User findById(Long id);
    UserResponse updateProfile(@AuthenticationPrincipal User user,UserRequest userRequest);
    UserResponse profile(@AuthenticationPrincipal User user);
    List<User> getAllUsers();
}
