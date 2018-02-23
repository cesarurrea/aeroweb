package org.co.aeroweb.service;

import java.util.List;

import javax.transaction.Transactional;

import org.co.aeroweb.model.Cliente;
import org.co.aeroweb.persistence.IClienteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class ClienteService implements IAerowebService<Cliente> {

	private final IClienteDao clienteDao;
	
	@Autowired
	public ClienteService(IClienteDao clienteDao) {
		super();
		this.clienteDao = clienteDao;
	}

	@Override
	public List<Cliente> findAll() {
		return clienteDao.listAll();
	}

	@Override
	public Cliente find(Integer id) {
		return clienteDao.findOne(id);
	}

	@Override
	public void save(Cliente entity) {
		clienteDao.save(entity);

	}

	@Override
	public void delete(Integer id) {
		clienteDao.delete(id);

	}

}
