package es.urjc.app.repositories;

import es.urjc.app.models.IntentoConexion;
import org.springframework.data.repository.CrudRepository;

public interface IntentoRepository extends CrudRepository< IntentoConexion,Long> {

}
