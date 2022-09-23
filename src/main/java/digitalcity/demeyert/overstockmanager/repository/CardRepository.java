package digitalcity.demeyert.overstockmanager.repository;

import digitalcity.demeyert.overstockmanager.model.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {

}
