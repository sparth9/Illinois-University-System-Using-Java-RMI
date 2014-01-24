/*
 * Contains the information of UIC employees and their office information
 */
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class UICDepartmentEmployee<T> implements EmployeeDetailsTask<T>, Serializable {

	private static final long serialVersionUID = 1L;
	
	private Map<String, String> employee = new HashMap<String, String>();

    
    public UICDepartmentEmployee(String i) {
    	if(i .equals("3")) {
    		this.employee.put("Prof. Clement Yu" , "SEO 1000");
        	this.employee.put("Prof. Jakob Erikson", "SEO 1001");
        	this.employee.put("Prof. Mark Grechanik", "SEO 900");
    	}
    	if(i.equals("1")) {
    		this.employee.put("Prof. Sam Whalen " , "UIC Theatre 1000");
        	this.employee.put("Prof. Martha Hebert ", "UIC Theatre 1001");
        	this.employee.put("Prof. Steve Tozer", "UIC Theatre 900");
    	}
    	if(i.equals("2")) {
    		this.employee.put("Prof. Evelyn Behar  " , "BSB 1000");
        	this.employee.put("Prof. Dina Birman ", "BSB 1001");
        	this.employee.put("Prof. Courtney Bonam", "BSB 900");
    	}
    }

    public Map<String, String> execute() {

    	return this.employee;
    }
}