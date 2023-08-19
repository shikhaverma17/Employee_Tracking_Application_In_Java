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
// data base query 
/*

use your db name;

CREATE TABLE `employee` (
  `eid` int NOT NULL AUTO_INCREMENT,
  `ename` varchar(20) DEFAULT NULL,
  `state` varchar(50) DEFAULT NULL,
  `street` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `zipcode` varchar(20) DEFAULT NULL,
  `etype` varchar(45) DEFAULT NULL,
  `logindate` date DEFAULT NULL,
  `shifttime` time DEFAULT NULL,
  `shiftstatus` varchar(45) DEFAULT NULL,
  `deptname` varchar(45) DEFAULT NULL,
  `projectname` varchar(45) DEFAULT NULL,
  `reportingempcount` int DEFAULT NULL,
  PRIMARY KEY (`eid`)
);

   */
 