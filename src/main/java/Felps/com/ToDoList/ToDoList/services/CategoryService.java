package Felps.com.ToDoList.ToDoList.services;

import Felps.com.ToDoList.ToDoList.domain.entities.Category;
import Felps.com.ToDoList.ToDoList.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> list(){
        return categoryRepository.findAll();
    }

    public List<Category> create(Category category){
        categoryRepository.save(category);
        return list();
    }

    public Category update(Long id, Category category){
        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found!!"));

        existingCategory.setName(category.getName());
        existingCategory.setDescription(category.getDescription());
        categoryRepository.save(existingCategory);
        return existingCategory;
    }

    public List<Category> delete(Long id){
        categoryRepository.deleteById(id);
        return list();
    }
}
