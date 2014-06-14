package com.youeduapp.service;

import com.youeduapp.dao.CategoryDAO;
import com.youeduapp.domain.Category;
import com.youeduapp.domain.constants.BusinessContants;
import com.youeduapp.service.interfaces.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author o.villalobos.alfaro
 */
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    public String addCategory(Category category) {
        String msg = BusinessContants.SUCCESS_TRANSACTION_CODE;
        try {
            //For some reason it sends the Id to the Name of the Category! 
            //Maybe because it finds a String instead of a Int 
            category.setCategoryParent((category.getCategoryParent() != null
                    && category.getCategoryParent().getCategoryName().equals(BusinessContants.DEFAULT_CATEGORY))
                    ? null
                    : findCategoryById(Integer.parseInt(category.getCategoryParent().getCategoryName())));

            categoryDAO.save(category);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            msg = BusinessContants.ERROR_TRANSACTION_CODE;
        }
        return msg;

    }

    @Override
    public List<Category> listCategories() {
        return categoryDAO.findAll();
    }

    @Override
    public String removeCategory(Integer id) {
        Category categoryToDelete = null;
        String msg = BusinessContants.SUCCESS_TRANSACTION_CODE;
        try {
            categoryToDelete = findCategoryById(id);
            if (categoryToDelete.getCategories() != null && !categoryToDelete.getCategories().isEmpty()) {
                throw new Exception("Impossible to erase this Category");
            }
            categoryDAO.makeTransient(categoryToDelete);
        } catch (Exception be) {
            System.err.println(be.getMessage());
            msg = BusinessContants.ERROR_TRANSACTION_CODE;
        }
        return msg;
    }

    @Override
    public Category findCategoryById(Integer categoryId) {
        return categoryDAO.findById(categoryId);
    }

    @Override
    public List<Category> findCategoryBy(Category cat) {
        return categoryDAO.findByExample(cat, "");
    }

}
