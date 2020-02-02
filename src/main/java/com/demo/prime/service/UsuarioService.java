package com.demo.prime.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.prime.domain.Usuario;
import com.demo.prime.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario findByEmail(String email) {
		return usuarioRepository.findByEmail(email).get();
	}
	
}
