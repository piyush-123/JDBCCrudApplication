package in.piyush.controller;

import in.piyush.dto.Student;

public interface IstudentController {
	
	String save(Student student);
	
	Student findById(Integer Id);
	
	String updateById(Student student);
	
	String deleteById(Integer Id);

}
