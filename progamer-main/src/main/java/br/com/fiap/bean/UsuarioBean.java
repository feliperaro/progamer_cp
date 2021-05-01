package br.com.fiap.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.fiap.dao.UsuarioDao;
import br.com.fiap.model.Usuario;

@Named
@RequestScoped
public class UsuarioBean {

	private Usuario usuario = new Usuario();

	public void save() {
		new UsuarioDao().save(this.usuario);
		System.out.println("Salvando Usuário... " + this.usuario);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário cadastrado com sucesso"));
	}

	public List<Usuario> getUsuarios() {
		List<Usuario> usuarios = new UsuarioDao().getAll();

		if (usuarios.isEmpty() || usuario == null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não há usuário cadastrado!"));
		}

		return new UsuarioDao().getAll();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
