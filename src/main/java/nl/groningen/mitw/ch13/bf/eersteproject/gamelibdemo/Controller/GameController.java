package nl.groningen.mitw.ch13.bf.eersteproject.gamelibdemo.Controller;

import nl.groningen.mitw.ch13.bf.eersteproject.gamelibdemo.model.Game;
import nl.groningen.mitw.ch13.bf.eersteproject.gamelibdemo.repositories.GameRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

    public GameController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }


    @GetMapping("/")
    private String showGameLibrary(Model model) {
        List<Game> games = new ArrayList<>();


        model.addAttribute("allGames", gameRepository.findAll());

        return "GameLibrary";
    }
}