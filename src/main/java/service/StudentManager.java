package service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import domain.Student;

@ApplicationScoped
public class StudentManager {
	
	private List<Student> db = new ArrayList<Student>();

	public void addStudent(Student student) {
		Student newStudent = new Student();

		newStudent.setAlbum_id(student.getAlbum_id());
		newStudent.setFirstName(student.getFirstName());
		newStudent.setLastName(student.getLastName());
		newStudent.setZipCode(student.getZipCode());
		newStudent.setTown(student.getTown());
		newStudent.setPin(student.getPin());
		newStudent.setDateOfBirth(student.getDateOfBirth());


		db.add(newStudent);
	}
	//Edit person with given index
	public void editStudent(Student student) {
		for (Student s : db) {
			if (student.getAlbum_id() == (s.getAlbum_id())) {
				Student studentToRemove = s;
				db.remove(s);
				Student updatedStudent = new Student();
				if(student.getFirstName() == "") updatedStudent.setFirstName(studentToRemove.getFirstName());
				else updatedStudent.setFirstName(student.getFirstName());
				
				if(student.getLastName() == "") updatedStudent.setLastName(studentToRemove.getLastName());
				else updatedStudent.setLastName(student.getLastName());
				
				if(student.getZipCode() == "") updatedStudent.setZipCode(studentToRemove.getZipCode());
				else updatedStudent.setZipCode(student.getZipCode());
				
				if(student.getTown() == "") updatedStudent.setTown(studentToRemove.getTown());
				else updatedStudent.setTown(student.getTown());
				
				if(student.getPin() == "") updatedStudent.setPin(studentToRemove.getPin());
				else updatedStudent.setPin(student.getPin());
				
				//if(student.getDateOfBirth() == "") updatedStudent.setDateOfBirth(studentToRemove.getDateOfBirth());
				//else updatedStudent.setDateOfBirth(student.getDateOfBirth());
				
				updatedStudent.setLastName(student.getLastName());
				updatedStudent.setZipCode(student.getZipCode());
				updatedStudent.setTown(student.getTown());
				updatedStudent.setPin(student.getPin());
				updatedStudent.setDateOfBirth(student.getDateOfBirth());
				break;
			}
		}
	}
		
	
	

	// Removes the person with given index
	public void deleteStudent(Student student) {
		Student studentToRemove = null;
		for (Student s : db) {
			if (student.getAlbum_id() == (s.getAlbum_id())) {
				studentToRemove = s;
				break;
			}
		}
		if (studentToRemove != null)
			db.remove(studentToRemove);
	}

	public List<Student> getAllStudents() {
		return db;
	}
}
