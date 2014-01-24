/**
 * Interface that is passed as an argument to the remote method which is used to 
 * display the information of departments and their corresponding buildings 
 *
 */
import java.util.Map;

public interface DepartmentDetailsTask<T> {
    Map<String,String> execute();
}