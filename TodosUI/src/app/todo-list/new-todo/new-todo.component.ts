import { Component, OnInit } from '@angular/core';
import { TodoService } from 'src/app/service/todo.service';
import { Todo } from 'src/app/models/todo';

@Component({
  selector: 'app-new-todo',
  templateUrl: './new-todo.component.html',
  styleUrls: ['./new-todo.component.css']
})
export class NewTodoComponent implements OnInit {

  message: string;

  constructor(private ts:TodoService) { }

  ngOnInit() {
    this.message = '';
  }

  submit = () => {
    if (this.message !== '') {
      this.ts.addTodo(new Todo(this.message)).subscribe(data => {
        if (data) {
          this.message = '';
          this.ts.checkTodos();
        }
      })
    }
  }

}
