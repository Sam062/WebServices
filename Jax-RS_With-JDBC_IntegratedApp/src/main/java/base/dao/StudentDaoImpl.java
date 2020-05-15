package base.dao;

import java.sql.PreparedStatement;

import base.Student;
import base.dbConn.DbConnection;

public class StudentDaoImpl implements IStudentDao{
	@Override
	public Integer saveStudent(Student s) {
		String sql="insert into student values(?,?,?,?,?)";
		int count=0;
		try {
			PreparedStatement ps=DbConnection.getCon().prepareStatement(sql);
			
			ps.setInt(1, s.getSid());
			ps.setDouble(2, s.getSfee());
			ps.setString(3, s.getSname());
			ps.setString(4, s.getScourse());
			ps.setDouble(5, s.getSdiscount());
			
			count=ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
}
