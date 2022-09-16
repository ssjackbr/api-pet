package api.pet.service;

import api.pet.domain.dto.AddressDTO;
import api.pet.domain.dto.RoleDTO;
import api.pet.domain.dto.UserDTO;
import api.pet.domain.dto.UserInsertDTO;
import api.pet.domain.entity.Address;
import api.pet.domain.entity.Customer;
import api.pet.domain.entity.Partner;
import api.pet.domain.entity.Role;
import api.pet.domain.enums.Roles;
import api.pet.repository.CustomerRepository;
import api.pet.repository.PartnerRepository;
import api.pet.util.mapper.AddressMapper;
import api.pet.util.mapper.RoleMapper;
import api.pet.util.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    private final AddressMapper addressMapper;
    private final RoleMapper roleMapper;
    private final BCryptPasswordEncoder passwordEncoder;



}
