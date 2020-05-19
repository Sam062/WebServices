package base.dao;

import java.util.List;

import base.Student;

public interface IStudentDao {
	public Integer saveStudent(Student s);
	public List<Student> getAllStudents();
	public Boolean removeOneStudent(Integer id);
	public Student getOneStudent(Integer id);
	public Boolean updateStudent(Student s);

}
