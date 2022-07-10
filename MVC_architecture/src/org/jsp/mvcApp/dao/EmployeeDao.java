package org.jsp.mvcApp.dao;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;import org.hibernate.mapping.PrimaryKey;
import org.jsp.mvcApp.dto.Employee;

public class EmployeeDao 
{
public Employee saveEmployee(Employee emp) 
 {
	System.out.println("Inside Employee Class");
	int priamarykey=0;
	Transaction tran=null;
	try 
	{
		if(emp!=null) 
		{
		Configuration conf=new Configuration();
		conf.configure();
		SessionFactory sef=conf.buildSessionFactory();
		Session ses=sef.openSession();
		tran=ses.beginTransaction();
		priamarykey=(int)ses.save(emp);
		System.out.println("Employee Object Saved Into DataBase");
		tran.commit();
		ses.close();
		}
	}
	catch(HibernateException e)
	{
	tran.rollback();
	System.out.println("Operation Rolled Back");
	return null;
	//UnsucessFull Transaction//
	}
	if(priamarykey!=0) 
	{
		System.out.println("Return Employee Object From DataBase To EmployeeDao");
		return emp;
	}
	else 
	{
		return null;
	}
 }
}
