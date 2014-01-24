/*
 * Employee Contact Info for UIUC
 */
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class UIUCEmployeeContactInfo<T> implements DepartmentDetailsTask<T>, Serializable {

	private static final long serialVersionUID = 1L;

    private Map<String,String> contactInfo = new HashMap<String,String>();
    
    public UIUCEmployeeContactInfo(String i) {
    	if(i.equals("1")) {
            this.contactInfo.put("Prof. Donna Doe ", "312 123 4567");
            this.contactInfo.put("Prof. Juan Doe ", "312 123 4568");
            this.contactInfo.put("Prof. Frank Foe","312 123 4569");
    	}
    	else if(i.equals("2")) {
            this.contactInfo.put("Prof. Karren Koe ", "312 123 4570");
            this.contactInfo.put("Prof. Larry Loe", "312 123 4571");
            this.contactInfo.put("Prof. Marta Moe","312 123 4572");
    	}
    	if(i.equals("3")) {
            this.contactInfo.put("Prof. Jane Poe", "312 123 4573");
            this.contactInfo.put("Prof. Robert Roe", "312 123 4574");
            this.contactInfo.put("Prof. Mark Moe","312 123 4575");
    	}
    }

    public Map<String,String> execute() {
        return contactInfo;
    }
}