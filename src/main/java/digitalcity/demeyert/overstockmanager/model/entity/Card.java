package digitalcity.demeyert.overstockmanager.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private int cardmarketId;
    private String name;
    private String explansion;
    private Language language;
    private int count;
    private boolean foil;
    private boolean signed;
    private boolean playset;
    private Rarity rarity;

    public Card(int cardmarketId, String name, String explansion, Language language, int count, boolean foil, boolean signed, boolean playset, Rarity rarity, String comment) {
        this.cardmarketId = cardmarketId;
        this.name = name;
        this.explansion = explansion;
        this.language = language;
        this.count = count;
        this.foil = foil;
        this.signed = signed;
        this.playset = playset;
        this.rarity = rarity;
        this.comment = comment;
    }

    private String comment;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}