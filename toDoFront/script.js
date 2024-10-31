const todoForm = document.getElementById('todo-form');
const todoList = document.getElementById('todo-list');
const apiUrl = 'http://localhost:8080/todos';

async function fetchTodos() {
    const response = await fetch(apiUrl);
    const todos = await response.json();
    renderTodos(todos);
}

function renderTodos(todos){
    todoList.innerHTML = '';
    todos.forEach(todo => {
        const li = document.createElement('li');
        li.textContent = '${todo.name} - ${todo.description} | Done : ${todo.done} | Priority: ${todo.priority}';
        todoList.appendChild(li);
    })
}

async function addTodo(event){
    event.preventDefault();

    const name= document.getElementById('name').value;
    const description = document.getElementById('description').value;
    const done = document.getElementById('done').checked;
    const priority = parseInt(document.getElementById('priority').value);

    const response = await fetch(apiUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ name, description, done, priority}),
    });

    if (response.ok){
        fetchTodos();
        todoForm.reset();
    }else{
        alert('Erro ao adicionar tarefa');
    }
}

todoForm.addEventListener('submit', addTodo);
fetchTodos();