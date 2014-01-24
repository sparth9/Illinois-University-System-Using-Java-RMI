/*
 * Remote interface implemented by Server2 to display employee and
 * their contact information based on the department
 */
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

public interface ComputePersonalInfo extends Remote  {
	Map<String,String> executeUICPersonalInfoTask(UICEmployeeContactInfo<Map<String, String>> t) throws RemoteException;
	Map<String,String> executeUIUCPersonalInfoTask(UIUCEmployeeContactInfo<Map<String, String>> t) throws RemoteException;
}