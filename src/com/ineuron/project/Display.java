package com.ineuron.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Display 
{
	Scanner scan = new Scanner(System.in) ;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int choiceFromUser;
	int choiceFromRegisterUser;
	
	public void registerEmp() throws IOException
	{
		System.out.println("Do you want to register Employee \n"
				+ " enter : 1 for yes \n"
				+ " enter : 2 for no");
		choiceFromRegisterUser = scan.nextInt();
		if(choiceFromRegisterUser == 1)
		{
			System.out.println("opening registration console below.. ");
			Employee emp01 = new Employee();
			emp01.registerEmployee();
		}
		else if(choiceFromRegisterUser == 2)
		{
			
			Display d2 = new Display();
			d2. choiceOfEmp();		
		}
		else
		{
			System.out.println("please enter valid option");
			Display d1 = new Display();
			d1. choiceOfEmp();
		}
	}
	
	public void choiceOfEmp() throws IOException
	{
		System.out.println("please enter the type of employee \n"
				+ " enter : 1 for manager \n"
				+ " enter : 2 for worker");
		choiceFromUser = scan.nextInt();
		
		if(choiceFromUser == 1)
		{
			System.out.println("Manager screen is starting..");
			Display d1 = new Display();
			d1.mangerScreen();
		}
		else if(choiceFromUser == 2)
		{
			System.out.println("worker screen is starting..");
			Display d2 = new Display();
			d2.workerScreen();
			
		}
		else
		{
			System.out.println("please enter valid option");
			Display d3 = new Display();
			d3.choiceOfEmp();
		}
		
	}
	
	public void mangerScreen() 
	{
		Scanner scan12345 = new Scanner(System.in);
		Scanner scan123456 = new Scanner(System.in);
		try
		{
		Integer choiceFromManager = null;
		
		System.out.println("please enter what you want to do from below options: - \n"
				+ " enter : 1 for show all employee \n"
				+ " enter : 2 for accept or reject worker shift status. \n"
				+ " enter : 3 set the department and project names assigned to employees and assign number of teamamtes. \n"
				+ " enter : 4 for go to home screen menu. \n"
				+ " enter : 5 for exit application!  \n");
		choiceFromManager = scan.nextInt();
		
		if(choiceFromManager == 1)
		{
			System.out.println("Selected option 1 !");
			Manager m123 = new Manager();
			m123.showAllEmp();
//			System.out.println("please enter 1 or 2 below options to show all employee: - \n"
//					+ " enter : 1 for show all employee date wise  \n"
//					+ " enter : 2 for show all employee \n");
			
		}
		else if(choiceFromManager == 2)
		{
			System.out.println("Selected option 2 !");
			System.out.println("please enter the employee Id");
			Integer eid = scan.nextInt();
			
			System.out.println("please enter the status of the shifttime to be accepted or rejected. \n"
					+ " enter : 1 for accept shift of worker \n"
					+ " enter : 2 for reject shift of worker ");
			Integer stateUpdateFrommanager = scan.nextInt();
			
			Manager m12 = new Manager();
			m12.updateEmpStatus(eid, stateUpdateFrommanager);
			
		}
		else if(choiceFromManager == 3)
		{
			System.out.println("Selected option 3 !");

			System.out.println("please enter the employee Id");
			Integer eid = scan.nextInt();
			
			System.out.println("please enter the number of emps reporting in a project");
			Integer noOfReprtingEmp = scan.nextInt(); 
			// br.read();
			
			System.out.println("please enter the project name to emps");
			String projectname = scan12345.nextLine();
			
			System.out.println("please enter the Department name to emps");
			String deptname = scan123456.nextLine();
			
			Manager m1 = new Manager();
			m1.setDept_name(deptname);
			m1.setProject_name(projectname);
			m1.setNo_of_individual_repo(noOfReprtingEmp);
			System.out.println(m1);
			Manager m2 = new Manager();
			m2.updateInfoFromManager(eid, m1);
						
		}
		else if(choiceFromManager == 4)
		{
			System.out.println("Selected option 4 !");
			Display d1234 = new Display();
			d1234.choiceOfEmp();
		}
		else if(choiceFromManager == 5)
		{
			System.out.println("Selected to exit!");
			Display d123 = new Display();
			d123.exitScreen();
		}
		else
		{
			System.out.println("please enter valid option");
			Display d3 = new Display();
			d3.mangerScreen();
		}
		}
		catch(Exception e01)
		{
			e01.printStackTrace();
		}
		
	}
	
	public void workerScreen()
	{
		Integer choiceFromWorker = null;
		Scanner scan1122 = new Scanner(System.in) ;
		
		System.out.println("please enter what you want to do from below options: - \n"
				+ " enter : 1 for show time sheet and worker shift status reponse from manager \n"
				+ " enter : 2 for worker details like login date shift time \n"
				+ " enter : 3 for go to home screen menu. \n"
				+ " enter : 4 for exit application!  \n");
		choiceFromWorker = scan.nextInt();
		
		if(choiceFromWorker == 1)
		{
			System.out.println("option 1 selected ");
			System.out.println("please enter the employee Id");
			Integer eid = scan.nextInt();
			
			Worker w123 = new  Worker();
			w123.showWokerShiftStatus(eid);
		}
		else if(choiceFromWorker == 2)
		{
			System.out.println(" option 2 selected ");
			System.out.println("please enter the employee Id");
			Integer workerId = scan.nextInt();
			
			System.out.print("Enter the login date in (MM-dd-yyyy) format :: ");
			String workerloginDate = scan1122.nextLine();
			
			System.out.print("Enter the shift time in (HH:MM:SS) format :: ");
			String workerShiftime = scan1122.nextLine();
			
			Worker worker1 = new  Worker();
			worker1.setLoginDate(workerloginDate);
			worker1.setShift_time(workerShiftime);
			
			Worker w12344 = new  Worker();
			w12344.insertWorkerDetails(workerId, worker1);
		}
		else if(choiceFromWorker == 3)
		{
			System.out.println("Selected option 4 !");
			Display d123444 = new Display();
			try {
				d123444.choiceOfEmp();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(choiceFromWorker == 4)
		{
			System.out.println("Selected to exit!");
			Display d123666 = new Display();
			d123666.exitScreen();
		}
		else
		{
			System.out.println(" please enter Valid options");
			Display d44 = new Display();
			d44.workerScreen();;
		}
		
		
	}
	
	public void exitScreen()
	{
		System.out.println("Thankyou for using employee tracking application!  \n"
				+ " Bye!!!!!!  \n");
		System.exit(0);
	}
	
	

}
