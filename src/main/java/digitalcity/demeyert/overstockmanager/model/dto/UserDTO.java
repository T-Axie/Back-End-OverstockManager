package digitalcity.demeyert.overstockmanager.model.dto;

import digitalcity.demeyert.overstockmanager.model.entity.Collec;
import digitalcity.demeyert.overstockmanager.model.entity.ImageModel;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class UserDTO {

    private Long id;
    private String username;
    private String password;
    private Collec collection;
    private ImageModel userImage;

}
