package com.ineuron.project;

import java.io.IOException;

import in.ineuron.util.JDBC_Util;

public class MainClassForEmpTrackingProj {

	public static void main(String[] args) throws IOException
	{
		Display d = new Display();
		d.registerEmp();	
	}
}

 