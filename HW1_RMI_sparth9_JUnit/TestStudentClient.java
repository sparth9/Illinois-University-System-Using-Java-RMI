/*
 * The test file is used to verify the output of the remote methods
 */

import static org.junit.Assert.*;
import org.junit.Test;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;


//The test class TestStudentClient
public class TestStudentClient {

	@Test
	public void testUniversity() {

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		/** Looking up the registry for a particular service and obtain the stub to access remote methods  **/
		try {
			String name = "GetUniversityName";
			Registry registry = LocateRegistry.getRegistry(1099);

			//comp is the stub for the Server1. ComputeUniversities consists of the universities in Illinois 
			ComputeUniversities comp = (ComputeUniversities) registry.lookup(name); 

			UniversityInformation<List<String>> task1 = new UniversityInformation<List<String>>();
			List<String> universityInformationSystem = comp.displayUniversities(task1);

			List<String> expectedUniversities = new ArrayList<String>();
			expectedUniversities.add("UIC");
			expectedUniversities.add("UIUC");

			if(expectedUniversities.get(0).equals(universityInformationSystem.get(0)) && 
					expectedUniversities.get(1).equals(universityInformationSystem.get(1))) {
				assertTrue(true);
			}
			else
				assertTrue(false);
		}catch (Exception e) {
			System.err.println("Client exception!!!");
			e.printStackTrace();
		}
	}


	@Test
	public void testUICDepartment() {
		try {
			String name = "GetUniversityName";
			Registry registry = LocateRegistry.getRegistry(1099);

			//comp is the stub for the Server1. ComputeUniversities consists of the universities in Illinois 
			ComputeUniversities comp = (ComputeUniversities) registry.lookup(name); 
			UICInformation<Map<String,String>> task2 = new UICInformation<Map<String,String>>();
			Map<String,String> department = comp.displayUICDetails(task2);
			Map<String, String> testDepartment = new HashMap<String, String>();

			testDepartment.put("Computer Science", "Science and Engineering Office");
			testDepartment.put("Psychology", "Behavioral Sciences Building");
			testDepartment.put("College of Education","UIC Theatre");

			Set<String> values1 = new HashSet<String>(department.values());
			Set<String> values2 = new HashSet<String>(testDepartment.values());
			boolean equal = values1.equals(values2);

			if(equal) {
				assertTrue(true);
			}
			else
				assertTrue(false);

		}catch (Exception e) {
			System.err.println("Client exception!!!");
			e.printStackTrace();
		}
	}

	@Test
	public void testUIUCDepartment() {
		try {
			String name = "GetUniversityName";
			Registry registry = LocateRegistry.getRegistry(1099);

			//comp is the stub for the Server1. ComputeUniversities consists of the universities in Illinois 
			ComputeUniversities comp = (ComputeUniversities) registry.lookup(name); 
			UIUCInformation<Map<String,String>> task2 = new UIUCInformation<Map<String,String>>();
			Map<String,String> department = comp.displayUIUCDetails(task2);
			Map<String, String> testDepartment = new HashMap<String, String>();

			testDepartment.put("Computer Science", "Atkinson Hall");
			testDepartment.put("Psychology", "Chappel Hall");
			testDepartment.put("College of Education","Bell Hall");

			Set<String> values1 = new HashSet<String>(department.values());
			Set<String> values2 = new HashSet<String>(testDepartment.values());
			boolean equal = values1.equals(values2);

			if(equal) {
				assertTrue(true);
			}
			else
				assertTrue(false);

		}catch (Exception e) {
			System.err.println("Client exception!!!");
			e.printStackTrace();
		}
	}


