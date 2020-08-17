import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class StudentService {

  private baseUrl = '/user';

  constructor(private http: HttpClient) { }

  getStudentList(): Observable<any> {
    return this.http.get(`${this.baseUrl}` + '/getstudentdata');
  }

  createStudent(studentname: any, branch: any, batch: any): Observable<object> {
    return this.http.get(`${this.baseUrl}` + '/save-student' + '/' + studentname + '/' + branch + '/' + batch );
  }

  deleteStudent(id: any): Observable<object> {
    return this.http.get(`${this.baseUrl}` + '/delete-student' + '/' + id);
  }

  getStudent(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}` + '/student/' + id);
  }

  updateStudent(id: any, studentname: any, branch: any, batch: any): Observable<object> {
    return this.http.get(`${this.baseUrl}` + '/update-student/' + id + '/' + studentname + '/' + branch + '/' + batch );
  }

}
