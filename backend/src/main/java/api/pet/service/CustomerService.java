package api.pet.service;

import api.pet.domain.entity.Address;
import api.pet.domain.entity.Customer;
import api.pet.domain.entity.Role;
import api.pet.domain.enums.Roles;
import api.pet.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Log4j2
@RequiredArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Transactional
    public Customer save(Integer number) {

        Set<Role> roles = new HashSet<>();
        roles.add(Role.builder()
                .role(Roles.ADMIN.toString())
                .build());

        log.info("Created Roles");

        Set<Address> addressSet = new HashSet<>();
        addressSet.add(Address.builder()
                .addressName("Minha Casa")
                .street("Rua Luiz Bondezan")
                .number("118")
                .complement("APTO202")
                .districtArea("Floramar")
                .city("Belo Horizonte")
                .state("Minas Gerais")
                .country("BRA")
                .CEP("31742017")
                .referencePoint("Prédio de esquina")
                .build());

        addressSet.add(Address.builder()
                .addressName("Trabalho")
                .street("Assis Chateubriant")
                .number("499")
                .complement("Empresa")
                .districtArea("Floresta")
                .city("Belo Horizonte")
                .state("Minas Gerais")
                .country("BRA")
                .CEP("31999123")
                .referencePoint("Antiga TV Alterosa")
                .build());

        log.info("Created Address");

        Customer newCustomer = Customer.builder()
                .firstName("Jackson")
                .lastName("R")
                .cpf("01607775697")
                .email("jjr0910@gmail.com")
                .mobilePhone("31996665838")
                .iconUrl("https://iconimage.com")
                .pictureUrl("https://photopefil.com")
                .adresses(addressSet)
                .role(roles)
                .password("123")
                .type("Customer")
                .historyOrders("history")
                .enable(true)
                .build();
        if (number == 1) {
            customerRepository.save(newCustomer);
        }
        log.info("Created User");
        return newCustomer;

    }
}
