package edu.mx.utdelacosta.backend.apirest.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mx.utdelacosta.backend.apirest.models.entity.Cliente;

public interface IClienteDao extends JpaRepository<Cliente	, Long>{
	
}
