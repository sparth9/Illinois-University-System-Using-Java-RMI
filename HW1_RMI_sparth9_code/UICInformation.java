/*
 * Class containing the inforamtion about the departments and their buildings in UIC
 */
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class UICInformation<T> implements DepartmentDetailsTask<T>, Serializable {

	private static final long serialVersionUID = 1L;

    private Map<String,String> department = new HashMap<String,String>();
    
    public UICInformation() {
        this.department.put("Computer Science", "Science and Engineering Office");
        this.department.put("Psychology", "Behavioral Sciences Building");
        this.department.put("College of Education","UIC Theatre");
    }

    public Map<String,String> execute() {
        return department;
    }
}