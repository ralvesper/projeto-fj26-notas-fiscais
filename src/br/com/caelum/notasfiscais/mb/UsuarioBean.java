package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.notasfiscais.dao.UsuarioDAO;
import br.com.caelum.notasfiscais.modelo.Usuario;


@Named @SessionScoped
public class UsuarioBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject
	UsuarioDAO usuarioDAO;

	private Usuario usuario = new Usuario();

	public Usuario getUsuario() {
		return this.usuario;
	}

	public String efetuaLogin() {
		
		boolean loginValido = usuarioDAO.existe(this.usuario);
		System.out.println("O login era valido? " + loginValido);

		if (loginValido) {
			return "produto?faces-redirect=true";
		}

		this.usuario = new Usuario();
		return "login";

	}

	public String efetuarLogoff() {
		this.usuario = new Usuario();
		return "login?faces-redirect=true";
	}

	public boolean isUsuarioLogado() {
		return this.usuario.getLogin() != null;
	}

}
