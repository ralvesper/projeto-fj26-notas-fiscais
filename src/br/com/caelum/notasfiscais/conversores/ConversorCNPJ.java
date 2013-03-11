package br.com.caelum.notasfiscais.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.caelum.stella.format.CNPJFormatter;

@FacesConverter("cnpj")
public class ConversorCNPJ implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String valor) {
		if (valor != null && valor.length() > 0){
			return new CNPJFormatter().unformat(valor);
		}
		return valor;
		
	}

	@Override
	public String getAsString(FacesContext contet, UIComponent component, Object valor) {
		return new CNPJFormatter().format(valor.toString());
	}
	
}
