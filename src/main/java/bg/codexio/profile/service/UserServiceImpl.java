package bg.codexio.profile.service;

import bg.codexio.profile.entity.User;
import bg.codexio.profile.payload.UserRequest;
import bg.codexio.profile.payload.UserResponse;
import bg.codexio.profile.repository.UserRepository;
import bg.codexio.profile.service.contract.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id){
        return this.userRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("User does not exist"));
    }

    @Override
    public UserResponse updateProfile(@AuthenticationPrincipal User user,UserRequest userRequest){
        UserResponse userResponse = new UserResponse();

        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setBornOn(userRequest.getBornOn());
        //MAY NEED USER SAVE
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setBornOn(user.getBornOn());

        return userResponse;
    }

    @Override
    public UserResponse profile(@AuthenticationPrincipal User user){
        return new UserResponse(user.getId());
    }

    @Override
    public List<User> getAllUsers(){
       return this.userRepository.findAll();
    }
}
