/*
 * Remote interface implemented by Server1.
 * The method "displayUniversities" in the interface is used to display the different universities
 * in the state of Illinois. 
 * All the other methods obtain a stub of Server2. The stub of Server2 is used to invoke remote
 * methods found in Server2. The return values of methods in Server2 are passed to the methods in this 
 * interface(all methods apart from displayUniversities). These methods return the values back to Server1
 * The Server1 then return the values to caller in Client
 * 
 */
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

public interface ComputeUniversities extends Remote {
    <T> List<String> displayUniversities(DisplayUniversitiesTask<T> t) throws RemoteException;
	Map<String, String> displayUICDetails(UICInformation<Map<String, String>> task2)  throws RemoteException;
	Map<String, String> displayUIUCDetails(UIUCInformation<Map<String, String>> task2)  throws RemoteException;
	Map<String, String> displayUICEmployee(UICDepartmentEmployee<Map<String, String>> task3) throws RemoteException;
	Map<String, String> displayUIUCEmployee(UIUCDepartmentEmployee<Map<String, String>> task3) throws RemoteException;
	Map<String, String> displayUICPersonalInfo(UICEmployeeContactInfo<Map<String, String>> task4) throws RemoteException;
	Map<String, String> displayUIUCPersonalInfo(UIUCEmployeeContactInfo<Map<String, String>> task4) throws RemoteException;
}