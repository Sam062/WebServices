package base.service;

import javax.inject.Inject;

import base.Student;
import base.dao.IStudentDao;

public class StudentServiceImpl implements IStudentService{
	// works as Autowired in Spring
	@Inject
	private IStudentDao dao;
	@Override
	public Integer saveStudent(Student s) {
		
		double fee=s.getSfee();
		double disc=fee*10/100.0;
		
		s.setSdiscount(disc);
		
		//CALLING DAL (DATA ACCESS LAYER)
		return dao.saveStudent(s);
	}
}
