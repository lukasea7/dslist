package com.lukasprojetos.dslist.controllers;

import com.lukasprojetos.dslist.dto.GameMinDTO;
import com.lukasprojetos.dslist.entities.Game;
import com.lukasprojetos.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController<Games> {
    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameMinDTO> findAll(){

       List<GameMinDTO> result = gameService.findAll();

       return result;

    }

}
