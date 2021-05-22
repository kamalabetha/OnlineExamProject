package com.example.demo;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.layer2.Exam;
import com.example.demo.layer2.ExamLevel;
import com.example.demo.layer2.ExamResult;
import com.example.demo.layer2.ExamUser;
import com.example.demo.layer3.UserRepository;
import com.example.demo.layer3.ExamRepository;
import com.example.demo.layer3.ResultRepository;

@SpringBootTest
class NewOnlineExamAaApplicationTests {

	@Autowired
	ResultRepository resultRepo;
	
	@Autowired
	UserRepository euRepo;
	@Test
	void getUser() {
		ExamUser eu=euRepo.getUserByUserId(101);
		System.out.println(eu.getUsername());
		System.out.println(eu.getCity());
		System.out.println(eu.getMobile());
	}
	@Test
	void addUser() {
		ExamUser eu=new ExamUser();
		eu.setUsername("hemanth");
		eu.setCity("Hyderabad");
		eu.setState("Telangana");
		eu.setEmail("hemanth123@gmail.com");
		eu.setMobile(856932621);
		String str="1995-02-23";
		Date date=Date.valueOf(str);
		eu.setDob(date);
		eu.setQual("BE");
		eu.setYoc(2019);
		eu.setPassword("dsdfdsfe");
		euRepo.addUser(eu);;
	}
	
	@Test
	void getAllUsers() {
		List<ExamUser> euList=euRepo.getAllUsers();
		for(ExamUser eu: euList) {
			System.out.println(eu.getUsername());
			System.out.println(eu.getCity());
			System.out.println(eu.getMobile());
			System.out.println(eu.getState());
			System.out.println(eu.getEmail());
			System.out.println(eu.getQual());
			System.out.println(eu.getYoc());
			System.out.println(eu.getDob());
			System.out.println("---------------------------------");
		}
	}
	
	@Test
	void deleteUser() {
		euRepo.deleteUserByUserId(0);
	}
	@Test
	void updateUserPassword(){
		ExamUser eu=euRepo.getUserByUserId(104);
		eu.setPassword("vishnu145");
		euRepo.updateUserPasswordByUserId(eu);
	}
	
	//Result Repo Test
	@Test
	void addResult() {
		ExamResult r=new ExamResult();
		ExamUser eu=new ExamUser();
		Exam ex=new Exam();
		ExamLevel lv=new ExamLevel();
		r.setResultId(3347);
		r.setAttemptedQs(9);
		r.setNonAttemptedQs(1);
		r.setCrctAns(9);
		r.setIncrctAns(0);
		r.setMarks(9);
		r.setPercentage(80.0);
		r.setStatus("pass");
		eu.setUserId(102);
		ex.setExamId(504);
		lv.setLevelId(3);
		r.setExamUser(eu);
		r.setExam(ex);
		r.setExamLevel(lv);
		resultRepo.addResult(r) ;
	}
	
	@Test
	void getResultByUserIdExamIdLevelId() {
		List<ExamResult> resultList=resultRepo.getResultByUserIdExamIdLevelId(101,501,1);
	
	}
	//Exam Repo Test
	@Autowired
	ExamRepository examRepository;
	@Test
	void addingExam() {
		Exam exam=new Exam();
		exam.setExamId(508);
		exam.setExamName("R");
		String str="2021-04-20";
		Date date=Date.valueOf(str);
	    exam.setExamDate(date);
		exam.setStartTime("09:00 PM");
	    exam.setEndTime("10:00 PM");
	    examRepository.addExam(exam);
	    System.out.println("-----------------");
	    
		}
	@Test
	void findingAllExams() {
		Set<Exam> examSet=examRepository.getAllExams();
		for (Exam exam: examSet) {
			System.out.println(exam.getExamId());
			System.out.println(exam.getExamName());
			System.out.println(exam. getExamDate());
			System.out.println(exam.getStartTime());
			System.out.println(exam.getEndTime());
			System.out.println("-----------------");
			int examId=506;
		    String examName="SQL";
		    assertEquals("SQL",examName);
			System.out.println("such exam was existed");
			assertNotNull(examName);
			System.out.println("examName is not null");
			assertTrue(examId>700);
			System.out.println("examId passed");
			System.out.println("testing exam assertion is over");
			System.out.println("-----------------");
			}
	}
	
	@Test
	void searchingExamByExamId() {
		Exam exam=examRepository.getExamByExamId(501);
			System.out.println(exam.getExamName());
			System.out.println(exam. getExamDate());
			System.out.println(exam.getStartTime());
			System.out.println(exam.getEndTime());
			System.out.println("-----------------");
			int examId=506;
		    String examName="SQL";
		    assertEquals("SQL",examName);
			System.out.println("such exam was existed");
			assertNotNull(examName);
			System.out.println("examName is not null");
			assertTrue(examId<700);
			System.out.println("examId passed");
			System.out.println("testing exam assertion is over");
			System.out.println("-----------------");
		}
	@Test
	void searchingExamByExamName() {
		List<Exam> ExamList = examRepository.getExamByExamName("java");
		for (Exam exam: ExamList) {
			System.out.println(exam.getExamId());
			System.out.println(exam. getExamDate());
			System.out.println(exam.getStartTime());
			System.out.println(exam.getEndTime());
			System.out.println("-----------------");
			int examId=506;
		    String examName="SQL";
		    assertEquals("sql",examName);
			System.out.println("such exam was existed");
			assertNotNull(examName);
			System.out.println("examName is not null");
			assertTrue(examId<700);
			System.out.println("examId passed");
			System.out.println("testing exam assertion is over");
			System.out.println("-----------------");
		}
	}
	
	@Test
	void updatingExamByExamId() {
		//Exam ex=exRepo.getExambyExamName("java");
		//List<Exam> ExList = exRepo.getExambyExamName("R");
		//for (Exam ex: ExList) {
		Exam exam=new Exam();
		exam.setExamId(508);
		exam.setExamName("cpp");
		String str="2021-04-25";
		Date date=Date.valueOf(str);
	    exam.setExamDate(date);
		exam.setStartTime("09:30 PM");
	    exam.setEndTime("10:30 PM");
	    examRepository.updateExamByExamId(exam);
	    System.out.println("-----------------");
		}
	
	@Test
	public void deletingExamByExamId() {
		examRepository.deleteExamByExamId(508);
		System.out.println("-----------------");
	}
	
}
	

