package digitalcity.demeyert.overstockmanager.mapper;

import digitalcity.demeyert.overstockmanager.model.dto.UserDTO;
import org.apache.catalina.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface UserInterface {

    UserDTO fromEntity(User user);
    User toEntity(UserDTO userDTO);

}
