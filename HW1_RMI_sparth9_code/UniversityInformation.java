/*
 * Illinois University information list
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class UniversityInformation<T> implements DisplayUniversitiesTask<T>, Serializable {

	private static final long serialVersionUID = 1L;
	
    private String universityName1;
    private String universityName2;
    List<String> universityList = new ArrayList<String>();
    
    public UniversityInformation() {
        this.universityName1 = "UIC";
        this.universityName2="UIUC";
        universityList.add(universityName1);
        universityList.add(universityName2);
    }

    public List<String> execute() {
        return universityList;
    }
}