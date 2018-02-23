package org.co.aeroweb.persistence;

import java.util.List;

import org.co.aeroweb.model.Tarifa;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ITarifaDao extends CrudRepository<Tarifa, Integer> {

	@Query("SELECT t FROM Tarifa t")
	public List<Tarifa> listAll();

}
