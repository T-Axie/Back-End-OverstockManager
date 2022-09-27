package digitalcity.demeyert.overstockmanager.service;

import digitalcity.demeyert.overstockmanager.mapper.CardMapper;
import digitalcity.demeyert.overstockmanager.model.dto.CardDTO;
import digitalcity.demeyert.overstockmanager.repository.CardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardService {

    private final CardRepository repository;
    private final CardMapper mapper;


    public CardService(CardRepository repository, CardMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<CardDTO> CardByName (String name) {
        if( name == null)
            throw new IllegalArgumentException("inserted name cannot be empty");
        return repository.findCardsByNameContaining(name).stream().map(mapper::fromEntities).collect(Collectors.toList());
    }

}

