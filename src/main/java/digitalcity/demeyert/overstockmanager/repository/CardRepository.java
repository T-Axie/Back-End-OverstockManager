package digitalcity.demeyert.overstockmanager.repository;

import digitalcity.demeyert.overstockmanager.model.entity.Card;
import digitalcity.demeyert.overstockmanager.model.entity.Rarity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card> findCardsByGameSet (String set);
    Card findCardsByName (String name);
    List<Card> findCardsByRarity (Rarity rarity);
}
