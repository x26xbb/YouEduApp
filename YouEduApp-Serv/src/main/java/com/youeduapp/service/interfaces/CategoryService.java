package com.youeduapp.service.interfaces;

import com.youeduapp.domain.Category;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author o.villalobos.alfaro
 */
@Service
public interface CategoryService {

    @Transactional
    public String addCategory(Category video);

    @Transactional
    public List<Category> listCategories();

    @Transactional
    public String removeCategory(Integer id);
    
    @Transactional
    public Category findCategoryById(Integer categoryId);
    
    @Transactional
    public List<Category> findCategoryBy(Category cat);

}
