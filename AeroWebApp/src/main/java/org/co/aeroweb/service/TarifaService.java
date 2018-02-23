package org.co.aeroweb.service;

import java.util.List;

import javax.transaction.Transactional;

import org.co.aeroweb.model.Tarifa;
import org.co.aeroweb.persistence.ITarifaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class TarifaService implements IAerowebService<Tarifa> {

	private final ITarifaDao tarifaDao;

	@Autowired
	public TarifaService(ITarifaDao tarifaDao) {
		super();
		this.tarifaDao = tarifaDao;
	}

	@Override
	public List<Tarifa> findAll() {
		return tarifaDao.listAll();
	}

	@Override
	public Tarifa find(Integer id) {
		return tarifaDao.findOne(id);
	}

	@Override
	public void save(Tarifa entity) {
		tarifaDao.save(entity);

	}

	@Override
	public void delete(Integer id) {
		tarifaDao.delete(id);

	}

}
