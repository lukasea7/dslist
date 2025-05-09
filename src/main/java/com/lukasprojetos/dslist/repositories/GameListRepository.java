package com.lukasprojetos.dslist.repositories;

import com.lukasprojetos.dslist.entities.Game;
import com.lukasprojetos.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
