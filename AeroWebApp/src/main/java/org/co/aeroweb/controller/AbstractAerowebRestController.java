package org.co.aeroweb.controller;

import java.util.List;

import org.co.aeroweb.service.IAerowebService;

public abstract class AbstractAerowebRestController<T> {

	protected final IAerowebService<T> service;

	public AbstractAerowebRestController(IAerowebService<T> service) {
		super();
		this.service = service;
	}

	public abstract List<T> findAll();

	public abstract T find(Integer id);

	public abstract void save(T entity);

	public abstract void create(T entity);

	public abstract void delete(Integer id);

}
