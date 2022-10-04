package digitalcity.demeyert.overstockmanager.model.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
@Getter @Setter
public class CollectCardQuantityTable {

    @EmbeddedId
    private CollectCardId id;

    @MapsId("id1")
    @ManyToOne
    private Card card;

    @MapsId("id2")
    @ManyToOne
    private Collec collec;

    private String qtt;

}
