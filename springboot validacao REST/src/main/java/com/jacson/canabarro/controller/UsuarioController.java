package com.jacson.canabarro.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jacson.canabarro.entity.Usuario;
import com.jacson.canabarro.repository.UsuarioRepository;

@RestController
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	Map<String, String> erros;
	
	
	@PostMapping("/cadastrarUsuario")
	public ResponseEntity<Object> cadastrarUsuario(@RequestBody @Valid Usuario usuario, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			erros = new HashMap<>();
			for(FieldError error:bindingResult.getFieldErrors()){
				erros.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<>(erros, HttpStatus.NOT_ACCEPTABLE);
		}
		Usuario u = usuarioRepository.findByEmail(usuario.getEmail());
		if(u!=null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
			
		}
		return new ResponseEntity<>(usuarioRepository.save(usuario),HttpStatus.OK);
		
	}
	

}
