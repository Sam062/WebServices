package base.service;

import java.util.List;

import base.Student;

public interface IStudentService {
	Integer saveStudent(Student s);
	List<Student> getAllStudents();
	Boolean removeOneStudent(Integer id);
	Student getOneStudent(Integer id);
	Boolean updateStudent(Student s);
}
