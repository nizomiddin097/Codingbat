package uz.developers.codingbat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.developers.codingbat.entity.Category;
import uz.developers.codingbat.payload.Result;
import uz.developers.codingbat.repository.CategoryRepository;
import uz.developers.codingbat.service.CategoryService;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories() {
       return categoryRepository.findAll();
    }

    @Override
    public Category getCategory(Integer id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            return optionalCategory.get();
        }
        return null;
    }

    @Override
    public Result addCategory(Category category) {
        boolean existsByName = categoryRepository.existsByName(category.getName());
        if (existsByName) {
            return new Result("Such category already exist",false);
        }
        categoryRepository.save(category);
        return new Result("Category is saved",true);

    }

    @Override
    public Result editCategory(Integer id, Category category) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isEmpty()) {
            return new Result("Such category is not found",false);
        }
        Category editedCategory = optionalCategory.get();
        editedCategory.setName(category.getName());
        editedCategory.setDescription(category.getDescription());
        categoryRepository.save(editedCategory);
        return new Result("Category is edited",true);
    }

    @Override
    public Result deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
        return new Result("Category is deleted",true);
    }
}
