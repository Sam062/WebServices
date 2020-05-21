package base.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

	@Override
	public List<Student> getAllStudents() {
		String sql="SELECT * FROM STUDENT";
		List<Student> list=null;
		try {
			PreparedStatement ps=DbConnection.getCon().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			list=new ArrayList<>();
			while(rs.next()) {
				//A. reading data from ResultSet Row
				//B. Converting data into Student Object
				//C. Adding Student Obj to List

				list.add(new Student(rs.getInt("sid"), 
						rs.getString("sname"),
						rs.getDouble("sfee"),
						rs.getString("scourse"),
						rs.getDouble("sdiscount")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public Boolean removeOneStudent(Integer id) {
		String sql="DELETE FROM STUDENT WHERE SID=?";
		boolean delete=false;
		try {
			PreparedStatement ps=DbConnection.getCon().prepareStatement(sql);
			ps.setInt(1, id);

			delete=ps.executeUpdate()>0?true:false;
		} catch (Exception e) {
			delete=false;
			e.printStackTrace();
		}
		return delete;
	}

	@Override
	public Student getOneStudent(Integer id) {
		String sql="SELECT * FROM STUDENT WHERE SID= ? ";
		Student s=null;
		try {
			PreparedStatement ps=DbConnection.getCon().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				s=new Student(rs.getInt("sid"),
						rs.getString("sname"),
						rs.getDouble("sfee"),
						rs.getString("scourse"),
						rs.getDouble("sdiscount"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public Boolean updateStudent(Student s) {
		boolean update=false;
		String sql="UPDATE STUDENT SET SNAME=?, SFEE=?, SCOURSE=?, SDISCOUNT=? WHERE SID=?";
		try {
			PreparedStatement ps=DbConnection.getCon().prepareStatement(sql);
			ps.setString(1, s.getSname());
			ps.setDouble(2, s.getSfee());
			ps.setString(3, s.getScourse());
			ps.setDouble(4, s.getSdiscount());
			ps.setInt(5, s.getSid());

			update=ps.executeUpdate()>0?true:false;
		} catch (Exception e) {
			update=false;
			e.printStackTrace();
		}
		return update;
	}
}
