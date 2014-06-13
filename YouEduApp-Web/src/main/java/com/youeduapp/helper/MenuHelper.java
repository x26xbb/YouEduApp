package com.youeduapp.helper;

import com.youeduapp.domain.Category;
import com.youeduapp.service.interfaces.CategoryService;
import com.youeduapp.service.interfaces.VideoService;
import com.youeduapp.sorting.SortedObject;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author o.villalobos.alfaro
 */
public class MenuHelper {

    @Autowired
    private VideoService videoService;
    @Autowired
    private CategoryService categoryService;

    private SortedObject.SORTING sorting = SortedObject.SORTING.SORT_BY_NAME;

    public Map<String, Object> getMenuList(Map<String, Object> map) {

        List<Category> main = categoryService.listCategories();
        Iterator<Category> i = main.iterator();
        while (i.hasNext()) {
            Category cat = i.next();
            if (cat.getCategoryParent() != null) {
                i.remove();
            } else {
                cat.setSorting(sorting);
            }
        }
        map.put("menu_objects", main);
        map.put("TYPE_CATEGORY", SortedObject.TYPE.TYPE_CATEGORY);
        map.put("TYPE_VIDEO", SortedObject.TYPE.TYPE_VIDEO);
        return map;
    }

    /**
     * @return the sorting
     */
    public SortedObject.SORTING getSorting() {
        return sorting;
    }

    /**
     * @param sorting the sorting to set
     */
    public void setSorting(SortedObject.SORTING sorting) {
        this.sorting = sorting;
    }

}
