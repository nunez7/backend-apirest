package edu.mx.utdelacosta.backend.apirest.models.services;

import edu.mx.utdelacosta.backend.apirest.models.entity.Usuario;

public interface IUsuarioService {
	public Usuario findByUsername(String username);
}
