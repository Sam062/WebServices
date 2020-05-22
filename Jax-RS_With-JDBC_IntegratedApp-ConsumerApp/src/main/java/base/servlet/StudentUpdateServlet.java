package base.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.Student;
import base.controller.StudentRestConsumer;

@WebServlet("/update")
public class StudentUpdateServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException {
		Integer sid=Integer.parseInt(req.getParameter("sid"));
		String sname=req.getParameter("sname");
		String scourse=req.getParameter("scourse");
		Double sfee=Double.parseDouble(req.getParameter("sfee"));

		Student s=new Student(sid,sname,scourse,sfee);

		String msg=StudentRestConsumer.updateStudent(s);
		req.setAttribute("msg", msg);

		List<Student> list=StudentRestConsumer.getAllStudents();
		req.setAttribute("list", list);

		req.getRequestDispatcher("data.jsp").forward(req, resp);
	}
}
