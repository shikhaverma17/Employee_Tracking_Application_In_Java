package com.ineuron.project;

import java.util.Scanner;

public class Display 
{
	Scanner scan = new Scanner(System.in) ;
	int choiceFromUser;
	int choiceFromRegisterUser;
	
	public void registerEmp()
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
	
	public void choiceOfEmp()
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
		Integer choiceFromManager = null;
		
		System.out.println("please enter what you want to do from below options: - \n"
				+ " enter : 1 for show all employee \n"
				+ " enter : 2 for accept or reject worker shift status. \n"
				+ " enter : 3 for go to home screen menu. \n"
				+ " enter : 4 for exit application!  \n");
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
		}
		else if(choiceFromManager == 3)
		{
			System.out.println("Selected option 3 !");
		}
		else if(choiceFromManager == 4)
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
	
	public void workerScreen()
	{
		
	}
	
	public void exitScreen()
	{
		System.out.println("Thankyou for using empoyee tracking application!  \n"
				+ " Bye!!!!!!  \n");
		System.exit(0);
	}
}
