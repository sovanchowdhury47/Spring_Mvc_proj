package org.jsp.mvcApp.service;
import java.util.Random;
import org.jsp.mvcApp.dao.EmployeeDao;
import org.jsp.mvcApp.dto.Employee;

public class EmployeeService 
{
  public Employee registerEmployee(Employee emp) 
  {
	System.out.println("Inside Employee Service Class");
	//Buisness Logic To Generate EMP_ID//
	if(emp!=null) 
	{
		 Random rd=new Random();
		 int id=rd.nextInt();
		 String emp_id="TCS-"+id;
		 //Set EMP_ID To Employee Object//
		 emp.setEmp_id(emp_id);
	}
	System.out.println("Pass Employee Object From Employee Service to EmployeeController");
	EmployeeDao dao=new EmployeeDao();
	Employee retemployee=dao.saveEmployee(emp);
	System.out.println("Return Employee Object from EmployeeDao to EmployeeService Class");
	return retemployee;
  }
}
