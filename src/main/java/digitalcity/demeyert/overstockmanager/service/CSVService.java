package digitalcity.demeyert.overstockmanager.service;

import digitalcity.demeyert.overstockmanager.exception.ElementNotFoundException;
import digitalcity.demeyert.overstockmanager.helper.CSVHelper;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import digitalcity.demeyert.overstockmanager.mapper.CardMapper;
import digitalcity.demeyert.overstockmanager.model.dto.CardDTO;
import digitalcity.demeyert.overstockmanager.model.entity.Card;
import digitalcity.demeyert.overstockmanager.model.entity.Collec;
import digitalcity.demeyert.overstockmanager.repository.CardRepository;
import digitalcity.demeyert.overstockmanager.repository.CollecRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;

@Service
public class CSVService {
    private final CardRepository repository;
    private final CardMapper mapper;
    private final CollecRepository collecRepository;

    public CSVService(CardRepository repository, CardMapper mapper, CollecRepository collecRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.collecRepository = collecRepository;
    }
    @Transactional
    public void save(MultipartFile file, Long id) {
        try {
            List<CardDTO> cards = CSVHelper.csvToCards(file.getInputStream());
            Collec collec = collecRepository.findById(id).orElseThrow(() -> new ElementNotFoundException(Card.class, id));
            collec.setCardList(cards.stream().map(mapper::toEntities).collect(Collectors.toList()));
            repository.saveAll(cards.stream().map(mapper::toEntities).collect(Collectors.toList()));
            collecRepository.saveAndFlush(collec);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }
}
