package digitalcity.demeyert.overstockmanager.controller;

import digitalcity.demeyert.overstockmanager.helper.CSVHelper;
import digitalcity.demeyert.overstockmanager.message.ResponseMessage;
import digitalcity.demeyert.overstockmanager.model.dto.CardDTO;
import digitalcity.demeyert.overstockmanager.model.dto.UserDTO;
import digitalcity.demeyert.overstockmanager.model.entity.ImageModel;
import digitalcity.demeyert.overstockmanager.model.forms.UserModifyForm;
import digitalcity.demeyert.overstockmanager.model.forms.UsersCreateForm;
import digitalcity.demeyert.overstockmanager.service.UserService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashSet;
import java.util.Set;

@CrossOrigin("http://localhost:8081")
@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id:[0-9]+}")
    public UserDTO getOne (@PathVariable long id) {
        return userService.getOne(id);
    }

    @PostMapping("/create")
    public UserDTO create (@RequestBody UsersCreateForm usersCreateForm) {
        return userService.create(usersCreateForm);
    }
    @PatchMapping(value = "/upload-file", consumes = { "multipart/form-data" })
    public String modifyUser(@RequestParam("file") MultipartFile file, @RequestBody UserModifyForm userModifyForm) {
        userService.modify(file, userModifyForm);
        return "your file is successfully uploaded";
    }
}
