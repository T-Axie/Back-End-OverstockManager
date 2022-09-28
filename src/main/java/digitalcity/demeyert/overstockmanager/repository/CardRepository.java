package digitalcity.demeyert.overstockmanager.repository;

import digitalcity.demeyert.overstockmanager.model.entity.Card;
import digitalcity.demeyert.overstockmanager.model.entity.Rarity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card> findCardsByGameSet (String set);
    Card findCardsByName (String name);
    List<Card> findCardsByRarity (Rarity rarity);
}
