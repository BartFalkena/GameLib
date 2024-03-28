package nl.groningen.mitw.ch13.bf.eersteproject.gamelibdemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

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
    private String Genre;
    private String Type;

    public Game(String title, String genre, String type) {
        Title = title;
        Genre = genre;
        Type = type;
    }

    @OneToMany (mappedBy = "game")
    private List<GameKey> gameKeys;

    public Game() {

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

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
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