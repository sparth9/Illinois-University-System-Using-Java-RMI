/** Server 2 which has the remote methods to display information 
 * related to Departments and Employees */
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;

public class Server2 implements ComputeDepartment, ComputeEmployees, ComputePersonalInfo {

    public Server2() {
        super();
    }

    public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            String univ1_name = "UIC";
            String univ2_name = "UIUC";
            Server2 engine = new Server2();
            ComputeDepartment stub =
                (ComputeDepartment) UnicastRemoteObject.exportObject(engine, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(univ1_name, stub);
            registry.rebind(univ2_name, stub);
            System.out.println("Server2 bound");
        } catch (Exception e) {
            System.err.println("Server2 exception!!!!! :");
            e.printStackTrace();
        }
    }

    /**
     * remote methods to display UIC departments and buildings;
     * to display Employees and their offices;
     * to display Employees and their contact info
     */
	public Map<String, String> executeUICTask(UICInformation<Map<String, String>> t) throws RemoteException {
		return t.execute();
	}
	
	public Map<String, String> executeUIUCTask(UIUCInformation<Map<String, String>> t) throws RemoteException {
		return t.execute();
	}

	public Map<String, String> executeUICEmployeeTask(UICDepartmentEmployee<Map<String, String>> t) throws RemoteException {
		return t.execute();
	}

	public Map<String, String> executeUIUCEmployeeTask(UIUCDepartmentEmployee<Map<String, String>> t) throws RemoteException {
		return t.execute();
	}

	public Map<String, String> executeUICPersonalInfoTask(UICEmployeeContactInfo<Map<String, String>> t) throws RemoteException {
		
		return t.execute();
	}

	public Map<String, String> executeUIUCPersonalInfoTask(UIUCEmployeeContactInfo<Map<String, String>> t) throws RemoteException {
		
		return t.execute();
	}
	
	
	
}