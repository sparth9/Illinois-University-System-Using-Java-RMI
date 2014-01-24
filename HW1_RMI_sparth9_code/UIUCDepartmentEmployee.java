/*
 * Contains information about UICU employees and their office information
 */
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class UIUCDepartmentEmployee<T> implements PersonalDetailsTask<T>, Serializable {

	private static final long serialVersionUID = 1L;
	
	private Map<String, String> employee = new HashMap<String, String>();
	
	 public UIUCDepartmentEmployee(String i) {
	    	if(i .equals("3")) {
	    		this.employee.put("Prof. Jane Poe" , "Atkinson Hall 1000");
	        	this.employee.put("Prof. Robert Roe", "Atkinson Hall 1001");
	        	this.employee.put("Prof. Mark Moe", "Atkinson Hall 900");
	    	}
	    	if(i.equals("1")) {
	    		this.employee.put("Prof. Donna Doe " , "Bell Hall 1000");
	        	this.employee.put("Prof. Juan Doe ", "Bell Hall 1001");
	        	this.employee.put("Prof. Frank Foe", "Bell Hall 900");
	    	}
	    	if(i.equals("2")) {
	    		this.employee.put("Prof. Karren Koe  " , "Chappel Hall 1000");
	        	this.employee.put("Prof. Larry Loe ", "Chappel Hall 1001");
	        	this.employee.put("Prof. Marta Moe", "Chappel Hall 900");
	    	}
	    }
    
    public Map<String, String> execute() {

    	return this.employee;
    }
}