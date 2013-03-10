package br.com.caelum.notasfiscais.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.caelum.notasfiscais.dao.UsuarioDAO;
import br.com.caelum.notasfiscais.modelo.Usuario;

@SessionScoped
@ManagedBean
public class UsuarioBean {

	private Usuario usuario = new Usuario();

	public Usuario getUsuario() {
		return this.usuario;
	}

	public String efetuaLogin() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
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