	@Test
	public void testUICEmployee() {
		try {
			String name = "GetUniversityName";
			Registry registry = LocateRegistry.getRegistry(1099);

			//comp is the stub for the Server1. ComputeUniversities consists of the universities in Illinois 
			ComputeUniversities comp = (ComputeUniversities) registry.lookup(name); 
			UICDepartmentEmployee<Map<String,String>> task2 = new UICDepartmentEmployee<Map<String,String>>("1");
			Map<String,String> employee1 = comp.displayUICEmployee(task2);
			Map<String, String> testEmployee1 = new HashMap<String, String>();

			testEmployee1.put("Prof. Sam Whalen " , "UIC Theatre 1000");
			testEmployee1.put("Prof. Martha Hebert ", "UIC Theatre 1001");
			testEmployee1.put("Prof. Steve Tozer", "UIC Theatre 900");

			UICDepartmentEmployee<Map<String,String>> task3 = new UICDepartmentEmployee<Map<String,String>>("2");
			Map<String,String> employee2 = comp.displayUICEmployee(task3);
			Map<String, String> testEmployee2 = new HashMap<String, String>();


			testEmployee2.put("Prof. Evelyn Behar  " , "BSB 1000");
			testEmployee2.put("Prof. Dina Birman ", "BSB 1001");
			testEmployee2.put("Prof. Courtney Bonam", "BSB 900");

			UICDepartmentEmployee<Map<String,String>> task4 = new UICDepartmentEmployee<Map<String,String>>("3");
			Map<String,String> employee3 = comp.displayUICEmployee(task3);
			Map<String, String> testEmployee3 = new HashMap<String, String>();

			testEmployee3.put("Prof. Clement Yu" , "SEO 1000");
			testEmployee3.put("Prof. Jakob Erikson", "SEO 1001");
			testEmployee3.put("Prof. Mark Grechanik", "SEO 900");


			Set<String> values1 = new HashSet<String>(employee1.values());
			Set<String> values2 = new HashSet<String>(testEmployee1.values());


			Set<String> values3 = new HashSet<String>(employee2.values());
			Set<String> values4 = new HashSet<String>(testEmployee2.values());


			Set<String> values5 = new HashSet<String>(employee3.values());
			Set<String> values6 = new HashSet<String>(testEmployee3.values());
			boolean equal1 = values1.equals(values2);
			boolean equal2 = values3.equals(values4);
			boolean equal3 = values4.equals(values5);

			if(equal1 == true && equal2 == true && equal3 == true) {
				assertTrue(true);
			}
			else
				assertTrue(false);

		}catch (Exception e) {
			System.err.println("Client exception!!!");
			e.printStackTrace();
		}
	}


	@Test
	public void testUIUCEmployee() {
		try {
			String name = "GetUniversityName";
			Registry registry = LocateRegistry.getRegistry(1099);

			//comp is the stub for the Server1. ComputeUniversities consists of the universities in Illinois 
			ComputeUniversities comp = (ComputeUniversities) registry.lookup(name); 
			UIUCDepartmentEmployee<Map<String,String>> task2 = new UIUCDepartmentEmployee<Map<String,String>>("1");
			Map<String,String> employee1 = comp.displayUIUCEmployee(task2);
			Map<String, String> testEmployee1 = new HashMap<String, String>();

			testEmployee1.put("Prof. Jane Poe" , "Atkinson Hall 1000");
			testEmployee1.put("Prof. Robert Roe", "Atkinson Hall 1001");
			testEmployee1.put("Prof. Mark Moe", "Atkinson Hall 900");

			UIUCDepartmentEmployee<Map<String,String>> task3 = new UIUCDepartmentEmployee<Map<String,String>>("2");
			Map<String,String> employee2 = comp.displayUIUCEmployee(task3);
			Map<String, String> testEmployee2 = new HashMap<String, String>();


			testEmployee2.put("Prof. Donna Doe " , "Bell Hall 1000");
			testEmployee2.put("Prof. Juan Doe ", "Bell Hall 1001");
			testEmployee2.put("Prof. Frank Foe", "Bell Hall 900");

			UIUCDepartmentEmployee<Map<String,String>> task4 = new UIUCDepartmentEmployee<Map<String,String>>("3");
			Map<String,String> employee3 = comp.displayUIUCEmployee(task3);
			Map<String, String> testEmployee3 = new HashMap<String, String>();

			testEmployee3.put("Prof. Karren Koe  " , "Chappel Hall 1000");
			testEmployee3.put("Prof. Larry Loe ", "Chappel Hall 1001");
			testEmployee3.put("Prof. Marta Moe", "Chappel Hall 900");

			Set<String> values1 = new HashSet<String>(employee1.values());
			Set<String> values2 = new HashSet<String>(testEmployee1.values());

			Set<String> values3 = new HashSet<String>(employee2.values());
			Set<String> values4 = new HashSet<String>(testEmployee2.values());

			Set<String> values5 = new HashSet<String>(employee3.values());
			Set<String> values6 = new HashSet<String>(testEmployee3.values());
			boolean equal1 = values1.equals(values2);
			boolean equal2 = values3.equals(values4);
			boolean equal3 = values4.equals(values5);

			if(equal1 == true && equal2 == true && equal3 == true) {
				assertTrue(true);
			}
			else
				assertTrue(false);

		}catch (Exception e) {
			System.err.println("Client exception!!!");
			e.printStackTrace();
		}
	}


