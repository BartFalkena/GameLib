package nl.groningen.mitw.ch13.bf.eersteproject.gamelibdemo.Controller;

import nl.groningen.mitw.ch13.bf.eersteproject.gamelibdemo.model.Game;
import nl.groningen.mitw.ch13.bf.eersteproject.gamelibdemo.model.GameKey;
import nl.groningen.mitw.ch13.bf.eersteproject.gamelibdemo.repositories.GameKeyRepository;
import nl.groningen.mitw.ch13.bf.eersteproject.gamelibdemo.repositories.GameRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

/**
 * hier de opdracht die je gaat maken
 *
 * @author B.J. Falkena
 */

@Controller
public class GameKeyController {
    private final GameRepository gameRepository;
    private final GameKeyRepository gameKeyRepository;


    public GameKeyController(GameRepository gameRepository, GameKeyRepository gameKeyRepository) {
        this.gameRepository = gameRepository;
        this.gameKeyRepository = gameKeyRepository;
    }

    @GetMapping("/gameKey/new/{gameId}")
    private String createNewGameKey(@PathVariable("gameId") Long gameId) {
        Optional<Game> optionalGame = gameRepository.findById(gameId);

        if (optionalGame.isPresent()) {
            GameKey gamekey = new GameKey();
            gamekey.setGame(optionalGame.get());
            gameKeyRepository.save(gamekey);
        }

        return "redirect:/";
    }
}