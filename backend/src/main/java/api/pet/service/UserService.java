package api.pet.service;

import api.pet.domain.dto.UserDTO;
import api.pet.domain.entity.Address;
import api.pet.domain.entity.Customer;
import api.pet.domain.entity.Partner;
import api.pet.domain.entity.Role;
import api.pet.domain.enums.Roles;
import api.pet.repository.CustomerRepository;
import api.pet.repository.PartnerRepository;
import api.pet.util.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Log4j2
@RequiredArgsConstructor
@Service
public class UserService {

    private final CustomerRepository customerRepository;
    private final PartnerRepository partnerRepository;
    private final UserMapper userMapper;

    @Transactional
    public UserDTO save(Integer number) {

        Set<Role> roles = new HashSet<>();
        roles.add(Role.builder()
                .role(Roles.ADMIN.toString())
                .build());

        roles.add(Role.builder()
                .role(Roles.PARTNER.toString())
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
                .roles(roles)
                .password("123")
                .historyOrders("history")
                .enable(true)
                .createAt(Instant.now())
                .build();

        Partner newPartner = Partner.builder()
                .firstName("Rodrigues")
                .lastName("Jackson")
                .cnpj("01607775697-0001")
                .email("caramelow@gmail.com")
                .mobilePhone("31996665838")
                .iconUrl("https://iconimage.com")
                .pictureUrl("https://photopefil.com")
                .adresses(addressSet)
                .roles(roles)
                .password("123")
                .enable(true)
                .fantasyName("CaramelowPet")
                .socialReason("Caramelow S/A")
                .stateRegistration("123.123.312.123.09999")
                .createAt(Instant.now())
                .build();

        if (number == 1) {
            customerRepository.save(newCustomer);
            partnerRepository.save(newPartner);
            log.info("Created User");
            return userMapper.convertEntityCustomerToDTO(newCustomer,
                    newCustomer.getAdresses(), newCustomer.getRoles());
        } else return null;

    }
}
