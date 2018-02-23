package org.co.aeroweb.persistence;

import java.util.List;

import org.co.aeroweb.model.Vuelo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IVueloDao extends CrudRepository<Vuelo, Integer>{
	
	@Query("SELECT v FROM Vuelo v")
	public List<Vuelo> listAll();

}
