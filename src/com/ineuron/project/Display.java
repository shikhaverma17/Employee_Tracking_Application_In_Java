package com.ineuron.project;

import java.util.Scanner;

public class Display 
{
	Scanner scan = new Scanner(System.in) ;
	int choiceFromUser;
	
	public void homeScreen()
	{
		System.out.println("please enter the type of employee \n"
				+ " enter : 1 for manager \n"
				+ " enter : 2 for worker");
		choiceFromUser = scan.nextInt();
		
		if(choiceFromUser == 1)
		{
			System.out.println("1 entered");
		}
		else if(choiceFromUser == 2)
		{
			System.out.println(" 2 entered");
		}
		else
		{
			System.out.println("please enter valid option");
			Display d1 = new Display();
			d1.homeScreen();
		}
		
	}
	
	public void mangerScreen()
	{
		
	}
	
	public void workerScreen()
	{
		
	}
	
	
}
