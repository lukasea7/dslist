package com.lukasprojetos.dslist.services;

import com.lukasprojetos.dslist.dto.GameDTO;
import com.lukasprojetos.dslist.dto.GameListDTO;
import com.lukasprojetos.dslist.dto.GameMinDTO;
import com.lukasprojetos.dslist.entities.Game;
import com.lukasprojetos.dslist.entities.GameList;
import com.lukasprojetos.dslist.projections.GameMinProjection;
import com.lukasprojetos.dslist.repositories.GameListRepository;
import com.lukasprojetos.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameLiListRepository;

    @Autowired
    private GameRepository gameRepository;


    public List<GameListDTO> findAll(){
      List<GameList> result = gameLiListRepository.findAll();
      return result.stream().map(x -> new GameListDTO(x)).toList();

    }
    public void move(Long listId, int sourceIndex , int destinationIndex){
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for (int i =  min; i <= max; i++) {
            gameLiListRepository.updateBelongingPosition(listId,list.get(i).getId(), i);

        }

    }

}
