package digitalcity.demeyert.overstockmanager.controller;

import digitalcity.demeyert.overstockmanager.model.dto.CollecDTO;
import digitalcity.demeyert.overstockmanager.model.forms.CollecCreateForm;
import digitalcity.demeyert.overstockmanager.service.CollectService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("http://localhost:8081")
@RestController
@RequestMapping("/collect")
public class CollectController {

    private final CollectService service;

    public CollectController(CollectService service) {
        this.service = service;
    }

    @GetMapping("/{id:[0-9]+}")
    public CollecDTO getOne(@PathVariable long id) {
        return service.getOne(id);
    }

    @GetMapping({ "", "/all" })
    public List<CollecDTO> getAll() {
        return service.getAll();
    }

    @PostMapping
    public CollecDTO insert(@Valid @RequestBody CollecCreateForm form) {
        return service.create(form);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public CollecDTO delete(@PathVariable long id) {
        return service.delete(id);
    }
    @PutMapping("/{id}")
    public CollecDTO update(@PathVariable long id, @Valid @RequestBody CollecDTO collecDTO) {
        return service.update(id, collecDTO);
    }
}
