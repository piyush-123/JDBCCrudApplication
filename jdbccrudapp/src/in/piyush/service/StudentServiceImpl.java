package in.piyush.service;

import in.piyush.dao.IStudentDao;
import in.piyush.dto.Student;
import in.piyush.factory.StudentDaoFactory;
import in.piyush.factory.StudentServiceFactory;

public class StudentServiceImpl implements IStudentService {

	IStudentDao studentDao = null;
	@Override
	public String save(Student student) {
		
		studentDao = StudentDaoFactory.getStudentDaoInstance();
		return studentDao.save(student);

	}

	@Override
	public Student findById(Integer Id) {
		studentDao = StudentDaoFactory.getStudentDaoInstance();
		return studentDao.findById(Id);
	}

	@Override
	public String updateById(Student student) {
		studentDao = StudentDaoFactory.getStudentDaoInstance();
		return studentDao.updateById(student);
	}

	@Override
	public String deleteById(Integer Id) {
		studentDao = StudentDaoFactory.getStudentDaoInstance();
		return studentDao.deleteById(Id);
	}

}
