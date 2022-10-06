package digitalcity.demeyert.overstockmanager.service;

import digitalcity.demeyert.overstockmanager.exception.ElementNotFoundException;
import digitalcity.demeyert.overstockmanager.mapper.UsersMapper;
import digitalcity.demeyert.overstockmanager.model.dto.CardDTO;
import digitalcity.demeyert.overstockmanager.model.dto.UserDTO;
import digitalcity.demeyert.overstockmanager.model.entity.Card;
import digitalcity.demeyert.overstockmanager.model.forms.UserModifyForm;
import digitalcity.demeyert.overstockmanager.model.forms.UsersCreateForm;
import digitalcity.demeyert.overstockmanager.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserService {

    UserRepository userRepository;
    UsersMapper mapper;

    public UserService(UserRepository userRepository, UsersMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    public UserDTO getOne(long id) {
        return mapper.fromEntity(userRepository.findById(id).orElseThrow(() -> new ElementNotFoundException(Card.class, id)));
    }

    public UserDTO create(UsersCreateForm usersCreateForm) {
        return mapper.fromEntity(userRepository.save(mapper.toEntity(usersCreateForm)));
    }

    public void modify(MultipartFile file, UserModifyForm userModifyForm) {

    }
}
