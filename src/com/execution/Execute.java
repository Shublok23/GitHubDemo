package com.execution;
import com.doaImpl.StudentDaoImpl;
import com.pojo.Student;

import java.util.List;
import java.util.Scanner;

public class Execute {

	public static void main(String[] args) {
		
		int value=1;
		
			int id; String name,pass;
			Scanner scan = new Scanner(System.in);
			
			StudentDaoImpl sdi = new StudentDaoImpl();
			Student s = new Student();
			
		do
		{

			System.out.println("1.Insert\n2.update\n3.delete\n4.select by id\n5.select all");
			value = scan.nextInt();
			switch(value)
			{
				case 1:
				{
					id = scan.nextInt();
					name = scan.next();
					pass = scan.next();
					s.setId(id);
					s.setName(name);
					s.setPass(pass);
					
					boolean i = sdi.insertStudent(s);
					if(i)
					{
						System.out.println("Success");
					}
					else {
						System.out.println("Not Success");
					}
					break;
				}
				case 2:
				{
					id = scan.nextInt();
					name = scan.next();
					pass = scan.next();
					s.setId(id);
					s.setName(name);
					s.setPass(pass);
					
					boolean i = sdi.updateStudent(s);
					if(i)
					{
						System.out.println("Success");
					}
					else {
						System.out.println("Not Success");
					}
					break;
				}
				case 3:
				{
					id = scan.nextInt();
					s.setId(id);
					
					boolean i = sdi.deleteStudent(id);
					if(i)
					{
						System.out.println("Success");
					}
					else {
						System.out.println("Not Success");
					}
					break;
				}
				case 4:
				{
					id = scan.nextInt();
					s.setId(id);
					
					Student i = sdi.selectByID(id);
					if(i!=null)
					{
						System.out.println(i);
					}
					else {
						System.out.println("Not Success");
					}
					break;
				}
				case 5:
				{
					List<Student> i = sdi.selectAllStudent();
					if(i!=null)
					{
						for(Student sl:i) {
							System.out.println(sl);
						}
					}
					else {
						System.out.println("Not Success");
					}
					break;
				}
				default:
				{
					
					break;
				}
			}
		}while(value!=0);
		scan.close();
	}
}
