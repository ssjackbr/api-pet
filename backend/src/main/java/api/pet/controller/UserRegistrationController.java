package api.pet.controller;

import api.pet.domain.dto.UserDTO;
import api.pet.domain.dto.UserRegisteredDTO;
import api.pet.domain.entity.User;
import api.pet.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/user")
public class UserRegistrationController{

    private final UserService userService;

    @PostMapping(value = "/register")
    public UserRegisteredDTO testSaveUser(@RequestBody UserDTO userDTO){
        return userService.registrationConsumerUser(userDTO);
    }
}

