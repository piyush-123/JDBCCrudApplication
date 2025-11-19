package in.piyush.factory;

import in.piyush.controller.IstudentController;
import in.piyush.controller.StudentControllerImpl;

public class StudentControllerFactory {
	
	static IstudentController studentController = null;
	
	private StudentControllerFactory() {
		
	}
	
	public static IstudentController getStudentControllerInstance(){
		
		if (studentController == null)
				studentController = new StudentControllerImpl();
		
		return studentController;
		
		
	}

}
