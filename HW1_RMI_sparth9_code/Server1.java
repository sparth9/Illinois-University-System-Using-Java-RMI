/** Server1 contains  the remote methods that the Client invokes */
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Server1 implements ComputeUniversities {

    public Server1() {
        super();
    }

    //The remote method which displays the list of universities
    public <T> List<String> displayUniversities(DisplayUniversitiesTask<T> t) {
        return t.execute();
    }

    
    public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            String name = "GetUniversityName";
            Server1 engine = new Server1();
            ComputeUniversities stub =
                (ComputeUniversities) UnicastRemoteObject.exportObject(engine, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(name, stub);
            System.out.println("Server bound");
        } catch (Exception e) {
            System.err.println("Server1 exception!!!!!! :");
            e.printStackTrace();
        }
    }

    /************************************************************************************************
    *The remote method acts as a client and gets the stub of Server2.
    *The details of department in UIC is obtained upon invoking the remote method in Server2 and is 
    *passed to the Client.
    *************************************************************************************************/  
    
	public Map<String, String> displayUICDetails(UICInformation<Map<String, String>> task2) throws RemoteException {
		if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
   	 	Map<String, String> department = new HashMap<String,String>();
        try {
       	 	String name = "UIC";
            System.out.println("\n\tInside Server 1 which is the client to Server 2\n");
            Registry registry = LocateRegistry.getRegistry(1099);
            ComputeDepartment server2_stub= (ComputeDepartment) registry.lookup(name);   
            
            department = server2_stub.executeUICTask(task2);
          
            System.out.println("\tUIC Department Details : ");
        }        
        catch (Exception e) {
            System.err.println("Server1 exception!!!!!!!! :");
            e.printStackTrace();
        }
        return department;
	}
	
	
    /************************************************************************************************
    *The remote method acts as a client and gets the stub of Server2.
    *The details of department in UIUC is obtained upon invoking the remote method in Server2 and is 
    *passed to the Client.
    *************************************************************************************************/ 
	public Map<String, String> displayUIUCDetails(UIUCInformation<Map<String, String>> task2) throws RemoteException {
		if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
   	 	Map<String, String> department = new HashMap<String,String>();
        try {
       	 	String name = "UIUC";
            System.out.println("\n\tInside Server 1 which is the client to Server 2\n");
            Registry registry = LocateRegistry.getRegistry(1099);
            ComputeDepartment server2_stub= (ComputeDepartment) registry.lookup(name);   
            
            department = server2_stub.executeUIUCTask(task2);
          
            System.out.println("\tUIUC Department Details : ");
        }        
        catch (Exception e) {
            System.err.println("Server1 exception!!!!!!!! :");
            e.printStackTrace();
        }
        return department;
	}
	
	
    /******************************************************************************************************
    *The remote method acts as a client and gets the stub of Server2.
    *The details of employee of a department in UIC is obtained upon invoking the remote method in Server2 and is 
    *passed to the Client.
    *******************************************************************************************************/ 
	public Map<String, String> displayUICEmployee(UICDepartmentEmployee<Map<String, String>> task3) {
		if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
		
		Map<String, String> employee = new HashMap<String,String>();
		
		try {
       	 	String name = "UIC";
            System.out.println("\n\tInside Server 1 which is the client to Server 2\n");
            Registry registry = LocateRegistry.getRegistry(1099);
            ComputeEmployees server2_stub= (ComputeEmployees) registry.lookup(name);   
            employee = server2_stub.executeUICEmployeeTask(task3);
            System.out.println("\tUIC Employment Details : ");
            
        }        
        catch (Exception e) {
            System.err.println("Server1 exception!!!!!!!! :");
            e.printStackTrace();
        }
		return employee;
	}
	

    /***********************************************************************************************************
    *The remote method acts as a client and gets the stub of Server2.
    *The details of employee of a department in UIUC is obtained upon invoking the remote method in Server2 and is 
    *passed to the Client.
    ************************************************************************************************************/ 
	public Map<String, String> displayUIUCEmployee(UIUCDepartmentEmployee<Map<String, String>> task3) throws RemoteException {
		if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
		
		Map<String, String> employee = new HashMap<String,String>();
		
		try {
       	 	String name = "UIUC";
            System.out.println("\n\tInside Server 1 which is the client to Server 2\n");
            Registry registry = LocateRegistry.getRegistry(1099);
            ComputeEmployees server2_stub= (ComputeEmployees) registry.lookup(name);   
            employee = server2_stub.executeUIUCEmployeeTask(task3);
            System.out.println("\tUIUC Employment Details : ");
            
        }        
        catch (Exception e) {
            System.err.println("Server1 exception!!!!!!!! :");
            e.printStackTrace();
        }
		return employee;
	}

    /***********************************************************************************************************
    *The remote method acts as a client and gets the stub of Server2.
    *The details of employee's contact info for a department in UIC is obtained upon invoking the 
    *remote method in Server2 and is passed to the Client.
    ************************************************************************************************************/
	public Map<String, String> displayUICPersonalInfo(UICEmployeeContactInfo<Map<String, String>> task4) throws RemoteException {
		if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
		
		Map<String, String> contact = new HashMap<String,String>();
		
		try {
       	 	String name = "UIC";
            System.out.println("\n\tInside Server 1 which is the client to Server 2\n");
            Registry registry = LocateRegistry.getRegistry(1099);
            ComputePersonalInfo server2_stub= (ComputePersonalInfo) registry.lookup(name);   
            contact = server2_stub.executeUICPersonalInfoTask(task4);
            System.out.println("\tUIC Employee Personal Details : ");
        }        
        catch (Exception e) {
            System.err.println("Server1 exception!!!!!!!! :");
            e.printStackTrace();
        }
		return contact;	
	}


    /***********************************************************************************************************
    *The remote method acts as a client and gets the stub of Server2.
    *The details of employee's contact info for a department in UIUC is obtained upon invoking the remote
    *method in Server2 and is passed to the Client.
    ************************************************************************************************************/
	public Map<String, String> displayUIUCPersonalInfo(UIUCEmployeeContactInfo<Map<String, String>> task4) throws RemoteException {
		
		if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
		
		Map<String, String> contact = new HashMap<String,String>();
		
		try {
       	 	String name = "UIUC";
            System.out.println("\n\tInside Server 1 which is the client to Server 2\n");
            Registry registry = LocateRegistry.getRegistry(1099);
            ComputePersonalInfo server2_stub= (ComputePersonalInfo) registry.lookup(name);   
            contact = server2_stub.executeUIUCPersonalInfoTask(task4);
            System.out.println("\tUIUC Employee Personal Details : ");
        }        
        catch (Exception e) {
            System.err.println("Server1 exception!!!!!!!! :");
            e.printStackTrace();
        }
		return contact;
	}
}