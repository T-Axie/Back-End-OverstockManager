package digitalcity.demeyert.overstockmanager.model.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private int cardmarketId;
    private String name;
    private String gameSet;
    private Language language;
    private int count;
    private boolean foil;
    private boolean signed;
    private boolean playset;
    private Rarity rarity;
    private State state;
    private String comment;

    public Card(int cardmarketId, String name, String gameSet, Language language, int count, boolean foil, boolean signed, boolean playset, Rarity rarity, State state, String comment) {
        this.cardmarketId = cardmarketId;
        this.name = name;
        this.gameSet = gameSet;
        this.language = language;
        this.count = count;
        this.foil = foil;
        this.signed = signed;
        this.playset = playset;
        this.rarity = rarity;
        this.state = state;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCardmarketId() {
        return cardmarketId;
    }

    public void setCardmarketId(int cardmarketId) {
        this.cardmarketId = cardmarketId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGameSet() {
        return gameSet;
    }

    public void setGameSet(String gameSet) {
        this.gameSet = gameSet;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isFoil() {
        return foil;
    }

    public void setFoil(boolean foil) {
        this.foil = foil;
    }

    public boolean isSigned() {
        return signed;
    }

    public void setSigned(boolean signed) {
        this.signed = signed;
    }

    public boolean isPlayset() {
        return playset;
    }

    public void setPlayset(boolean playset) {
        this.playset = playset;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Card card = (Card) o;
        return id != null && Objects.equals(id, card.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}