package api.pet.controller;

import api.pet.domain.dto.UserDTO;
import api.pet.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.Serial;
import java.io.Serializable;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/customers")
public class CustomerController implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private final UserService customerService;

    @PostMapping(value = "/{number}")
    public UserDTO testSaveUser(@PathVariable Integer number){
        return customerService.save(number);
    }
}

