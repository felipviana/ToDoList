package Felps.com.ToDoList.ToDoList.repositories;

import Felps.com.ToDoList.ToDoList.domain.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
