package uz.developers.codingbat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.developers.codingbat.entity.Category;
import uz.developers.codingbat.payload.Result;
import uz.developers.codingbat.repository.CategoryRepository;
import uz.developers.codingbat.service.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories() {
        return null;
    }

    @Override
    public Category getCategory(Integer id) {
        return null;
    }

    @Override
    public Result addCategory(Category category) {
        return null;
    }

    @Override
    public Result editCategory(Integer id, Category category) {
        return null;
    }

    @Override
    public Result deleteCategory(Integer id) {
        return null;
    }
}
