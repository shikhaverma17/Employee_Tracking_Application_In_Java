package com.ineuron.project;

public class Manager extends Employee 
{
   private String dept_name;
   private Integer nof_ind_repo;
   private String timesheet_assign_for_approval;
public String getDept_name() {
	return dept_name;
}
public void setDept_name(String dept_name) {
	this.dept_name = dept_name;
}
public Integer getNof_ind_repo() {
	return nof_ind_repo;
}
public void setNof_ind_repo(Integer nof_ind_repo) {
	this.nof_ind_repo = nof_ind_repo;
}
public String getTimesheet_assign_for_approval() {
	return timesheet_assign_for_approval;
}
public void setTimesheet_assign_for_approval(String timesheet_assign_for_approval) {
	this.timesheet_assign_for_approval = timesheet_assign_for_approval;
}
   
   
   
}
