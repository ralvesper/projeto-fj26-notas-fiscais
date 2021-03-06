package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.validation.ValidationException;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.modelo.Produto;

@ManagedBean
@ViewScoped
public class ProdutoBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Produto produto = new Produto();
	
	private List<Produto> produtos = null;
	
	private double somatorio = 0.0;

	public double getSomatorio() {
		return somatorio;
	}

	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public List<Produto> getProdutos() {
		if (this.produtos == null){
			DAO<Produto> dao = new DAO<Produto>(Produto.class);
			this.produtos = dao.listaTodos();
			
			calcularSomatorio();
			
		}
		return this.produtos;
	}

	private void calcularSomatorio() {
		somatorio = 0;
		for (Produto p: this.produtos){
			somatorio += p.getPreco().doubleValue();
		}
	}

	public void grava() {
		DAO<Produto> dao = new DAO<Produto>(Produto.class);
		
		if (this.produto == null){
			dao.adiciona(this.produto);			
		}else{
			dao.atualiza(this.produto);
		}
		this.produtos.add(this.produto);
		
		calcularSomatorio();
		
		this.produto = new Produto();
		this.produtos = dao.listaTodos();
		
	}
	
	public void remove(Produto produto) {
		DAO<Produto> dao = new DAO<Produto>(Produto.class);
		dao.remove(produto);
		this.produtos = dao.listaTodos();
		somatorio -= produto.getPreco().doubleValue();
	}
	
	public void comecaComMaiuscula(FacesContext fc, UIComponent component, Object value) throws ValidationException{
		String valor = value.toString();
		if (!valor.matches("[A-Z].*")){
			throw new ValidatorException( new FacesMessage("Deveria começar com maiúscula"));
		} 
	}
	
	
}
