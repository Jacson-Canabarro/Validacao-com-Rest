package com.jacson.canabarro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacson.canabarro.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String>  {

	Usuario findByEmail(String email);

	
	
}
