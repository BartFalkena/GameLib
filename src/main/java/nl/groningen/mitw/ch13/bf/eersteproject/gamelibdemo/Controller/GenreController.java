package nl.groningen.mitw.ch13.bf.eersteproject.gamelibdemo.Controller;

import nl.groningen.mitw.ch13.bf.eersteproject.gamelibdemo.model.Game;
import nl.groningen.mitw.ch13.bf.eersteproject.gamelibdemo.model.Genre;
import nl.groningen.mitw.ch13.bf.eersteproject.gamelibdemo.repositories.GenreRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

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
    private String showAllGenres(Model model) {
        model.addAttribute("allGenres", genreRepository.findAll());
        model.addAttribute("newGenres", new Genre());


        return "GenreOverview";
    }
@PostMapping("/genre/new")
private String saveOrUpdateGenre(@ModelAttribute("newGenre") Genre genre, BindingResult result) {
    if (!result.hasErrors()) {
        genreRepository.save(genre);
    }

    return "redirect:/genre";
}




}