package com.lukasprojetos.dslist.services;

import com.lukasprojetos.dslist.dto.GameDTO;
import com.lukasprojetos.dslist.dto.GameListDTO;
import com.lukasprojetos.dslist.dto.GameMinDTO;
import com.lukasprojetos.dslist.entities.Game;
import com.lukasprojetos.dslist.entities.GameList;
import com.lukasprojetos.dslist.repositories.GameListRepository;
import com.lukasprojetos.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameLiListRepository;





    public List<GameListDTO> findAll(){
      List<GameList> result = gameLiListRepository.findAll();
      return result.stream().map(x -> new GameListDTO(x)).toList();

    }

}
