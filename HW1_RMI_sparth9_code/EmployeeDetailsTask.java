/*
 * Interface that is used as an argument to the remote method
 * which is used to display the employee and their office information
 */
import java.util.Map;


public interface EmployeeDetailsTask<T> {
	Map<String, String> execute();
}