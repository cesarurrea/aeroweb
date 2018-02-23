package org.co.aeroweb.controller;

import java.util.List;

import org.co.aeroweb.model.Cliente;
import org.co.aeroweb.service.ClienteService;
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
public class ClienteRestController extends AbstractAerowebRestController<Cliente> {

	@Autowired
	public ClienteRestController(ClienteService service) {
		super(service);
	}

	@Override
	@GetMapping(value = "/cliente", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Cliente> findAll() {
		return service.findAll();
	}

	@Override
	@GetMapping(value = "/cliente/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Cliente find(@PathVariable("id") Integer id) {
		return service.find(id);
	}

	@Override
	@PostMapping(value = "/cliente", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void save(@RequestBody Cliente entity) {
		service.save(entity);
	}

	@Override
	@PutMapping(value = "/cliente", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestBody Cliente entity) {
		service.save(entity);
	}

	@Override
	@DeleteMapping(value = "/cliente/{id}")
	public void delete(@PathVariable("id") Integer id) {
		service.delete(id);

	}

}
