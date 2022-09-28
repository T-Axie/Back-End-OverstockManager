package digitalcity.demeyert.overstockmanager.controller;

import digitalcity.demeyert.overstockmanager.helper.CSVHelper;
import digitalcity.demeyert.overstockmanager.message.ResponseMessage;
import digitalcity.demeyert.overstockmanager.model.dto.CardDTO;
import digitalcity.demeyert.overstockmanager.model.entity.Rarity;
import digitalcity.demeyert.overstockmanager.service.CSVService;
import digitalcity.demeyert.overstockmanager.service.CardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin("http://localhost:8081")
@RestController
@RequestMapping("/card")
public class CardController {
    private final CardService service;
    private final CSVService fileService;

    public CardController(CardService service, CSVService fileService) {
        this.service = service;
        this.fileService = fileService;
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
    @PatchMapping(value = "/upload", consumes = { "multipart/form-data" })
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam MultipartFile file, Long id) {
        String message = "";

        if (CSVHelper.hasCSVFormat(file)) {
            try {
                fileService.save(file);

                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        }

        message = "Please upload a csv file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }
    @GetMapping("/all")
    public List<CardDTO> getByAll(){
        return service.getAll();
    }
}
