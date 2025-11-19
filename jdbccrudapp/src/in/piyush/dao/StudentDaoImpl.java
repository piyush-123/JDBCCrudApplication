package in.piyush.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.piyush.dto.Student;
import in.piyush.util.JdbcUtil;

public class StudentDaoImpl implements IStudentDao {
	
	Connection connection = null;
	
	
	

	@Override
	public String save(Student student) {
		//System.out.println(student);
		String sqlInsertQuery = "insert into student(`sid`,`sname`,`sage`,`saddr`) values(?,?,?,?)";
		String status = null;
		PreparedStatement pstmt = null; 	
		
		try {
			connection = JdbcUtil.getJDBCConnection();
			
			if(connection != null)
			{
				pstmt = connection.prepareStatement(sqlInsertQuery);
			}
			if(pstmt != null)
			{
				pstmt.setInt(1, student.getSid());
				pstmt.setString(2, student.getSname());
				pstmt.setInt(3, student.getSage());
				
				pstmt.setString(4,student.getSaddr());
				
				int rows = pstmt.executeUpdate();
				if(rows == 1)
				{
					status =  "success";
				}
				else
				{
					status =  "failure";
				}
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			status = "failure";
		}
		
		return status;

	}

	@Override
	public Student findById(Integer Id) {
		String sqlInsertQuery = "Select `sid`,`sname`,`sage`,`saddr`  from student where `sid` = ?";
		String status = null;
		Student student = null;
		PreparedStatement pstmt = null; 	
		
		try {
			connection = JdbcUtil.getJDBCConnection();
			
			if(connection != null)
			{
				pstmt = connection.prepareStatement(sqlInsertQuery);
			}
			if(pstmt != null)
			{
				pstmt.setInt(1, Id);
				ResultSet rows = pstmt.executeQuery();
				if(rows.next()) {
					student = new Student();
					student.setSid(rows.getInt(1));
					student.setSname(rows.getString(2));
					student.setSage(rows.getInt(3));
					student.setSaddr(rows.getString(4));
				}
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return student;
	}

	@Override
	public String updateById(Student student) {
		
		String sqlUpdateQuery = "update student set sname = ?, sage = ? , saddr = ? where sid = ?";
		String status = null;
		PreparedStatement pstmt = null; 	
		
		try {
			connection = JdbcUtil.getJDBCConnection();
			
			if(connection != null)
			{
				pstmt = connection.prepareStatement(sqlUpdateQuery);
			}
			if(pstmt != null)
			{
				System.out.println(student.getSaddr());
				pstmt.setString(1, student.getSname());
				pstmt.setInt(2,student.getSage() );
				pstmt.setString(3, student.getSaddr());
				pstmt.setInt(4, student.getSid());
				int rows = pstmt.executeUpdate();
				if(rows == 1)
				{
					status =  "success";
				}
				else
				{
					status =  "failure";
				}
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			status = "failure";
		}
		
		return status;
	}

	@Override
	public String deleteById(Integer Id) {
		String sqlDeleteQuery = "delete from student where sid = ?";
		String status = null;
		PreparedStatement pstmt = null; 	
		
		try {
			connection = JdbcUtil.getJDBCConnection();
			
			if(connection != null)
			{
				pstmt = connection.prepareStatement(sqlDeleteQuery);
			}
			if(pstmt != null)
			{
				pstmt.setInt(1, Id);
				int rows = pstmt.executeUpdate();
				if(rows == 1)
				{
					status =  "success";
				}
				else
				{
					status =  "failure";
				}
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			status = "failure";
		}
		
		return status;
	}

}
