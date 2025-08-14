package Felps.com.ToDoList.ToDoList.services;

import Felps.com.ToDoList.ToDoList.domain.entities.ToDo;
import Felps.com.ToDoList.ToDoList.repositories.ToDoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {

    ToDoRepository toDoRepository;

    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public List<ToDo> list(){
        return toDoRepository.findAll();
    }

    public List<ToDo> create(ToDo todo){
        toDoRepository.save(todo);
        return list();
    }

    public List<ToDo> update(Long id, ToDo todo){
        ToDo existingToDo = toDoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ToDo not found!!"));

        existingToDo.setName(todo.getName());
        existingToDo.setDescription(todo.getDescription());
        existingToDo.setPriority(todo.getPriority());
        existingToDo.setDone(todo.getDone());
        existingToDo.setCategory(todo.getCategory());
        toDoRepository.save(existingToDo);
        return list();
    }

    public List<ToDo> delete(Long id){
        toDoRepository.deleteById(id);
        return list();
    }
}
