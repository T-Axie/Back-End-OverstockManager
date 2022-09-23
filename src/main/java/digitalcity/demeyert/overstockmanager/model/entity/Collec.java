package digitalcity.demeyert.overstockmanager.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Collec {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "collec_card_list",
            joinColumns = @JoinColumn(name = "collec_id"),
            inverseJoinColumns = @JoinColumn(name = "card_id")
    )
    private List<Card> cardList = new java.util.ArrayList<>();

    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
