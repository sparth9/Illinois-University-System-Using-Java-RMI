/*
 * Interface containing remote method to display Department and Building information
 * for UIC and UIC. This interface is implemented by  Server2
 */
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

public interface ComputeDepartment extends Remote {
	Map<String,String> executeUICTask(UICInformation<Map<String, String>> t) throws RemoteException;
	Map<String,String> executeUIUCTask(UIUCInformation<Map<String, String>> t) throws RemoteException;
}