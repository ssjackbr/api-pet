package api.pet.controller;

import api.pet.domain.entity.Customer;
import api.pet.service.CustomerService;
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

    private final CustomerService customerService;

    @PostMapping(value = "/{number}")
    public Customer testSaveUser(@PathVariable Integer number){
        return customerService.save(number);
    }
}

