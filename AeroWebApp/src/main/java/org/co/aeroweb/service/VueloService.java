package org.co.aeroweb.service;

import java.util.List;

import javax.transaction.Transactional;

import org.co.aeroweb.model.Vuelo;
import org.co.aeroweb.persistence.IVueloDao;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class VueloService implements IAerowebService<Vuelo> {

	private final IVueloDao vueloDao;

	public VueloService(IVueloDao vueloDao) {
		super();
		this.vueloDao = vueloDao;
	}

	@Override
	public List<Vuelo> findAll() {
		return vueloDao.listAll();
	}

	@Override
	public Vuelo find(Integer id) {
		return vueloDao.findOne(id);
	}

	@Override
	public void save(Vuelo entity) {
		vueloDao.save(entity);

	}

	@Override
	public void delete(Integer id) {
		vueloDao.delete(id);

	}

}
