package nl.groningen.mitw.ch13.bf.eersteproject.gamelibdemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;

/**
 * represents a game that
 *
 * @author B.J. Falkena
 */
@Entity
public class Game {
    @Id @GeneratedValue
    private Long bookId;
    private String Title;
    private String Genre;
    private String Type;

    public Game(String title, String genre, String type) {
        Title = title;
        Genre = genre;
        Type = type;
    }

    public Game() {

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

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
}