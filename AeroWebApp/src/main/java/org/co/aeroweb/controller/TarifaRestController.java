package org.co.aeroweb.controller;

import java.util.List;

import org.co.aeroweb.model.Tarifa;
import org.co.aeroweb.service.TarifaService;
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
public class TarifaRestController extends AbstractAerowebRestController<Tarifa> {

	@Autowired
	public TarifaRestController(TarifaService service) {
		super(service);
	}

	@Override
	@GetMapping(value = "/tarifa", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Tarifa> findAll() {
		return service.findAll();
	}

	@Override
	@GetMapping(value = "/tarifa/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Tarifa find(@PathVariable("id") Integer id) {
		return service.find(id);
	}

	@Override
	@PostMapping(value = "/tarifa", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void save(@RequestBody Tarifa entity) {
		service.save(entity);

	}

	@Override
	@PutMapping(value = "/tarifa", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestBody Tarifa entity) {
		service.save(entity);

	}

	@Override
	@DeleteMapping(value = "/tarifa/{id}")
	public void delete(@PathVariable("id") Integer id) {
		service.delete(id);

	}

}
