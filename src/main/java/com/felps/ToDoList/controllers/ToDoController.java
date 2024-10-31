package com.felps.ToDoList.controllers;

import com.felps.ToDoList.entity.ToDo;
import com.felps.ToDoList.services.ToDoService;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Repository
@RestController("/todos")
public class ToDoController {

    ToDoService toDoService;

    public ToDoController(ToDoService toDoService){
        this.toDoService = toDoService;
    }

    @PostMapping
    public List<ToDo> create(@RequestBody ToDo toDo){
        return toDoService.create(toDo);
    }

    @GetMapping
    public List<ToDo> List(){
        return toDoService.list();
    }

    @PutMapping
    public List<ToDo> update(@RequestBody ToDo toDo){
        return toDoService.update(toDo);
    }

    @DeleteMapping("/{id}")
    public List<ToDo> delete(@PathVariable Long id){
        return toDoService.delete(id);
    }
}
