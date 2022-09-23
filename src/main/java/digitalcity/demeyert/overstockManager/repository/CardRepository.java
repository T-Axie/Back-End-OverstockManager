package digitalcity.demeyert.overstockManager.repository;

import digitalcity.demeyert.overstockManager.model.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {

}
