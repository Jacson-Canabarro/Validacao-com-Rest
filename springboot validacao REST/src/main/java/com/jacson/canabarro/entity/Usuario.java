package com.jacson.canabarro.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Usuario {
	
	
	@NotBlank(message="Digite o seu email")
	@Email(message="Insira um email válido")
	@Id
	private String email;
	@NotBlank(message="Digite o seu nome")
	@Size(min=2,message="Acho que seu nome está errado")
	private String nome;
	@NotBlank(message="Digite o sua senha")
	@Size(min=4,message="Senha fraca demais, utilize mais de 4 caracteres")
	private String senha;
	@NotBlank(message="Digite o sua idade")
	@Pattern(regexp="[\\d]{2}",message="idade inválida")
	private String idade;
	@NotBlank(message="Digite o numero do seu celular")
	@Pattern(regexp="[\\d]{9}", message="Celular inválido")
	private String telefone;
	
	public Usuario() {
	}
	
	
	public Usuario(String email, String nome, String senha, String idade, String telefone) {
		this.email = email;
		this.nome = nome;
		this.senha = senha;
		this.idade = idade;
		this.telefone = telefone;
	}


	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getIdade() {
		return idade;
	}
	public void setIdade(String idade) {
		this.idade = idade;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	

}
