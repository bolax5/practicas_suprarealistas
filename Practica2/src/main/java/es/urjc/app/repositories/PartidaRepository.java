package es.urjc.app.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import es.urjc.app.models.Juego;
import es.urjc.app.models.Partida;
import es.urjc.app.models.Usuario;

public interface PartidaRepository extends CrudRepository<Partida,Long> {
	ArrayList<Partida> findByUserAndGame(Usuario u , Juego j);
}
