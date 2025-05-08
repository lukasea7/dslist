package com.lukasprojetos.dslist.repositories;

import com.lukasprojetos.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

}
