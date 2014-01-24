/*
 * Department and Building info at UIUC
 */
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class UIUCInformation<T> implements DepartmentDetailsTask<T>, Serializable {

	private static final long serialVersionUID = 1L;

    private Map<String,String> department = new HashMap<String,String>();
    
    public UIUCInformation() {
        this.department.put("Computer Science", "Atkinson Hall");
        this.department.put("Psychology", "Chappel Hall");
        this.department.put("College of Education","Bell Hall");
    }

    public Map<String,String> execute() {
        return department;
    }
}