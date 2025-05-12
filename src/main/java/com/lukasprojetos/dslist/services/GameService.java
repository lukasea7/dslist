package com.lukasprojetos.dslist.services;

import com.lukasprojetos.dslist.dto.GameDTO;
import com.lukasprojetos.dslist.dto.GameMinDTO;
import com.lukasprojetos.dslist.entities.Game;
import com.lukasprojetos.dslist.projections.GameMinProjection;
import com.lukasprojetos.dslist.repositories.GameRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;


    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).get();
        GameDTO dto = new GameDTO(result);
        return dto;


    }

    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }

    public List<GameMinDTO> findByList(Long listId) {
        List<GameMinProjection> result = gameRepository.searchByList(listId);
        return result.stream().map(x -> new GameMinDTO(x)).toList();


    }
}
