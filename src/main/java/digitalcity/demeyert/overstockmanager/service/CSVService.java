package digitalcity.demeyert.overstockmanager.service;

import digitalcity.demeyert.overstockmanager.exception.ElementNotFoundException;
import digitalcity.demeyert.overstockmanager.helper.CSVHelper;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import digitalcity.demeyert.overstockmanager.mapper.CardMapper;
import digitalcity.demeyert.overstockmanager.model.dto.CardDTO;
import digitalcity.demeyert.overstockmanager.model.entity.*;
import digitalcity.demeyert.overstockmanager.repository.CardRepository;
import digitalcity.demeyert.overstockmanager.repository.CollecRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;

@Service
@Transactional(dontRollbackOn = { RuntimeException.class })
public class CSVService {
    private final CardRepository repository;
    private final CardMapper mapper;
    private final CollecRepository collecRepository;

    public CSVService(CardRepository repository, CardMapper mapper, CollecRepository collecRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.collecRepository = collecRepository;
    }

    public void save(MultipartFile file, Long id) {
        try {
            List<CardDTO> cards = CSVHelper.csvToCards(file.getInputStream());
            Collec collec = collecRepository.findById(id).orElseThrow(() -> new ElementNotFoundException(Card.class, id));
            collec.setCardList(cards.stream().map(mapper::toEntities).collect(Collectors.toList()));
//            Card card = new Card(1, "tt", "tt", Language.ENGLISH, 2, false, false, false, Rarity.RARE, State.EX, "s'en bas lec");
//            repository.save(card);
            repository.saveAll(cards.stream().map(mapper::toEntities).collect(Collectors.toList()));
            collecRepository.save(collec);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }

    }
}
