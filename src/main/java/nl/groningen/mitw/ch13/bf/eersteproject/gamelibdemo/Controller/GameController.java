package nl.groningen.mitw.ch13.bf.eersteproject.gamelibdemo.Controller;

import nl.groningen.mitw.ch13.bf.eersteproject.gamelibdemo.model.Game;
import nl.groningen.mitw.ch13.bf.eersteproject.gamelibdemo.repositories.GameKeyRepository;
import nl.groningen.mitw.ch13.bf.eersteproject.gamelibdemo.repositories.GameRepository;
import nl.groningen.mitw.ch13.bf.eersteproject.gamelibdemo.repositories.GenreRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

/**
 * handle all requests regarding
 *
 * @author B.J. Falkena
 */


@Controller
public class GameController {
    private final GameRepository gameRepository;
    private final GenreRepository genreRepository;

    public GameController(GameRepository gameRepository, GenreRepository genreRepository) {
        this.gameRepository = gameRepository;
        this.genreRepository = genreRepository;
    }


    @GetMapping("/")
    private String showGameLibrary(Model model) {
        List<Game> games = new ArrayList<>();


        model.addAttribute("allGames", gameRepository.findAll());

        return "GameLibrary";
    }
    @GetMapping("/game/new")
    private String showGameForm(Model model) {
        model.addAttribute("game", new Game());
        model.addAttribute("allGenres",genreRepository.findAll());

        return "gameForm";
    }

    @PostMapping("/game/new")
    private String saveGame(@ModelAttribute("game") Game gameToBeSaved, BindingResult result) {
        if (!result.hasErrors()) {
            gameRepository.save(gameToBeSaved);
        }

        return "redirect:/";
    }


}