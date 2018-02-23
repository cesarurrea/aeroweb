package org.co.aeroweb.persistence;

import java.util.List;

import org.co.aeroweb.model.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IClienteDao extends CrudRepository<Cliente, Integer>{
	
	@Query("SELECT c FROM Cliente c")
	public List<Cliente> listAll();

}
