package edu.mx.utdelacosta.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import edu.mx.utdelacosta.backend.apirest.models.entity.Factura;

public interface IFacturaDao extends CrudRepository<Factura, Long>{

}
