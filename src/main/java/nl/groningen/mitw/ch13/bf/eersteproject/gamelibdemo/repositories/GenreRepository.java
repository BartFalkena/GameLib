package nl.groningen.mitw.ch13.bf.eersteproject.gamelibdemo.repositories;

import nl.groningen.mitw.ch13.bf.eersteproject.gamelibdemo.model.Game;
import nl.groningen.mitw.ch13.bf.eersteproject.gamelibdemo.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * hier de opdracht die je gaat maken
 *
 * @author B.J. Falkena
 */
public interface GenreRepository extends JpaRepository<Genre, Long> {
}
