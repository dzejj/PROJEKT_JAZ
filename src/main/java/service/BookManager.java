package service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import domain.Type;

@ApplicationScoped
public class BookManager {
	
	private List<Type> db = new ArrayList<Type>();

	public void addType(Type type) {
		Type newType = new Type();

		newType.setId_book(type.getId_book());
		newType.setAuthorfirstname (type.getAuthorfirstname ());
		newType.setAuthorlastname(type.getAuthorlastname());
		newType.setTitle(type.getTitle());
		


		db.add(newType);
	}
	//Edit person with given index
	public void editType(Type type) {
		for (Type s : db) {
			if (type.getId_book() == (s.getId_book())) {
				Type typeToRemove = s;
				db.remove(s);
				Type updatedType = new Type();
				if(type.getAuthorfirstname() == "") updatedType.setAuthorfirstname(typeToRemove.getAuthorfirstname());
				else updatedType.setAuthorfirstname(type.getAuthorfirstname());
				
				if(type.getAuthorlastname() == "") updatedType.setAuthorlastname(typeToRemove.getAuthorlastname());
				else updatedType.setAuthorlastname(type.getAuthorlastname());

				if(type.getTitle() == "") updatedType.setTitle(typeToRemove.getTitle());
				else updatedType.setTitle(type.getTitle());
				

				updatedType.setAuthorfirstname(type.getAuthorfirstname());
				updatedType.setAuthorlastname(type.getAuthorlastname());
				updatedType.setTitle(type.getTitle());
			
			
				break;
			}
		}
	}
		
	
	

	// Removes the person with given index
	public void deleteType(Type type) {
		Type typeToRemove = null;
		for (Type t : db) {
			if (type.getId_book() == (t.getId_book())) {
				typeToRemove = t;
				break;
			}
		}
		if (typeToRemove != null)
			db.remove(typeToRemove);
	}

	public List<Type> getAllTypes() {
		return db;
	}
}
