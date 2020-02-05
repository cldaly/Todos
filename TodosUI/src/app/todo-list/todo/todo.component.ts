import { Component, OnInit, Input } from '@angular/core';
import { Todo } from 'src/app/models/todo';
import { TodoService } from 'src/app/service/todo.service';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {

  @Input() todo:Todo;
  @Input() view:boolean;

  constructor(private ts:TodoService) { }

  ngOnInit() {
  }

  complete(){
    this.ts.completeTodo(this.todo.id).subscribe(data => {
      if(data)
        this.ts.checkTodos();
    })
  }

  delete(){
    this.ts.deleteTodo(this.todo.id).subscribe(() => {
      this.ts.checkCompleted();
    })
  }
}
