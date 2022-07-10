package org.jsp.mvcApp.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.jsp.mvcApp.dto.Employee;
import org.jsp.mvcApp.service.EmployeeService;

public class EmployeeController extends HttpServlet
{
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
throws ServletException, IOException 
 {
   System.out.println("Inside EmployeeController Class");
   Employee emp=null;
   Employee retemp=null;
   //Data Validation//
   if(!req.getParameter("fn").isEmpty()
	   &&!req.getParameter("ln").isEmpty()
	   &&!req.getParameter("ln").isEmpty()
	   &&!req.getParameter("pw").isEmpty()) 
   {
	   emp=new Employee();
	   emp.setFirst_name(req.getParameter("fn"));
	   emp.setLast_name(req.getParameter("ln"));
	   emp.setEmail_id(req.getParameter("em"));
	   emp.setPassword(req.getParameter("pw"));
	   System.out.println("Pass Employee Object from EmployeeController");
	   EmployeeService empsrv=new EmployeeService()	;
	   retemp= empsrv.registerEmployee(emp);
	   System.out.println("Return Employee Object From EmployeService to Employee Controller");
   }
   else {
	   emp=null;
	   System.out.println("Invalid Data");
   }
        //Presentation Logic//
      //Redirect Data to UI Or View Part//
   RequestDispatcher dispatcher=null;
   if(retemp!=null) {
	   //Add Request Object Into Scope//
	   req.setAttribute("UserName",retemp.getFirst_name()+retemp.getLast_name());
	   dispatcher=req.getRequestDispatcher("Sucess.jsp");
   }
   else {
	   dispatcher=req.getRequestDispatcher("Error.jsp");
   }
   dispatcher.forward(req,resp);
 }
}