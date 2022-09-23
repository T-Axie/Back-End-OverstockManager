package digitalcity.demeyert.overstockManager.repository;

import digitalcity.demeyert.overstockManager.model.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}
