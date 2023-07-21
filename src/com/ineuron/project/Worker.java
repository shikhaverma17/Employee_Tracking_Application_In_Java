package com.ineuron.project;

import java.util.Scanner;

public class Worker
{
	public static void main(String args[])
	{
	    Scanner scan =new Scanner(System.in);
	    Integer choice = null;
		Manager manager= new Manager();
		Employee employee=new Employee();
		
		System.out.println("Please,Select your Domain:");
		System.out.println("1.Manager");
		System.out.println("2.Employee");
		choice=scan.nextInt();
		
		if(choice==1)
		{
			
		}
		else if(choice==2)
		{
			
		}
		else
		{
			System.out.println("Select valid option");
			main(args);
		}
		
	}
}
