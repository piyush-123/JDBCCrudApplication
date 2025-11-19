package in.piyush.controller;

import in.piyush.dto.Student;
import in.piyush.factory.StudentServiceFactory;
import in.piyush.service.IStudentService;

public class StudentControllerImpl implements IstudentController {
	IStudentService studentService = null;
	
	@Override
	public String save(Student student) {
		studentService = StudentServiceFactory.getStudentServiceInstance();
		return studentService.save(student);
		
		

	}

	@Override
	public Student findById(Integer Id) {
		studentService = StudentServiceFactory.getStudentServiceInstance();
		return studentService.findById(Id);
	}

	@Override
	public String updateById(Student student) {
		studentService = StudentServiceFactory.getStudentServiceInstance();
		return studentService.updateById(student);
	}

	@Override
	public String deleteById(Integer Id) {
		studentService = StudentServiceFactory.getStudentServiceInstance();
		return studentService.deleteById(Id);
	}

}
