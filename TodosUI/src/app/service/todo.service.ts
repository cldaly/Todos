import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { Todo } from '../models/todo';

@Injectable({
  providedIn: 'root'
})
export class TodoService {

  private todoListSubject: BehaviorSubject<Todo[]>;

  checkTodos(): void{
    this.getTodos().subscribe(data => {
      this.todoListSubject.next(data);
    });
  }

  checkCompleted(): void{
    this.getCompleted().subscribe(data => {
      this.todoListSubject.next(data);
    });
  }

  observeTodos():Observable<Todo[]> {
    return this.todoListSubject.asObservable();
  }

  constructor(private http:HttpClient) { 
    this.todoListSubject = new BehaviorSubject<Todo[]>([]);
  }

  getTodos():Observable<Todo[]> {
    return this.http.get<Todo[]>('http://localhost:8080/api/todos');
  }

  getCompleted():Observable<Todo[]> {
    return this.http.get<Todo[]>('http://localhost:8080/api/todos/completed');
  }

  addTodo(todo:Todo):Observable<Todo> {
    return this.http.post<Todo>('http://localhost:8080/api/todos/add', todo);
  }

  completeTodo(id: string):Observable<Todo> {
    return this.http.put<Todo>('http://localhost:8080/api/todos/update',id);
  }

  deleteTodo(id: string):Observable<Todo> {
    return this.http.delete<Todo>(`http://localhost:8080/api/todos/delete/${id}`)
  }
}
