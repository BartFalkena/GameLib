package nl.groningen.mitw.ch13.bf.eersteproject.gamelibdemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * hier de opdracht die je gaat maken
 *
 * @author B.J. Falkena
 */
@Entity
public class Genre {

    @Id @GeneratedValue
    private Long genreId;
    private String name;



    @Override
    public String toString() {
        return name;
    }

    public Long getGenreId() {
        return genreId;
    }

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }

    public String getName() {
        return name;
    }

    public void setName(String genre) {
        this.name = genre;
    }
}