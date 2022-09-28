package digitalcity.demeyert.overstockmanager.controller;

import digitalcity.demeyert.overstockmanager.helper.CSVHelper;
import digitalcity.demeyert.overstockmanager.message.ResponseMessage;
import digitalcity.demeyert.overstockmanager.model.entity.Card;
import digitalcity.demeyert.overstockmanager.service.CSVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin("http://localhost:8081")
@RestController
@RequestMapping("/api/csv")
public class CSVController {

    CSVService fileService;

    public CSVController(CSVService fileService) {
        this.fileService = fileService;
    }

    @PostMapping(value = "/upload", consumes = { "multipart/form-data" })
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam MultipartFile file) {
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
}
