export class Todo {
    id: string;
    message: String;
    done: boolean;
    constructor(message: string) {
        this.message = message;
        this.done = false;
    }
}
