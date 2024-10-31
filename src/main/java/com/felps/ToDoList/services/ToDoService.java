package com.felps.ToDoList.services;

import com.felps.ToDoList.entity.ToDo;
import com.felps.ToDoList.repository.ToDoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {

    ToDoRepository toDoRepository;

    public ToDoService(ToDoRepository toDoRepository){
        this.toDoRepository = toDoRepository;
    }

    public List<ToDo> create(ToDo toDo){
        toDoRepository.save(toDo);
        return list();
    }

    public List<ToDo> list(){
        Sort sort = Sort.by("priority").descending()
                .and(Sort.by("name").ascending());
        return toDoRepository.findAll();
    }

    public List<ToDo> update(ToDo toDo){
        toDoRepository.save(toDo);
        return list();
    }

    public List<ToDo> delete(Long id){
        toDoRepository.deleteById(id);
        return list();
    }
}
