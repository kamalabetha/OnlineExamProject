package com.example.demo.layer5;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.layer2.Exam;
import com.example.demo.layer4.ExamService;


@RestController
public class ExamController {
	@Autowired
	ExamService examServ;
	@PostMapping(path="/addExam")
	public void addExam(@RequestBody Exam exam) {
		examServ.addExamService(exam);
	}
	 @GetMapping(path="/getAllExams")
	 @ResponseBody
     public Set<Exam> getAllExams() {
		 System.out.println("Exam Controller....Understanding client and talking to service layer...");
		 Set<Exam> examSet=examServ.getAllExamsService();	
		 return examSet;
	}
	 @GetMapping(path="/getExam/{myExamId}")
	 @ResponseBody
	 public Exam getExamByExamId(@PathVariable("myExamId") int examId) {
		 System.out.println("Exam Controller....Understanding client and talking to service layer...");
		 Exam ex=examServ.getExamByExamIdService(examId);
		 return ex;
	}
	 @PostMapping(path="/getExam")
	 public List<Exam> getExamByExamName(@RequestBody Exam exam) {
		System.out.println("Exam Controller....Understanding client and talking to service layer...");
		List<Exam> examList=examServ.getExamByExamNameService(exam.getExamName());
		return examList;
	}
	 
	 @DeleteMapping(path="/deleteExam/{myExamId}")
	 @ResponseBody
	 void deleteExamByExamId(@PathVariable("myExamId") int examId) {
		 examServ.deleteExamByExamIdService(examId);
	}
	 @PutMapping(path="/modifyExam")
	 @ResponseBody
	 void updateExamByExamId(@RequestBody Exam ex){
		 examServ.updateExamByExamIdService(ex);
  }
}
