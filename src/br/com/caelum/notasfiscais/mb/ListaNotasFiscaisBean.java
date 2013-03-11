package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

import org.primefaces.model.LazyDataModel;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.modelo.DataModelNotasFiscais;
import br.com.caelum.notasfiscais.modelo.NotaFiscal;

@ManagedBean
public class ListaNotasFiscaisBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public ListaNotasFiscaisBean() {
		this.dataModel = new DataModelNotasFiscais();
		
		DAO<NotaFiscal> dao = new DAO<NotaFiscal>(NotaFiscal.class);
		this.dataModel.setRowCount(dao.contaTodos());
	}
	
	private LazyDataModel<NotaFiscal> dataModel;
	

	public LazyDataModel<NotaFiscal> getDataModel() {
		return dataModel;
	}

	public void setDataModel(LazyDataModel<NotaFiscal> dataModel) {
		this.dataModel = dataModel;
	}
	

}
