package com.youeduapp.controller;

import com.youeduapp.domain.Category;
import com.youeduapp.domain.Video;
import com.youeduapp.domain.constants.BusinessContants;
import com.youeduapp.helper.MenuHelper;
import com.youeduapp.service.interfaces.CategoryService;
import com.youeduapp.service.interfaces.VideoService;
import com.youeduapp.sorting.SortedObject;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author o.villalobos.alfaro
 */
@Controller
public class VideoManagerController {

    @Autowired
    private VideoService videoService;
    @Autowired
    private CategoryService categoryService;    
    @Autowired
    private MenuHelper menuHelper;
    
    //Category Section
    /**
     *
     * @param map
     * @return
     */
    @RequestMapping("/")
    public String homePage(Map<String, Object> map) {       
        //map.put("categoryList", categoryService.listCategories());
        menuHelper.getMenuList(map);
        map.put(BusinessContants.DEFAULT_CATEGORY, BusinessContants.DEFAULT_CATEGORY);
        return "videos/home";
    }
    
    //Category Section
    /**
     *
     * @param map
     * @return
     */
    @RequestMapping("admin/category")
    public String listCategories(Map<String, Object> map) {
        map.put("category", new Category());
        map.put("categoryList", categoryService.listCategories());
        map.put(BusinessContants.DEFAULT_CATEGORY, BusinessContants.DEFAULT_CATEGORY);
        return "admin/category";
    }

    /**
     *
     * @param category
     * @param redirectAttrs
     * @return
     */
    @RequestMapping(value = "admin/category/add", method = RequestMethod.POST)
    public String addCategory(@ModelAttribute("category") Category category, RedirectAttributes redirectAttrs) {
        // ModelAndView mav = listCategories();
        if (category != null) {
            redirectAttrs.addFlashAttribute(BusinessContants.PROCESS_RESULT, categoryService.addCategory(category));
        }
        return "redirect:/admin/category";
    }

    /**
     *
     * @param categoryId
     * @param redirectAttrs
     * @return
     */
    @RequestMapping(value = "admin/category/delete/{categoryId}", method = RequestMethod.GET)
    public String deleteCategory(@PathVariable("categoryId") Integer categoryId, RedirectAttributes redirectAttrs) {
        redirectAttrs.addFlashAttribute(BusinessContants.PROCESS_RESULT, categoryService.removeCategory(categoryId));
        return "redirect:/admin/category";
    }

    //Video Section
    /**
     *
     * @param map
     * @return
     */
    @RequestMapping("admin/video")
    public String listVideos(Map<String, Object> map) {
        map.put("video", new Video());
        map.put("videoList", videoService.listVideos());
        map.put("categoryList", categoryService.listCategories());
        map.put(BusinessContants.DEFAULT_CATEGORY, BusinessContants.DEFAULT_CATEGORY);
        return "admin/video";
    }

    /**
     *
     * @param video
     * @param redirectAttrs
     * @return
     */
    @RequestMapping(value = "admin/video/add", method = RequestMethod.POST)
    public String addVideo(@ModelAttribute("video") Video video, RedirectAttributes redirectAttrs) {
        if (video != null && video.getCategory() != null) {
            Category cat = categoryService.findCategoryById(Integer.parseInt(video.getCategory().getCategoryName()));
            if(cat != null ){
                video.setCategory(cat);
                redirectAttrs.addFlashAttribute(BusinessContants.PROCESS_RESULT, videoService.addVideo(video));
            }            
        }
        return "redirect:/admin/video";
    }

    /**
     *
     * @param videoId
     * @param redirectAttrs
     * @return
     */
    @RequestMapping(value = "admin/video/delete/{videoId}", method = RequestMethod.GET)
    public String deleteVideo(@PathVariable("videoId") Integer videoId, RedirectAttributes redirectAttrs) {
        redirectAttrs.addFlashAttribute(BusinessContants.PROCESS_RESULT, videoService.removeVideo(videoId));
        return "redirect:/admin/video";
    }
    
    
    

}
