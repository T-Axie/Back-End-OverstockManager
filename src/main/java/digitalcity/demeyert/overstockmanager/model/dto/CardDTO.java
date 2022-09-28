package digitalcity.demeyert.overstockmanager.model.dto;

import digitalcity.demeyert.overstockmanager.model.entity.State;
import digitalcity.demeyert.overstockmanager.model.entity.Language;
import digitalcity.demeyert.overstockmanager.model.entity.Rarity;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class CardDTO {

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

    public CardDTO(int cardmarketId, String name, String gameSet, Language language, int count, boolean foil, boolean signed, boolean playset, Rarity rarity, State state, String comment) {
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
}
