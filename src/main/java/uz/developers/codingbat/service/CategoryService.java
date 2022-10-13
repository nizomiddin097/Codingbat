package uz.developers.codingbat.service;

import uz.developers.codingbat.entity.Category;
import uz.developers.codingbat.payload.Result;

import java.util.List;

public interface CategoryService {
    List<Category> getCategories();

    Category getCategory(Integer id);

    Result addCategory(Category category);

    Result editCategory(Integer id, Category category);

    Result deleteCategory(Integer id);
}
