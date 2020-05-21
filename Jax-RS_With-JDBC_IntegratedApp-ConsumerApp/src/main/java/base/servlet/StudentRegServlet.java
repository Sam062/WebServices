package base.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.Student;
import base.controller.StudentRestConsumer;

@WebServlet("/save")
public class StudentRegServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer sid=Integer.parseInt(req.getParameter("sid"));
		String sname=req.getParameter("sname");
		String scourse=req.getParameter("scourse");
		Double sfee=Double.parseDouble(req.getParameter("sfee"));

		Student s=new Student(sid, sname, scourse, sfee,0.0);
		String msg=StudentRestConsumer.saveStudent(s);

		req.setAttribute("msg", msg);

		RequestDispatcher rd=req.getRequestDispatcher("index.jsp");
		rd.forward(req, resp);
	}
}
