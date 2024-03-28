package nl.groningen.mitw.ch13.bf.eersteproject.gamelibdemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

/**
 * hier de opdracht die je gaat maken
 *
 * @author B.J. Falkena
 */
    @Entity
    public class GameKey {
        @Id @GeneratedValue
        private Long gameKeyId;

        private Boolean available = true;

        @ManyToOne
        private Game game;

    public Long getGameKeyId() {
        return gameKeyId;
    }

    public void setGameKeyId(Long gameKeyId) {
        this.gameKeyId = gameKeyId;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}