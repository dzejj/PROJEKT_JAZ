package web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;

import service.BookManager;

import domain.Type;


@SessionScoped
@Named("bookBean")
public class BookFormBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Type type = new Type();

	private ListDataModel<Type> types = new ListDataModel<Type>();
	
	@Inject
	private BookManager bm;

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public ListDataModel<Type> getAllTypes() {
		types.setWrappedData(bm.getAllTypes());
		return types;
	}

	// Actions
	public String addType() {
		bm.addType(type);
		return "showTypes";
	}
	public String addEdit() {
		bm.editType(type);
		return "showTypes";
	}
	public String correctType(){
		return "addType";      //addstudent
	}
	
	
	public String dataType(){
		return "dataType"; //data student
	}
	public String dataEditType(){
		return "dataEditType"; //data edit
	}

	
	public String editType(){
	bm.editType(type);
	return "addType"; //add student
	}
	
	public String deleteType() {
		Type typeToDelete = types.getRowData();
		bm.deleteType(typeToDelete);
		return null;
	}
	
	public void uniqueIndeks(FacesContext context, UIComponent component,
			Object value) {
		
		int id_book = (Integer) value;

		for (Type type : bm.getAllTypes()) {
			if (type.getId_book() == id_book) {
				
				FacesMessage message = new FacesMessage(
						"Książka o takim indeksie juz istnieje");
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(message);
			}
		}
	}


}
