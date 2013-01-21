package domain;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Book{
	
	private String authorfirstname = "";
	private String authorlastname = "";
	private String title = "";
	

	public String getAuthorfirstname () {
		return authorfirstname ;
	}
	
	public void setAuthorfirstname (String authorfirstname ) {
		this.authorfirstname  = authorfirstname ;
	}
	
	@Size(min = 2, max = 20)
	public String getAuthorlastname() {
		return authorlastname;
	}
	public void setAuthorlastname(String authorlastname) {
		this.authorlastname = authorlastname;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
	
}
