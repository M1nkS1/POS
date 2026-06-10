package service;

import model.Category;
import repository.CategoryRepository;

import java.util.List;

public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService() {
        this.categoryRepository = new CategoryRepository();
    }

    public void initDatabase(){
        categoryRepository.createTable();
    }

    public Category insertCategory(String name){
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException(" The name connot be empty");
        }

        return categoryRepository.insert(new Category(name));
    }

    public List<Category> getAllCategories(){
        return categoryRepository.getAll();
    }


}
