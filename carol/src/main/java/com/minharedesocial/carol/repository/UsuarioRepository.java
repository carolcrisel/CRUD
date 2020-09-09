package com.minharedesocial.carol.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minharedesocial.carol.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	public List<Usuario> findAllByNomeContainingIgnoreCase (String nome);
}
