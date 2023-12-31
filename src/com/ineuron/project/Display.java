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
		System.out.println("***************************************************");
		System.out.println("-----WELCOME TO EMPLOYEE TRACKING APPLICATION-----");
		System.out.println("***************************************************");
		System.out.println("========================================");
		System.out.println("Do you want to Register Employee \n"
				+ " enter : 1 for Yes \n"
				+ " enter : 2 for No");
		System.out.println("========================================");
		choiceFromRegisterUser = scan.nextInt();
		if(choiceFromRegisterUser == 1)
		{
			System.out.println("***************************************");
			System.out.println("opening registration console below.. ");
			System.out.println("***************************************");
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
		System.out.println("========================================");
		System.out.println("please enter the type of employee \n"
				+ " enter : 1 for Manager \n"
				+ " enter : 2 for Worker");
		System.out.println("========================================");
		choiceFromUser = scan.nextInt();

		if(choiceFromUser == 1)
		{
			System.out.println("********************************");
			System.out.println("Manager screen is starting..");
			System.out.println("********************************");
			Display d1 = new Display();
			d1.mangerScreen();
		}
		else if(choiceFromUser == 2)
		{
			System.out.println("********************************");
			System.out.println("worker screen is starting..");
			System.out.println("********************************");
			Display d2 = new Display();
			d2.workerScreen();

		}
		else
		{
			System.out.println("********************************");
			System.out.println("please enter valid option");
			System.out.println("********************************");
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
			System.out.println("=========================================================================================");
			System.out.println("please enter what you want to do from below options: - \n"
					+ " enter : 1 for show all employee \n"					
					+ " enter : 2 for accept or reject worker shift status. \n"
					+ " enter : 3 set the department and project names assigned to employees and assign number of teamamtes. \n"
					+ " enter : 4 for go to home screen menu. \n"
					+ " enter : 5 for exit application!  \n"
					+ " enter : 6 Register a new employee. \n");
			System.out.println("=========================================================================================");
			choiceFromManager = scan.nextInt();

			if(choiceFromManager == 1)
			{
				System.out.println("Selected option 1 !");
				Manager m123 = new Manager();
				m123.showAllEmp();
				

			}
			else if(choiceFromManager == 2)
			{
				Employee emp12345 = new Employee();
				System.out.println("Selected option 2 !");
				System.out.println("please enter the employee Id");
				Integer eid = scan.nextInt();


				Integer eidReturned = emp12345.CheckEmpId(eid);

				if(eidReturned != null)
				{
					//System.out.println("emp non null interger value retuned from emp class :" +eidReturned);
					
					System.out.println("========================================================================");
					System.out.println("please enter the status of the shifttime to be accepted or rejected. \n"
							+ " enter : 1 for accepting the shift of worker \n"
							+ " enter : 2 for rejecting the shift of worker ");
					System.out.println("========================================================================");
					
					Integer stateUpdateFrommanager = scan.nextInt();

					Manager m12 = new Manager();
					m12.updateEmpStatus(eidReturned, stateUpdateFrommanager);
				}
				else
				{
					System.out.println("emp object retuned from emp class : " +eidReturned);
				}

			}
			else if(choiceFromManager == 3)
			{
				Employee emp12345212 = new Employee();

				System.out.println("");
				System.out.println("Selected option 3 !");
				System.out.println("");

				System.out.println("please enter the employee Id");
				Integer eid = scan.nextInt();

				Integer eidReturned123 = emp12345212.CheckEmpId(eid);

				if(eidReturned123 != null)
				{
					System.out.println("");
					System.out.println("please enter the number of employee's reporting in a project::");
					Integer noOfReprtingEmp = scan.nextInt(); 

					System.out.println("please enter the project name to employee's::");
					String projectname = scan12345.nextLine();

					System.out.println("please enter the Department name to employee's::");
					String deptname = scan123456.nextLine();

					Manager m1 = new Manager();
					
					m1.setDept_name(deptname);
					m1.setProject_name(projectname);
					m1.setNo_of_individual_repo(noOfReprtingEmp);
					
					//System.out.println(m1);
					
					Manager m2 = new Manager();
					m2.updateInfoFromManager(eidReturned123, m1);
				}
				else
				{
					System.out.println("emp object returned from emp class : " +eidReturned123);
				}

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
			else if(choiceFromManager == 6)
			{
				System.out.println("Selected to register new employee!");
				Employee emp012341 = new Employee();
				emp012341.registerEmployee();
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
		
		System.out.println("===========================================================================");
		System.out.println("please enter what you want to do from below options: - \n"
				+ " enter : 1 for show time sheet and worker shift status reponse from manager \n"
				+ " enter : 2 for worker details like login date shift time \n"
				+ " enter : 3 for go to home screen menu. \n"
				+ " enter : 4 for exit application!  \n");
		System.out.println("===========================================================================");
		choiceFromWorker = scan.nextInt();

		if(choiceFromWorker == 1)
		{
			Employee empZ123 = new Employee();
			Worker w123 = new  Worker();

			System.out.println("option 1 selected ");
			System.out.println("");
			System.out.println("please enter the employee Id::");
			Integer eid = scan.nextInt();
			Integer workerEmpId = empZ123.CheckEmpId(eid);
			if(workerEmpId != null)
			{
				System.out.println("Worker emp id is :" +workerEmpId);

				w123.showWokerShiftStatus(eid);
			}
			else
			{
				System.out.println("emp object retuned from emp class : " +workerEmpId);
			}

		}
		else if(choiceFromWorker == 2)
		{
			Employee empZ123567 = new Employee();
			Worker worker1 = new  Worker();

			System.out.println(" option 2 selected ");
			System.out.println("");
			System.out.println("please enter the employee Id::");
			Integer workerId = scan.nextInt();

			Integer workerEmpId123 = empZ123567.CheckEmpId(workerId);
			
			if(workerEmpId123 != null)
			{
				//System.out.println("Worker emp id is :" +workerEmpId123);
				
				System.out.print("Enter the login date in (MM-dd-yyyy) format :: ");
				String workerloginDate = scan1122.nextLine();								
				if(workerloginDate.matches("^[0-1][0-9][-][0-3][0-9][-][2][0-9][0-9][0-9]"))
				{
					worker1.setLoginDate(workerloginDate);					
				}
				else
				{
					System.out.println("\n Invalid date format: please type date correctly in 20th century!! ");
					Display displayNewWorkerScreen123 = new Display();
					displayNewWorkerScreen123.workerScreen();
				}				
				System.out.print("Enter the shift time in (HH:MM:SS) format :: ");
				String workerShiftime = scan1122.nextLine();
				worker1.setShift_time(workerShiftime);
				
				Worker w12344 = new  Worker();
				w12344.insertWorkerDetails(workerEmpId123, worker1);

			}
			else
			{
				System.out.println("emp object retuned from emp class : " +workerEmpId123);
			}

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
		System.out.println("****************************************************");
		System.out.println("Thankyou for using Employee Tracking application !");
		System.out.println("****************************************************");
		System.exit(0);
	}



}
