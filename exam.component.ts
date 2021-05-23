import { Component, OnInit } from '@angular/core';
import { Exam } from './Exam';
import { ExamService } from './exam.service';

@Component({
  selector: 'app-exam',
  templateUrl: './exam.component.html',
  styleUrls: ['./exam.component.css']
})
export class ExamComponent implements OnInit {

  constructor(private ccs:ExamService) { }

  ngOnInit(): void {
  }
 
  tempExam: Exam= new Exam();
  getAllExams(){
    this.ccs.getAllExams().subscribe((data)=>{
    if(data!=null){
        this.tempExam=data;
        sessionStorage.setItem("ExamDetails",JSON.stringify(data)); // storing this on browser session
    }
    else{
        alert("unable to fetch");
      }},
      (err)=>{
        alert("some thing went wrong");
        console.log(err);
      }
    
    )
  
  }
  examId=0;
  tempExamId: Exam= new Exam();
  getExamById(examId: number){
    this.ccs.getExamById(examId).subscribe((data)=>{
      if (data!=null) 
      {this.tempExamId=data;
        sessionStorage.setItem("ExamDetails",JSON.stringify(data)); }
      else{
        alert('unable to fetch');
      }
      })
}
}
  

 

