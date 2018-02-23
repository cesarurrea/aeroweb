package org.co.aeroweb.controller;

import java.util.List;

import org.co.aeroweb.model.Vuelo;
import org.co.aeroweb.service.VueloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/services")
public class VueloRestService extends AbstractAerowebRestController<Vuelo> {

	@Autowired
	public VueloRestService(VueloService service) {
		super(service);
	}

	@Override
	@GetMapping(value = "/vuelo", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Vuelo> findAll() {
		return service.findAll();
	}

	@Override
	@GetMapping(value = "/vuelo/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Vuelo find(@PathVariable("id") Integer id) {
		return service.find(id);
	}

	@Override
	@PostMapping(value = "/vuelo", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void save(@RequestBody Vuelo entity) {
		service.save(entity);

	}

	@Override
	@PutMapping(value = "/vuelo", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestBody Vuelo entity) {
		service.save(entity);

	}

	@Override
	@DeleteMapping(value = "/vuelo/{id}")
	public void delete(@PathVariable("id") Integer id) {
		service.delete(id);

	}

}
