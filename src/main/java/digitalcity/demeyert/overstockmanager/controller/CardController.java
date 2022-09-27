package digitalcity.demeyert.overstockmanager.controller;

import digitalcity.demeyert.overstockmanager.model.dto.CardDTO;
import digitalcity.demeyert.overstockmanager.service.CardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:8081")
@RestController
@RequestMapping("/card")
public class CardController {
    private final CardService service;

    public CardController(CardService service) {
        this.service = service;
    }


    @GetMapping("/name")
    public List<CardDTO> getByName(@RequestBody String name){
        return service.CardByName(name);
    }
}
