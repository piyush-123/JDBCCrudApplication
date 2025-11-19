package in.piyush.service;

import in.piyush.dto.Student;

public interface IStudentService {
	
	String save(Student student);
	
	Student findById(Integer Id);
	
	String updateById(Student student);
	
	String deleteById(Integer Id);

}
