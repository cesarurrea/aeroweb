package org.co.aeroweb.persistence;

import java.util.List;

import org.co.aeroweb.model.Destino;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IDestinoDao extends CrudRepository<Destino, Integer>{
	
	@Query("SELECT d FROM Destino d")
	public List<Destino> listAll();

}
