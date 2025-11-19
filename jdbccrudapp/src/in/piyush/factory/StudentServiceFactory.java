package in.piyush.factory;

import in.piyush.service.IStudentService;
import in.piyush.service.StudentServiceImpl;

public class StudentServiceFactory {
	
	static IStudentService studentService = null;
	
	private StudentServiceFactory() {
		
	}
	
	public static IStudentService getStudentServiceInstance() {
		
		if(studentService == null)
			studentService = new StudentServiceImpl();
		
		return studentService;
		
	}
	

}
