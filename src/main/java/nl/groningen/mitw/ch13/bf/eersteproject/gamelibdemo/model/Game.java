package nl.groningen.mitw.ch13.bf.eersteproject.gamelibdemo.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

/**
 * represents a game that
 *
 * @author B.J. Falkena
 */
@Entity
public class Game {
    @Id @GeneratedValue
    private Long gameId;
    private String Title;
    private String Type;

    @ManyToMany
    private Set<Genre> genres;

    @OneToMany (mappedBy = "game")
    private List<GameKey> gameKeys;

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public int getNumberOfUnusedKeys() {
        int count = 0;
        for (GameKey gamekey : gameKeys) {
            if (gamekey.getAvailable())
                    count++;


        }
        return count;

    }
    public int getTotalNumberOfGeneratedKeys() {
        return gameKeys.size();
    }



    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public List<GameKey> getGameKeys() {
        return gameKeys;
    }

    public void setGameKeys(List<GameKey> gameKeys) {
        this.gameKeys = gameKeys;
    }
}