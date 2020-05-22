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

@WebServlet("/edit")
public class StudentEditServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException {

		Integer sid=Integer.parseInt(req.getParameter("sid"));
		Student s=StudentRestConsumer.getOneStudent(sid);

		req.setAttribute("sob", s);

		RequestDispatcher rd=req.getRequestDispatcher("edit.jsp");
		rd.forward(req, resp);
	}

}
