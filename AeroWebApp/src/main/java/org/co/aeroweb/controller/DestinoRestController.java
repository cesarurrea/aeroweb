package org.co.aeroweb.controller;

import java.util.List;

import org.co.aeroweb.model.Destino;
import org.co.aeroweb.service.DestinoService;
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
public class DestinoRestController extends AbstractAerowebRestController<Destino> {

	@Autowired
	public DestinoRestController(DestinoService service) {
		super(service);
	}

	@Override
	@GetMapping(value = "/destino", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Destino> findAll() {
		return service.findAll();
	}

	@Override
	@GetMapping(value = "/destino/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Destino find(@PathVariable("id") Integer id) {
		return service.find(id);
	}

	@Override
	@PostMapping(value = "/destino", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void save(@RequestBody Destino entity) {
		service.save(entity);

	}

	@Override
	@PutMapping(value = "/destino", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestBody Destino entity) {
		service.save(entity);

	}

	@Override
	@DeleteMapping(value = "/destino/{id}")
	public void delete(@PathVariable("id") Integer id) {
		service.delete(id);

	}

}
