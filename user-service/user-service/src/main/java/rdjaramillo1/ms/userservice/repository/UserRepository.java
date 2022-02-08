package rdjaramillo1.ms.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rdjaramillo1.ms.userservice.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
