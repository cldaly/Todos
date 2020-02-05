import { Component, OnInit, OnDestroy } from '@angular/core';
import { TodoService } from '../service/todo.service';
import { Todo } from '../models/todo';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.css']
})
export class TodoListComponent implements OnInit, OnDestroy {

  todoSubscription:Subscription;
  todos: Todo[] = [];
  todoView: boolean;

  constructor(private ts:TodoService) { 
    this.todoView = true;
    this.todoSubscription = this.ts.observeTodos().subscribe(data => {
      this.todos = data;
    });
  }

  ngOnInit() {
    this.ts.checkTodos();
  }

  ngOnDestroy() {
    this.todoSubscription.unsubscribe();
  }

  changeView = () => {
    this.todoView = !this.todoView;
    if (this.todoView) {
      this.ts.checkTodos();
    } else {
      this.ts.checkCompleted()
    }
  }
}
