/*
 * Interface that is used as an argument to the remote method 
 * which is to display the employee and their contact information
 */
import java.util.Map;
public interface PersonalDetailsTask<T> {
	 Map<String,String> execute();
}