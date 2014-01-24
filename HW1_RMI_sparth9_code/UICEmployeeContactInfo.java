/*
 * Class contains information about UIC employees and their contact details 
 */
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class UICEmployeeContactInfo<T> implements PersonalDetailsTask<T>, Serializable {

	private static final long serialVersionUID = 1L;

    private Map<String,String> contactInfo = new HashMap<String,String>();
    
    public UICEmployeeContactInfo(String i) {
    	if(i.equals("1")) {
    		this.contactInfo.put("Prof. Sam Whalen" , "312 123 4553");
        	this.contactInfo.put("Prof. Martha Hebert", "312 123 4554");
        	this.contactInfo.put("Prof. Steve Tozer", "312 123 4555");    	
        }
    	else if(i.equals("3")) {
    		this.contactInfo.put("Prof. Clement Yu" , "312 123 4556");
        	this.contactInfo.put("Prof. Jakob Erikson", "312 123 4557");
        	this.contactInfo.put("Prof. Mark Grechanik", "312 123 4558");
    	}
    	if(i.equals("2")) {
            this.contactInfo.put("Prof. Evelyn Behar", "312 123 4559");
            this.contactInfo.put("Prof. Dina Birman", "312 123 4560");
            this.contactInfo.put("Prof. Courtney Bonam","312 123 4561");
    	}
    }

    public Map<String,String> execute() {
        return contactInfo;
    }
}