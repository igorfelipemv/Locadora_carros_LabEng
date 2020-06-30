package br.com.locadora.carros.model;

public class Usuario {
	private String login;
	private String senha;
	private String perfil;
	
	public Usuario () {
		
	}
	
	public String getLogin() {
	    return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getSenha() {
	   return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getPerfil() {
	    return perfil;
	}
	
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
}
