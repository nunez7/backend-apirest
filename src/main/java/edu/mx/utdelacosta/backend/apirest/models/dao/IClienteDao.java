package edu.mx.utdelacosta.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import edu.mx.utdelacosta.backend.apirest.models.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente	, Long>{
	
}
