/*
 * Interface that is used as an argument for the remote method 
 * which is used to display all the universities in Illinois
 */
import java.util.List;

public interface DisplayUniversitiesTask<T> {
    List<String> execute();
}