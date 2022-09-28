package digitalcity.demeyert.overstockmanager.mapper;

import digitalcity.demeyert.overstockmanager.model.dto.CardDTO;
import digitalcity.demeyert.overstockmanager.model.entity.Card;
import digitalcity.demeyert.overstockmanager.model.entity.Language;
import digitalcity.demeyert.overstockmanager.model.entity.Rarity;
import digitalcity.demeyert.overstockmanager.model.entity.State;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardMapper {

    CardDTO fromEntities(Card card);
    Card toEntities(CardDTO cardDTO);
}
