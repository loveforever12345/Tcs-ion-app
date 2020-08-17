import { Component, OnInit } from '@angular/core';
import { StudentService } from '../student.service';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import { Student } from '../student';
@Component({
  selector: 'app-add-student',
  templateUrl: './add-student.component.html',
  styleUrls: ['./add-student.component.css']
})
export class AddStudentComponent implements OnInit {

  constructor(private studentservice: StudentService) { }

  get StudentName() {
    return this.studentsaveform.get('student_name');
  }

  get StudentBranch() {
    return this.studentsaveform.get('student_branch');
  }

  get StudentBatch() {
    return this.studentsaveform.get('student_batch');
  }

  student: Student = new Student();
  submitted = false;

  studentsaveform = new FormGroup({
    student_name: new FormControl('' , [Validators.required , Validators.minLength(5) ] ),
    student_branch: new FormControl(),
    student_batch: new FormControl()
  });

  ngOnInit() {
    this.submitted = false;
  }

  saveStudent(saveStudent) {
    this.student = new Student();
    this.student.studentname = this.StudentName.value;
    this.student.branch = this.StudentBranch.value;
    this.student.batch = this.StudentBatch.value;

    this.submitted = true;
    this.save(this.student);
  }



  save(student :any) {
    this.studentservice.createStudent( this.student.studentname, this.student.branch,this.student.batch)
      .subscribe(data => console.log(data), error => console.log(error));
    this.student = new Student();
  }

  addStudentForm() {
    this.submitted = false;
    this.studentsaveform.reset();
  }
}
