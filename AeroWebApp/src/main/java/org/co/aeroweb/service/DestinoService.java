package org.co.aeroweb.service;

import java.util.List;

import javax.transaction.Transactional;

import org.co.aeroweb.model.Destino;
import org.co.aeroweb.persistence.IDestinoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class DestinoService implements IAerowebService<Destino> {

	private final IDestinoDao destinoDao;

	@Autowired
	public DestinoService(IDestinoDao destinoDao) {
		super();
		this.destinoDao = destinoDao;
	}

	@Override
	public List<Destino> findAll() {
		return destinoDao.listAll();
	}

	@Override
	public Destino find(Integer id) {
		return destinoDao.findOne(id);
	}

	@Override
	public void save(Destino entity) {
		destinoDao.save(entity);

	}

	@Override
	public void delete(Integer id) {
		destinoDao.delete(id);

	}

}
