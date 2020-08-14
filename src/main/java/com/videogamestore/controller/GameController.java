package com.videogamestore.controller;

import com.videogamestore.model.Client;
import com.videogamestore.model.Game;
import com.videogamestore.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameRepository gameRepository;

    @GetMapping
    public ResponseEntity<List<Game>> getGame(){
        List<Game> games = (List<Game>) gameRepository.findAll();
        return ResponseEntity.ok(games);
    }

    @RequestMapping(value = "{gameId}")
    public ResponseEntity<Game> getGameById(@PathVariable("gameId") Game game){
        Optional<Game> games = gameRepository.findById(game.getId());
        if(games.isPresent()){
            return ResponseEntity.ok(games.get());
        }else{
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping
    public ResponseEntity<Game> createGame(@RequestBody Game game){
        Game newGame = gameRepository.save(game);
        return ResponseEntity.ok(newGame);
    }

    @DeleteMapping(value = "{gameId}")
    public ResponseEntity<Void> deleteGame(@PathVariable("gameId") Long gameId){
        gameRepository.deleteById(gameId);
        return ResponseEntity.ok(null);
    }

    @PutMapping
    public ResponseEntity<Game> updateCause(@RequestBody Game game){
        Optional<Game> games = gameRepository.findById(game.getId());
        if(games.isPresent()){
            Game updateGame = games.get();
            updateGame.setTittle(game.getTitle());
            updateGame.setDirector(game.getDirector());
            updateGame.setProducer(game.getProducer());
            updateGame.setMark(game.getMark());
            updateGame.setYear(game.getYear());
            updateGame.setPrice(game.getPrice());
            gameRepository.save(updateGame);
            return ResponseEntity.ok(updateGame);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping(value = "{gameId}")
    public ResponseEntity<Game> partialUpdateGame(@PathVariable("gameId") Long gameId, @RequestBody Game game){
        Optional<Game> games = gameRepository.findById(gameId);
        if(games.isPresent()){
            Game partialUpdateClient = games.get();
            if(game.getTitle() != null){
                partialUpdateClient.setTittle(game.getTitle());
            }

            if(game.getDirector() != null){
                partialUpdateClient.setDirector(game.getDirector());
            }

            if(game.getProducer() != null){
                partialUpdateClient.setProducer(game.getProducer());
            }

            if(game.getMark() != null){
                partialUpdateClient.setMark(game.getMark());
            }

            if(game.getYear() != 0){
                partialUpdateClient.setYear(game.getYear());
            }

            if(game.getPrice() != 0){
                partialUpdateClient.setPrice(game.getPrice());
            }

            gameRepository.save(partialUpdateClient);
            return ResponseEntity.ok(partialUpdateClient);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
