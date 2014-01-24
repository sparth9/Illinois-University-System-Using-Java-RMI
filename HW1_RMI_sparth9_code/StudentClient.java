/************************************************************************************************************* 
 * The Client is a student who tries to access the information related to universities in Illinois
 * 
 * The student can check the department and their corresponding buildings for different universities.
 * Based on the university, the client can check employee and their department details.
 * Based on the department, the client can check the contact details of employees
 * **********************************************************************************************************/


import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class StudentClient {
    public static void main(String args[]) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        /** Looking up the registry for a particular service and obtain the stub to access remote methods  **/
        try {
            String name = "GetUniversityName";
            System.out.println("\n\tInside Student Client Class\n");
            Registry registry = LocateRegistry.getRegistry(1099);

            //comp is the stub for the Server1. ComputeUniversities consists of the universities in Illinois 
            ComputeUniversities comp = (ComputeUniversities) registry.lookup(name); 
            
            UniversityInformation<List<String>> task1 = new UniversityInformation<List<String>>();
            List<String> universityInformationSystem = comp.displayUniversities(task1);
            
            /*****Getting user input and displaying university specific details based on user input****/
            while(true) {
            	
            	System.out.println("\t\t ILLINOIS UNIVERSITIES");
                
                System.out.println("\t-----------------------------------------------");
                System.out.println();
                for(String s: universityInformationSystem) {
                	System.out.println("\t\t"+  "(*) "+ s);
                }
                System.out.println("\t\t" + "(*)"+ " QUIT");
                System.out.println();
                System.out.println("\t-----------------------------------------------");
                System.out.println("\n\n");
                System.out.println("\tType \"1\" for UIC,  \"2\" for UIUC, \"3\" for Quitting ");

            	Scanner user_input_scanner = new Scanner(System.in);
            	String userInput  = user_input_scanner.next();

            	//Display Department, building, employee information related to UIC
            	if(userInput.equals("1")) {
            		UICInformation<Map<String,String>> task2 = new UICInformation<Map<String,String>>();
            		Map<String,String> department = comp.displayUICDetails(task2);
            		
            		System.out.println("\n\tUIC Department" + "\t\t\t\t UIC Building");
            		System.out.println("\t____________________________________________________________________\n");
            		for(Map.Entry<String,String> entry : department.entrySet()) {
            			System.out.printf("\t%-30s \t\t%-30s %n", entry.getKey(), entry.getValue());
            			System.out.println();
            		}
            		System.out.println();
            		
            		//Display information related to various departments in UIC
            		while(true) {
            			System.out.println("Enter \n\t\"1\" for College of Education, \n\t\"2\" for Psychology, \n\t\"3\" for Computer Science, \n\t\"4\" to return to main menu, \n\t\"5\" to exit");
            			String departmentInput  = user_input_scanner.next();
            			
            			//Display information of employee name and their offices for College of Education
            			if(departmentInput.equals("1")) {
            				UICDepartmentEmployee<Map<String, String>> task3 = new UICDepartmentEmployee<Map<String, String>>(departmentInput);
            				Map<String, String> uicEmployee = comp.displayUICEmployee(task3);
                    		System.out.println("\n\tUIC Employee" + "\t\t\t\tUIC College of Education");
                    		System.out.println("\t______________________________________________________________________");
                    		
                    		for(Map.Entry<String,String> entry : uicEmployee.entrySet()) {
                    			System.out.printf("\t%-30s \t\t%-30s %n",entry.getKey(), entry.getValue());
                    			System.out.println();
                    		}
                    		System.out.println();
                    		
                    		//Display information of employees and their contact details in the college of education in UIC
                    		while(true) {
                    			System.out.println("Enter \n\t\"1\" to UIC College of Education Employee's Info, or \n\t\"2\" to go back to the previous menu ");
                    			String employeeInput  = user_input_scanner.next();
                    			
                    			if(employeeInput.equals("1")) {
                    				UICEmployeeContactInfo<Map<String, String>> task4 = new UICEmployeeContactInfo<Map<String, String>>(employeeInput);
                    				Map<String, String> uicContactInfo = comp.displayUICPersonalInfo(task4);
                    				System.out.println("\tUIC College of Education Employee" + "\tUIC Phone Number");
                            		System.out.println("\t______________________________________________________________________");
                            		
                            		for(Map.Entry<String,String> entry : uicContactInfo.entrySet()) {
                            			System.out.printf("\t%-30s \t\t%-30s %n",entry.getKey(), entry.getValue());
                            			System.out.println();
                            		}
                            		System.out.println();	
                    			}
                    			
                    			if(employeeInput.equals("2")) {
                    				break;
                    			}
                    		}

            			}
            			
            			//Display information of the Employees of Psychology Department and their offices
            			if(departmentInput.equals("2")) {
            				UICDepartmentEmployee<Map<String, String>> task3 = new UICDepartmentEmployee<Map<String, String>>(departmentInput);
            				Map<String, String> uicEmployee = comp.displayUICEmployee(task3);
                    		System.out.println("\tUIC Employee" + "\t\t\t\tUIC Department of Psychology");
                    		System.out.println("\t______________________________________________________________________");
                    		
                    		for(Map.Entry<String,String> entry : uicEmployee.entrySet()) {
                    			System.out.printf("\t%-30s \t\t%-30s %n",entry.getKey(), entry.getValue());
                    			System.out.println();
                    		}
                    		System.out.println();
                    		
                    		//Display information of Employee contact details for the Department of Psychology
                    		while(true) {
                    			System.out.println("Enter \n\t\"2\" to check UIC Employee Dept. of Psychology Info, or \n\t\"3\" to go back to the previous menu ");
                    			String employeeInput  = user_input_scanner.next();
                    			
                    			if(employeeInput.equals("2")) {
                    				UICEmployeeContactInfo<Map<String, String>> task4 = new UICEmployeeContactInfo<Map<String, String>>(employeeInput);
                    				Map<String, String> uicContactInfo = comp.displayUICPersonalInfo(task4);
                    				System.out.println("\tUIC Dept. of Psychology Employee" + "\tUIC Phone Number");
                            		System.out.println("\t______________________________________________________________________");
                            		
                            		for(Map.Entry<String,String> entry : uicContactInfo.entrySet()) {
                            			System.out.printf("\t%-30s \t\t%-30s %n",entry.getKey(), entry.getValue());
                            			System.out.println();
                            		}
                            		System.out.println();	
                    			}
                    			
                    			if(employeeInput.equals("3")) {
                    				break;
                    			}
                    		}
            			}
            			
            			//Display information of employee of Computer Science Department and their offices
              			if(departmentInput.equals("3")) {
            				UICDepartmentEmployee<Map<String, String>> task3 = new UICDepartmentEmployee<Map<String, String>>(departmentInput);
            				Map<String, String> uicEmployee = comp.displayUICEmployee(task3);
                    		System.out.println("\tUIC Employee" + "\t\t\t\tUIC Computer Science Department");
                    		System.out.println("\t______________________________________________________________________");
                    		
                    		for(Map.Entry<String,String> entry : uicEmployee.entrySet()) {
                    			System.out.printf("\t%-30s \t\t%-30s %n",entry.getKey(), entry.getValue());
                    			System.out.println();
                    		}
                    		System.out.println();
                    		
                    		//Display the employee and their contact details for the computer science department
                    		while(true) {
                    			System.out.println("Enter \n\t\"3\" to check UIC Computer Science Employee Information, or \n\t\"4\" to go back to the previous menu ");
                    			String employeeInput  = user_input_scanner.next();
                    			
                    			if(employeeInput.equals("3")) {
                    				UICEmployeeContactInfo<Map<String, String>> task4 = new UICEmployeeContactInfo<Map<String, String>>(employeeInput);
                    				Map<String, String> uicContactInfo = comp.displayUICPersonalInfo(task4);
                    				System.out.println("\tUIC Computer Science Employee" + "\t\tUIC Phone Number");
                            		System.out.println("\t______________________________________________________________________");
                            		
                            		for(Map.Entry<String,String> entry : uicContactInfo.entrySet()) {
                            			System.out.printf("\t%-30s \t\t%-30s %n",entry.getKey(), entry.getValue());
                            			System.out.println();
                            		}
                            		System.out.println();	
                    			}
                    			
                    			if(employeeInput.equals("4")) {
                    				break;
                    			}
                    		}
            			}

            			if(departmentInput.equals("4")) {
            				break;
            			}
            			
            			if(departmentInput.equals("5")) {
            				System.exit(0);
            			}
            		}
            		
            		
            	}

            	/*************************************************************************
            	 * 
            	 * Display UIUC's departments and their building and employee contact info
            	 *************************************************************************/
            	
            	else if(userInput.equals("2")) {

            		UIUCInformation<Map<String,String>> task2 = new UIUCInformation<Map<String,String>>();
            		Map<String,String> department = comp.displayUIUCDetails(task2);
            		
            		System.out.println("\n\tUIUC Department" + "\t\t\t\t UIUC Building");
            		System.out.println("\t____________________________________________________________________\n");
            		for(Map.Entry<String,String> entry : department.entrySet()) {
            			System.out.printf("\t%-30s \t\t%-30s %n", entry.getKey(), entry.getValue());
            			System.out.println();
            		}
            		System.out.println();
            		
            		while(true) {
            			System.out.println("Enter \n\t\"1\" for College of Education, \n\t\"2\" for Psychology, \n\t\"3\" for Computer Science, \n\t\"4\" to return to main menu, \n\t\"5\" to exit");
            			String departmentInput  = user_input_scanner.next();
            			
            			//Display employees of College of Education and their offices
            			if(departmentInput.equals("1")) {
            				UIUCDepartmentEmployee<Map<String, String>> task3 = new UIUCDepartmentEmployee<Map<String, String>>(departmentInput);
            				Map<String, String> uiucEmployee = comp.displayUIUCEmployee(task3);
                    		System.out.println("\n\tUIUC Employee" + "\t\t\t\tUIUC College of Education");
                    		System.out.println("\t______________________________________________________________________");
                    		
                    		for(Map.Entry<String,String> entry : uiucEmployee.entrySet()) {
                    			System.out.printf("\t%-30s \t\t%-30s %n",entry.getKey(), entry.getValue());
                    			System.out.println();
                    		}
                    		System.out.println();
                    		
                    		//Displaying employees of College of Education and their contact details
                    		while(true) {
                    			System.out.println("Enter \n\t\"1\" to UIUC College of Education Employee's Info, or \n\t\"2\" to go back to the previous menu ");
                    			String employeeInput  = user_input_scanner.next();
                    			
                    			if(employeeInput.equals("1")) {
                    				UIUCEmployeeContactInfo<Map<String, String>> task4 = new UIUCEmployeeContactInfo<Map<String, String>>(employeeInput);
                    				Map<String, String> uiucContactInfo = comp.displayUIUCPersonalInfo(task4);
                    				System.out.println("\tUIUC College of Education Employee" + "\tUIUC Phone Number");
                            		System.out.println("\t______________________________________________________________________");
                            		
                            		for(Map.Entry<String,String> entry : uiucContactInfo.entrySet()) {
                            			System.out.printf("\t%-30s \t\t%-30s %n",entry.getKey(), entry.getValue());
                            			System.out.println();
                            		}
                            		System.out.println();	
                    			}
                    			
                    			if(employeeInput.equals("2")) {
                    				break;
                    			}
                    		}

            			}
            			
            			//Display the offices of Employees who work in the Department of Psychology
            			if(departmentInput.equals("2")) {
            				UIUCDepartmentEmployee<Map<String, String>> task3 = new UIUCDepartmentEmployee<Map<String, String>>(departmentInput);
            				Map<String, String> uiucEmployee = comp.displayUIUCEmployee(task3);
                    		System.out.println("\tUIUC Employee" + "\t\t\t\tUIUC Department of Psychology");
                    		System.out.println("\t______________________________________________________________________");
                    		
                    		for(Map.Entry<String,String> entry : uiucEmployee.entrySet()) {
                    			System.out.printf("\t%-30s \t\t%-30s %n",entry.getKey(), entry.getValue());
                    			System.out.println();
                    		}
                    		System.out.println();
                    		
                    		//Display the contact details of employees working in the Department of Psychology
                    		while(true) {
                    			System.out.println("Enter \n\t\"2\" to check UIUC Employee Dept. of Psychology Info, or \n\t\"3\" to go back to the previous menu ");
                    			String employeeInput  = user_input_scanner.next();
                    			
                    			if(employeeInput.equals("2")) {
                    				UIUCEmployeeContactInfo<Map<String, String>> task4 = new UIUCEmployeeContactInfo<Map<String, String>>(employeeInput);
                    				Map<String, String> uiucContactInfo = comp.displayUIUCPersonalInfo(task4);
                    				System.out.println("\tUIUC Dept. of Psychology Employee" + "\tUIUC Phone Number");
                            		System.out.println("\t______________________________________________________________________");
                            		
                            		for(Map.Entry<String,String> entry : uiucContactInfo.entrySet()) {
                            			System.out.printf("\t%-30s \t\t%-30s %n",entry.getKey(), entry.getValue());
                            			System.out.println();
                            		}
                            		System.out.println();	
                    			}
                    			
                    			if(employeeInput.equals("3")) {
                    				break;
                    			}
                    		}
            			}
            			
            			//Displaying the employee of computer science department and their offices
              			if(departmentInput.equals("3")) {
            				UIUCDepartmentEmployee<Map<String, String>> task3 = new UIUCDepartmentEmployee<Map<String, String>>(departmentInput);
            				Map<String, String> uiucEmployee = comp.displayUIUCEmployee(task3);
                    		System.out.println("\tUIUC Employee" + "\t\t\t\tUIUC Computer Science Department");
                    		System.out.println("\t______________________________________________________________________");
                    		
                    		for(Map.Entry<String,String> entry : uiucEmployee.entrySet()) {
                    			System.out.printf("\t%-30s \t\t%-30s %n",entry.getKey(), entry.getValue());
                    			System.out.println();
                    		}
                    		System.out.println();
                    		
                    		//Display the contact details of employees who work in the computer science department
                    		while(true) {
                    			System.out.println("Enter \n\t\"3\" to check UIUC Computer Science Employee Information, or \n\t\"4\" to go back to the previous menu ");
                    			String employeeInput  = user_input_scanner.next();
                    			
                    			if(employeeInput.equals("3")) {
                    				UIUCEmployeeContactInfo<Map<String, String>> task4 = new UIUCEmployeeContactInfo<Map<String, String>>(employeeInput);
                    				Map<String, String> uiucContactInfo = comp.displayUIUCPersonalInfo(task4);
                    				System.out.println("\tUIUC Computer Science Employee" + "\t\tUIUC Phone Number");
                            		System.out.println("\t______________________________________________________________________");
                            		
                            		for(Map.Entry<String,String> entry : uiucContactInfo.entrySet()) {
                            			System.out.printf("\t%-30s \t\t%-30s %n",entry.getKey(), entry.getValue());
                            			System.out.println();
                            		}
                            		System.out.println();	
                    			}
                    			
                    			if(employeeInput.equals("4")) {
                    				break;
                    			}
                    		}
            			}

            			if(departmentInput.equals("4")) {
            				break;
            			}
            			
            			if(departmentInput.equals("5")) {
            				System.exit(0);
            			}
            		}
            	}
            	
            	//Exit
            	else if (userInput.equals("3")){
            		System.out.println("\t\nExiting, Bye!!!!!!!!!!!");
            		System.exit(0);
            	}
            	
            	else {
            		System.out.println("Press either \"1\" or \"2\" or \"3\" ");
            	}
            }
            }
         catch (Exception e) {
            System.err.println("Client exception!!!");
            e.printStackTrace();
        }
    }
}