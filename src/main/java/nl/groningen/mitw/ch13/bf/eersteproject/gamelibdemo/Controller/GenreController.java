package nl.groningen.mitw.ch13.bf.eersteproject.gamelibdemo.Controller;

import ch.qos.logback.core.model.Model;
import nl.groningen.mitw.ch13.bf.eersteproject.gamelibdemo.model.Genre;
import nl.groningen.mitw.ch13.bf.eersteproject.gamelibdemo.repositories.GenreRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * hier de opdracht die je gaat maken
 *
 * @author B.J. Falkena
 */

@Controller
public class GenreController {
    private final GenreRepository genreRepository;

    public GenreController(GenreRepository genreRepository) {

        this.genreRepository = genreRepository;
    }

    @GetMapping("/genre")
    private String showAllGenres (Model model) {

        //add.attributes

        return "genreOverview";
    }

    @PostMapping("/genre/new")
    private String saveOrUpdateGenre(@ModelAttribute("newGenre") Genre genre, BindingResult result) {
        if (!result.hasErrors()) {
//            genreRepository.save(genre);
        }

        return "redirect:/author";
    }




}