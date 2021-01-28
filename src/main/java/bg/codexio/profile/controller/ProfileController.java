package bg.codexio.profile.controller;

import bg.codexio.profile.entity.User;
import bg.codexio.profile.payload.UserRequest;
import bg.codexio.profile.payload.UserResponse;
import bg.codexio.profile.service.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProfileController {

    private final UserServiceImpl userService;

    public ProfileController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/users/me")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public UserResponse profile(@AuthenticationPrincipal User user){
       return this.userService.profile(user);
    }

    @GetMapping("/users/all")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<User> getAllUsers(){
      return this.userService.getAllUsers();
    }

    @PatchMapping("/users/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public UserResponse updateProfile(@AuthenticationPrincipal User user , UserRequest userRequest){
        return this.userService.updateProfile(user,userRequest);
    }
}
