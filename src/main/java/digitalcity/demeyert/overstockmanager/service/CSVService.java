package digitalcity.demeyert.overstockmanager.service;

import digitalcity.demeyert.overstockmanager.helper.CSVHelper;
import digitalcity.demeyert.overstockmanager.model.entity.Card;
import digitalcity.demeyert.overstockmanager.repository.CardRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class CSVService {

    CardRepository repository;
    public void save(MultipartFile file) {
        try {
            List<Card> tutorials = CSVHelper.csvToCards(file.getInputStream());
            repository.saveAll(tutorials);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    public List<Card> getAllTutorials() {
        return repository.findAll();
    }

}
