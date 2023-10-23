package api.pet.controller;

import api.pet.domain.dto.UserDTO;
import api.pet.domain.dto.UserRegisteredDTO;
import api.pet.domain.dto.UserUpdateDTO;
import api.pet.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/user")
public class UserRegistrationController{

    private final UserService userService;

    @PostMapping(value = "/register")
    public UserRegisteredDTO registrationUser(@RequestBody UserDTO userDTO){
        return userService.registrationUser(userDTO);
    }

    @GetMapping()
    public UserRegisteredDTO getUserByEmail(@RequestParam String email){
        return userService.findUserByEmail(email);
    }

    @PutMapping("/update")
    public UserRegisteredDTO updateUserByEmail (@RequestBody UserUpdateDTO userUpdateDTO){
        return userService.updateUser(userUpdateDTO);
    }

}

