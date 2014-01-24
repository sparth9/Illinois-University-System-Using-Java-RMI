/*
 * Remote interface containing remote method that is implemented by Server2.
 * Remote interface is used by Server2 to display Employee and their corresponding 
 * department info
 */
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

public interface ComputeEmployees extends Remote {
	Map<String, String> executeUICEmployeeTask(UICDepartmentEmployee<Map<String, String>> t) throws RemoteException;
	Map<String, String> executeUIUCEmployeeTask(UIUCDepartmentEmployee<Map<String, String>> t) throws RemoteException;
}