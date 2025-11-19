package in.piyush.factory;

import in.piyush.dao.IStudentDao;
import in.piyush.dao.StudentDaoImpl;

public class StudentDaoFactory {
	
	static IStudentDao studentDao = null;
	
	private StudentDaoFactory() {
		
	}
	
	public static IStudentDao getStudentDaoInstance() {
		
		if(studentDao == null)
			studentDao = new StudentDaoImpl();
			
		return studentDao;
	}

}
