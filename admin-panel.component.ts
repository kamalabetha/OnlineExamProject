import { Component, OnInit } from '@angular/core';
import { ViewUsersService } from './view-users.service';

@Component({
  selector: 'app-admin-panel',
  templateUrl: './admin-panel.component.html',
  styleUrls: ['./admin-panel.component.css']
})
export class AdminPanelComponent implements OnInit {
  displayedColumns: string[] = ['userId', 'username', 'email' ,'password' ,'mobile' ,'dob' ,'city' ,'qual' ,'state' ,'yoc' ,'resetPasswordToken'];


  constructor(private user:ViewUsersService) { }

  ngOnInit(): void {
  }
  tempUser:Array<any> | undefined;
  getAllUsers(){
    
    this.user.getAllUsersService().subscribe((data)=>{
      if (data!=null) 
      {
        this.tempUser=data;
        console.log(this.tempUser);
        sessionStorage.setItem("UserDetails",JSON.stringify(data)); 
      }
      else{
        alert('unable to fetch');
        
       }
       })
      }

}
