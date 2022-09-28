package digitalcity.demeyert.overstockmanager.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter @Setter
public class CollectCardId implements Serializable {

    private Long id1;
    private Long id2;

}
