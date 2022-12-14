package digitalcity.demeyert.overstockmanager.controller;

import digitalcity.demeyert.overstockmanager.model.dto.CardDTO;
import digitalcity.demeyert.overstockmanager.model.entity.Rarity;
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
    @GetMapping("/{id:[0-9]+}")
    public CardDTO getOne (@PathVariable long id) {
        return service.getOne(id);
    }
    @GetMapping("/name")
    public CardDTO getByName(@RequestParam String name){
        return service.cardByName(name);
    }
    @GetMapping("/set")
    public List<CardDTO> getBySet(@RequestParam String set){
        return service.cardBySet(set);
    }
    @GetMapping("/rarity")
    public List<CardDTO> getByRarity(@RequestParam Rarity rarity){
        return service.cardByrarity(rarity);
    }
    @DeleteMapping("/{id:[0-9]+}")
    public CardDTO delete (@PathVariable long id) {
        return service.delete(id);
    }

    @GetMapping("/update/{id:[0-9]+}\"")
    public CardDTO update(@RequestBody CardDTO cardDTO){
        return service.update(cardDTO);
    }

    @GetMapping("/all")
    public List<CardDTO> getByAll(){
        return service.getAll();
    }

    @PostMapping("/add")
    public CardDTO create(@RequestBody CardDTO cardDTO){
        return service.create(cardDTO);
    }
}
