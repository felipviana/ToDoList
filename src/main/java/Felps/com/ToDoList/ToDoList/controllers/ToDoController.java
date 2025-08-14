package Felps.com.ToDoList.ToDoList.controllers;

import Felps.com.ToDoList.ToDoList.domain.entities.ToDo;
import Felps.com.ToDoList.ToDoList.services.ToDoService;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/toDos")
public class ToDoController {

    ToDoService toDoService;

    public ToDoController(ToDoService toDoService){
        this.toDoService = toDoService;
    }

    @GetMapping
    public List<ToDo> getAllToDos(){
        return toDoService.list();
    }

    @GetMapping("/{id}")
    public ToDo getByIdToDo(@PathVariable Long id){
        return toDoService.getById(id);
    }

    @PostMapping
    public List<ToDo> create(@RequestBody ToDo todo){
        return toDoService.create(todo);
    }

    @PutMapping("/{id}")
    public ToDo update(@PathVariable Long id, @RequestBody ToDo todo){
        return toDoService.update(id, todo);
    }

    @DeleteMapping("/{id}")
    public List<ToDo> delete(@PathVariable Long id){
        return toDoService.delete(id);
    }

}
