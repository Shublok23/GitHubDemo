package com.doa;

import java.util.List;

import com.pojo.Student;

public interface StudentDao {

	boolean insertStudent(Student s);
	boolean updateStudent(Student s);
	boolean deleteStudent(int id);
	Student selectByID(int id);
	List<Student> selectAllStudent();
	
}
