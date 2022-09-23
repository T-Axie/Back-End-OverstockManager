package digitalcity.demeyert.overstockManager.model.entity;

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
    private String comment;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}