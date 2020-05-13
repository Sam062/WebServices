package base;


import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/result")
public class ExamResult {

	@POST
	@Path("/gen")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Result findExamResultInfo(Student student) {
		// creating a List<MarksInfoList>
		List<MarksInfoList> marksInfoList=new ArrayList<>();

		double totalMarks=0.0;
		List<String> results=new ArrayList<>();
		for(Mark mark : student.getMarks()) {
			var theoryMark=mark.getTheoryMark();
			var labMark=mark.getLabMark();
			var marksPercent=(double)(theoryMark+labMark)/200*100;
			var bothTotalMarks=theoryMark+labMark;
			
			totalMarks+=bothTotalMarks;

			MarksInfoList m1=new MarksInfoList(
					mark.getSubjectName(),
					mark.getTheoryMark(),
					mark.getLabMark(),
					marksPercent,
					bothTotalMarks
					);
			// Adding one by one Object(MarksInfoList) To list-List<MarksInfo>
			marksInfoList.add(m1);
			
			if(theoryMark < 40 || labMark < 40)
				results.add("FAIL");
			else
				results.add("PASS");
		}
		var avg=totalMarks/marksInfoList.size();
		var grade="";
		var finalResult="";
		if(results.contains("FAIL")) {
			finalResult="FAIL";
			grade="F";
		}
		else {
			finalResult="PASS";
			if(avg>=190)
				grade="O";
			else if (avg>=180 && avg<190)
				grade="A+";
			else if(avg >=170 && avg<180)
				grade="A";
			else if(avg >=160 && avg<170)
				grade="B+";
			else if(avg >=150 && avg<160)
				grade="B";
			else if(avg >=140 && avg<150)
				grade="C";
		}
		
		Result res=new Result(
				student.getStudentId(),student.getStudentName(),totalMarks,avg,grade,marksInfoList,finalResult);

		return res;
	}
}
