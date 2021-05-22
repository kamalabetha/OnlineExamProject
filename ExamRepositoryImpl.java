package com.example.demo.layer3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.layer2.Exam;
@Repository
public class ExamRepositoryImpl implements ExamRepository {//isA
		@PersistenceContext
		 EntityManager entityManager;//auto injected by spring by reading 
											//persistance.xml file
		
		
		@Transactional//no need of begin transaction and commit rollback
		public void addExam(Exam exam) {//usesA
			entityManager.persist(exam);

		}
		@Transactional//no need of begin transaction and commit rollback
		public Exam getExamByExamId(int examId) {//producesA Department obj
			System.out.println("onlineexam repo....NO scope of bussiness logic here...");
			return entityManager.find(Exam.class,examId);
			
		}
		@SuppressWarnings("unchecked")
		@Transactional
		public List<Exam> getExamByExamName(String examName) {
				List<Exam> ExamList;
				ExamList = new ArrayList<Exam>();
				//Query query = entityManager.createQuery("select i from Exam i where i.exname=:myexam",Exam.class).setParameter("myexam", "java");
				Query query = entityManager.createQuery("from Exam e where examName =:myexam",Exam.class).setParameter("myexam", examName);
				ExamList = query.getResultList();
			    return ExamList;
		}
		@SuppressWarnings("unchecked")
		@Transactional
		public Set<Exam> getAllExams() {
			Set<Exam> ExSet;
			ExSet= new HashSet<Exam>();
			
				String queryString = "from Exam";
				Query query = entityManager.createQuery(queryString);
				ExSet = new HashSet(query.getResultList());
				return ExSet;
		}	
		
		@Transactional
		public void updateExamByExamId(Exam exam) {
			entityManager.merge(exam);
		}

		@Transactional
		public void deleteExamByExamId(int examId) {
			Exam ex = entityManager.find(Exam.class,examId);
			entityManager.remove(ex);
			
		}

	}
