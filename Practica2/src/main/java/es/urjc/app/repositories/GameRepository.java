package es.urjc.app.repositories;


import org.springframework.data.repository.CrudRepository;

import es.urjc.app.models.Juego;

public interface GameRepository extends CrudRepository<Juego, Long>  {
	Juego findByIdGame(Long id);
	Juego findByName(String name);
}
