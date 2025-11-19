package in.piyush.dao;

import in.piyush.dto.Student;

public interface IStudentDao {
	
String save(Student student);
	
	Student findById(Integer Id);
	
	String updateById(Student student);
	
	String deleteById(Integer Id);

}