	@Test
	public void testUICEmployeeContact() {
		try {

			String name = "GetUniversityName";
			Registry registry = LocateRegistry.getRegistry(1099);

			//comp is the stub for the Server1. ComputeUniversities consists of the universities in Illinois 
			ComputeUniversities comp = (ComputeUniversities) registry.lookup(name); 
			UICDepartmentEmployee<Map<String, String>> task1 = new UICDepartmentEmployee<Map<String, String>>("1");
			Map<String, String> employee1 = comp.displayUICEmployee(task1);

			UICDepartmentEmployee<Map<String, String>> task2 = new UICDepartmentEmployee<Map<String, String>>("2");
			Map<String, String> employee2 = comp.displayUICEmployee(task2);

			UICDepartmentEmployee<Map<String, String>> task3 = new UICDepartmentEmployee<Map<String, String>>("3");
			Map<String, String> employee3 = comp.displayUICEmployee(task3);

			Map<String, String> testuicEmployee1 = new HashMap<String, String>();
			Map<String, String> testuicEmployee2 = new HashMap<String, String>();
			Map<String, String> testuicEmployee3 = new HashMap<String, String>();


			testuicEmployee1.put("Prof. Sam Whalen" , "312 123 4553");
			testuicEmployee1.put("Prof. Martha Hebert", "312 123 4554");
			testuicEmployee1.put("Prof. Steve Tozer", "312 123 4555");  

			testuicEmployee3.put("Prof. Clement Yu" , "312 123 4556");
			testuicEmployee3.put("Prof. Jakob Erikson", "312 123 4557");
			testuicEmployee3.put("Prof. Mark Grechanik", "312 123 4558");

			testuicEmployee2.put("Prof. Evelyn Behar", "312 123 4559");
			testuicEmployee2.put("Prof. Dina Birman", "312 123 4560");
			testuicEmployee2.put("Prof. Courtney Bonam","312 123 4561");

			Set<String> values1 = new HashSet<String>(employee1.values());
			Set<String> values2 = new HashSet<String>(testuicEmployee1.values());

			Set<String> values3 = new HashSet<String>(employee2.values());
			Set<String> values4 = new HashSet<String>(testuicEmployee2.values());

			Set<String> values5 = new HashSet<String>(employee3.values());
			Set<String> values6 = new HashSet<String>(testuicEmployee3.values());

			boolean equal1 = values1.equals(values2);
			boolean equal2 = values3.equals(values4);
			boolean equal3 = values4.equals(values5);

			if(equal1 == true && equal2 == true && equal3 == true) {
				assertTrue(true);
			}
			else
				assertTrue(false);

		}catch (Exception e) {
			System.err.println("Client exception!!!");
			e.printStackTrace();
		}
	}
	
	@Test
	public void testUIUCEmployeeContact() {
		try {

			String name = "GetUniversityName";
			Registry registry = LocateRegistry.getRegistry(1099);

			//comp is the stub for the Server1. ComputeUniversities consists of the universities in Illinois 
			ComputeUniversities comp = (ComputeUniversities) registry.lookup(name); 
			UIUCDepartmentEmployee<Map<String, String>> task1 = new UIUCDepartmentEmployee<Map<String, String>>("1");
			Map<String, String> employee1 = comp.displayUIUCEmployee(task1);

			UIUCDepartmentEmployee<Map<String, String>> task2 = new UIUCDepartmentEmployee<Map<String, String>>("2");
			Map<String, String> employee2 = comp.displayUIUCEmployee(task2);

			UIUCDepartmentEmployee<Map<String, String>> task3 = new UIUCDepartmentEmployee<Map<String, String>>("3");
			Map<String, String> employee3 = comp.displayUIUCEmployee(task3);

			Map<String, String> testuiucEmployee1 = new HashMap<String, String>();
			Map<String, String> testuiucEmployee2 = new HashMap<String, String>();
			Map<String, String> testuiucEmployee3 = new HashMap<String, String>();


			testuiucEmployee1.put("Prof. Sam Whalen" , "312 123 4553");
			testuiucEmployee1.put("Prof. Martha Hebert", "312 123 4554");
			testuiucEmployee1.put("Prof. Steve Tozer", "312 123 4555");  

			testuiucEmployee3.put("Prof. Clement Yu" , "312 123 4556");
			testuiucEmployee3.put("Prof. Jakob Erikson", "312 123 4557");
			testuiucEmployee3.put("Prof. Mark Grechanik", "312 123 4558");

			testuiucEmployee2.put("Prof. Evelyn Behar", "312 123 4559");
			testuiucEmployee2.put("Prof. Dina Birman", "312 123 4560");
			testuiucEmployee2.put("Prof. Courtney Bonam","312 123 4561");

			Set<String> values1 = new HashSet<String>(employee1.values());
			Set<String> values2 = new HashSet<String>(testuiucEmployee1.values());

			Set<String> values3 = new HashSet<String>(employee2.values());
			Set<String> values4 = new HashSet<String>(testuiucEmployee2.values());

			Set<String> values5 = new HashSet<String>(employee3.values());
			Set<String> values6 = new HashSet<String>(testuiucEmployee3.values());

			boolean equal1 = values1.equals(values2);
			boolean equal2 = values3.equals(values4);
			boolean equal3 = values4.equals(values5);

			if(equal1 == true && equal2 == true && equal3 == true) {
				assertTrue(true);
			}
			else
				assertTrue(false);

		}catch (Exception e) {
			System.err.println("Client exception!!!");
			e.printStackTrace();
		}
	}
}











