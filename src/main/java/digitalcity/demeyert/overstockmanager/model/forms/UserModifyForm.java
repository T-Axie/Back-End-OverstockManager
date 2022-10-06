package digitalcity.demeyert.overstockmanager.model.forms;

import digitalcity.demeyert.overstockmanager.model.entity.ImageModel;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class UserModifyForm {

    private String description;
    private String username;
    private ImageModel userImage;

}
