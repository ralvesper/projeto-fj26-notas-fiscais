package br.com.caelum.notasfiscais.modelo;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.caelum.notasfiscais.dao.DAO;

public class DataModelNotasFiscais extends LazyDataModel {


	@Override
	public List<NotaFiscal> load(int inicio, int quantidade, String campoOrdenacao, SortOrder sentidoOrdenacao, Map filtros) {
		DAO<NotaFiscal> dao = new DAO<NotaFiscal>(NotaFiscal.class);
		return dao.listaTodosPaginada(inicio, quantidade);

	}
}