package api.pet.repository;

import api.pet.domain.entity.User;
import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Primary
public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String email);

    Optional<User> findById(Long id);

}
