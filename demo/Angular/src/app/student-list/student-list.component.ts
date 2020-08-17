import { Component, OnInit } from '@angular/core';
import { StudentService } from '../student.service';
import { Student } from '../student';
import { Observable, Subject } from 'rxjs';

import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {

 constructor(private studentservice: StudentService) { }

  get StudentName() {
    return this.studentupdateform.get('student_name');
  }

  get StudentBranch() {
    return this.studentupdateform.get('student_branch');
  }
  get StudentId() {
    return this.studentupdateform.get('student_id');
  }
  get StudentBatch() {
    return this.studentupdateform.get('student_batch');
  }

  studentsArray: any[] = [];
  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any> = new Subject();


  students: Observable<Student[]>;
  student: Student = new Student();
  deleteMessage = false;
  studentlist: any;
  isupdated = false;

  studentupdateform = new FormGroup({
    student_name: new FormControl('' , [Validators.required , Validators.minLength(5) ] ),
    student_id: new FormControl(),
    student_branch: new FormControl(),
    student_batch: new FormControl()
  });


  ngOnInit() {
    this.isupdated = false;
    this.dtOptions = {
      pageLength: 6,
      stateSave: true,
      lengthMenu: [[6, 16, 20, -1], [6, 16, 20, 'All']],
      processing: true
    };
    this.studentservice.getStudentList().subscribe(data => {
    this.students = data;
    this.dtTrigger.next();
    });
  }

  deleteStudent(id: any) {
    this.studentservice.deleteStudent(id)
      .subscribe(
        data => {
          console.log(data);
          this.deleteMessage = true;
          this.studentservice.getStudentList().subscribe(data => {
            this.students = data;
            });
        },
        error => console.log(error));
  }


  updateStudent(id: any) {
    this.studentservice.getStudent(id)
      .subscribe(
        data => {
          this.studentlist = data;
        },
        error => console.log(error));
  }

  updateStu(updstu) {
    this.student = new Student();
    this.student.studentname = this.StudentName.value;
    this.student.branch = this.StudentBranch.value;
    this.student.batch = this.StudentBatch.value;
    this.student.id = this.StudentId.value;
    console.log(this.StudentBranch.value);


    this.studentservice.updateStudent(this.student.id, this.student.studentname,this.student.batch,this.student.branch).subscribe(
    data => {
      this.isupdated = true;
      this.studentservice.getStudentList().subscribe(data => {
        this.students = data;
        });
    },
    error => console.log(error));
  }


  changeisUpdate() {
    this.isupdated = false;
  }
}
