package com.demo.prime.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.demo.prime.domain.Grupo;
import com.demo.prime.domain.Usuario;
import com.demo.prime.service.UsuarioService;

public class AppUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UsuarioService usuarioService;
	
	private BCryptPasswordEncoder passwordEncoder;
	
	public AppUserDetailsService(BCryptPasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		BCryptPasswordEncoder encoder = passwordEncoder;
		
		Usuario usuario = usuarioService.findByEmail(email);
		
		UsuarioSistema user = null;
		
		if (usuario != null) {
			usuario.setSenha(encoder.encode(usuario.getSenha()));
			user = new UsuarioSistema(usuario, getGrupos(usuario));
		} else {
			throw new UsernameNotFoundException("Usuário não encontrado.");
		}
		
		return user;
	}
	
	private Collection<? extends GrantedAuthority> getGrupos(Usuario usuario) {
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		
		for (Grupo grupo : usuario.getGrupos()) {
			authorities.add(new SimpleGrantedAuthority("ROLE_" + grupo.getNome().toUpperCase()));
		}
		
		return authorities;
	}

}
