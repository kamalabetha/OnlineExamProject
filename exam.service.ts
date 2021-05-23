import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Exam } from './Exam';

@Injectable({
  providedIn: 'root'
})
export class ExamService {

  constructor(private myHttp:HttpClient) { }
    getAllExams():Observable<Exam>{
      return this.myHttp.get<Exam>("http://localhost:8080/getAllExams/")
    }
    getExamById(examId: number): Observable<Exam> {
      return this.myHttp.get<Exam>("http://localhost:8080/getExam/"+examId);
       
  }

}
