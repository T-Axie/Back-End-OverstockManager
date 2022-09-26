package digitalcity.demeyert.overstockmanager.service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import digitalcity.demeyert.overstockmanager.helper.CSVHelper;
import digitalcity.demeyert.overstockmanager.mapper.CardMapper;
import digitalcity.demeyert.overstockmanager.model.dto.CardDTO;
import digitalcity.demeyert.overstockmanager.model.entity.Card;
import digitalcity.demeyert.overstockmanager.repository.CardRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CSVService {
    CardRepository repository;
    CardMapper mapper;

    public CSVService(CardRepository repository, CardMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public void save(MultipartFile file) {
        try {
            List<CardDTO> cards = CSVHelper.csvToCards(file.getInputStream());
            repository.saveAll(cards.stream().map(mapper::toEntities).collect(Collectors.toList()));
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    public List<Card> getAllCards() {
        return repository.findAll();
    }
}
