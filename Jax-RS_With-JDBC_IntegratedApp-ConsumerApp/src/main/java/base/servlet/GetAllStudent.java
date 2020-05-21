package base.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.Student;
import base.controller.StudentRestConsumer;

@WebServlet("/all")
public class GetAllStudent extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Student> list=StudentRestConsumer.getAllStudents();

		req.setAttribute("list", list);

		RequestDispatcher rd=req.getRequestDispatcher("data.jsp");
		rd.forward(req, resp);
	}
}
