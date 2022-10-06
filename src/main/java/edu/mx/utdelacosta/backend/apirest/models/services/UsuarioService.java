package edu.mx.utdelacosta.backend.apirest.models.services;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mx.utdelacosta.backend.apirest.models.dao.IUsuarioDao;
import edu.mx.utdelacosta.backend.apirest.models.entity.Usuario;

@Service
public class UsuarioService implements UserDetailsService, IUsuarioService{
	private Logger logger = LoggerFactory.getLogger(UsuarioService.class);
	
	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioDao.findByUsername(username);
		if(usuario==null) {
			logger.error("Error en el login: no existe el usuario '"+username+"'!");
			throw new UsernameNotFoundException("Error en el login: no existe el usuario '"+username+"'!");
		}
		
		//Obtenemos los roles y los convertimos
		List<GrantedAuthority> authorities = usuario.getRoles()
				.stream().map(role -> new SimpleGrantedAuthority(role.getNombre()))
				.collect(Collectors.toList());
		
		return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true,  authorities);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findByUsername(String username) {
		// TODO Auto-generated method stub
		return usuarioDao.findByUsername(username);
	}

}
