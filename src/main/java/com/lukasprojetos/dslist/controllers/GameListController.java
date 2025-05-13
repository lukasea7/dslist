package com.lukasprojetos.dslist.controllers;

import com.lukasprojetos.dslist.dto.GameDTO;
import com.lukasprojetos.dslist.dto.GameListDTO;
import com.lukasprojetos.dslist.dto.GameMinDTO;
import com.lukasprojetos.dslist.dto.ReplacementDTO;
import com.lukasprojetos.dslist.services.GameListService;
import com.lukasprojetos.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController<Games> {
    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll() {
        List<GameListDTO> result = gameListService.findAll();
        return result;

    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId) {
        List<GameMinDTO> result = gameService.findByList(listId);
        return result;

    }

    @PostMapping (value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
       gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());


    }

}
