package com.doaImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.config.DBconnect;
import com.doa.StudentDao;
import com.pojo.Student;

public class StudentDaoImpl implements StudentDao{

	Connection con = DBconnect.getConnection();
	
	public boolean insertStudent(Student s) {

		String sql = " insert into table1 values(?,?,?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,s.getId());
			ps.setString(2,s.getName());
			ps.setString(3,s.getPass());
			int i=ps.executeUpdate();
			if(i>0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateStudent(Student s) {

		String sql = " update table1 set name=?,pass=? where id=?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(3,s.getId());
			ps.setString(1,s.getName());
			ps.setString(2,s.getPass());
			int i=ps.executeUpdate();
			if(i>0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteStudent(int id) {
		String sql = "delete from table1 where id = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,id);
			int i=ps.executeUpdate();
			if(i>0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;			
	}

	public Student selectByID(int id) {
		String sql = "select * from table1 where id=?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			Student s = new Student();
			while(rs.next()) {
				
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setPass(rs.getString(3));
			}
			return s;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;	
	}

	public List<Student> selectAllStudent() {
		String sql = "select * from table1";
		List<Student> sl = new ArrayList<Student>();
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Student s = new Student();
				s.setId(rs.getInt(1));s.setName(rs.getString(2));s.setPass(rs.getString(3));
				sl.add(s);
			}
			return sl;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;	
	}
}
