package base.service;

import java.util.Collections;
import java.util.List;

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
	@Override
	public List<Student> getAllStudents() {
		List<Student> list=dao.getAllStudents();
		Collections.sort(list,(o1,o2)->o1.getSid().compareTo(o2.getSid()));
		//OR
		//		Collections.sort(list,(o1,o2)->o1.getSid()-o2.getSid());
		return list;
	}

	@Override
	public Boolean removeOneStudent(Integer id) {
		return dao.removeOneStudent(id);
	}

	@Override
	public Student getOneStudent(Integer id) {
		return dao.getOneStudent(id);
	}
	@Override
	public Boolean updateStudent(Student s) {
		double fee=s.getSfee();
		double disc=fee*10/100.0;
		s.setSdiscount(disc);
		return dao.updateStudent(s);
	}
}
