package Felps.com.ToDoList.ToDoList.repositories;

import Felps.com.ToDoList.ToDoList.domain.entities.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
}
