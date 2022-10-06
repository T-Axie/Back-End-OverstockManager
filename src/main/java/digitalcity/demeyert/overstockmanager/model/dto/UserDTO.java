package digitalcity.demeyert.overstockmanager.model.dto;

import digitalcity.demeyert.overstockmanager.model.entity.Collec;
import digitalcity.demeyert.overstockmanager.model.entity.ImageModel;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class UserDTO {

    private Long id;
    private String email;
    private String password;
    private String description;
    private String username;
    private List<Collec> collec;
    private ImageModel userImage;

    public UserDTO(String description, String username, ImageModel userImage) {
        this.description = description;
        this.username = username;
        this.userImage = userImage;
    }
}
