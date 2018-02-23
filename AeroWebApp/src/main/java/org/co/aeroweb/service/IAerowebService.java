package org.co.aeroweb.service;

import java.util.List;

public interface IAerowebService<T> {

	public List<T> findAll();

	public T find(Integer id);

	public void save(T entity);

	public void delete(Integer id);

}
