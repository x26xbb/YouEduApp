package com.youeduapp.controller;

import com.youeduapp.domain.Category;
import com.youeduapp.domain.Video;
import com.youeduapp.service.interfaces.CategoryService;
import com.youeduapp.service.interfaces.VideoService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
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

    private static final String DEFAULT_CATEGORY = "DEFAULT_CATEGORY";
    private static final String PROCESS_RESULT = "PROCESS_RESULT";

    //Category Section
    /**
     *
     * @param map
     * @return
     */
    @RequestMapping("/category")
    public String listCategories(Map<String, Object> map) {
        map.put("category", new Category());
        map.put("categoryList", categoryService.listCategories());
        map.put(DEFAULT_CATEGORY, DEFAULT_CATEGORY);
        return "category";
    }

    /**
     *
     * @param category
     * @param redirectAttrs
     * @return
     */
    @RequestMapping(value = "/category/add", method = RequestMethod.POST)
    public String addCategory(@ModelAttribute("category") Category category,  RedirectAttributes redirectAttrs) {
       // ModelAndView mav = listCategories();
        if (category != null) {
            if (category.getCategoryParent() != null
                    && category.getCategoryParent().getCategoryName().equals(DEFAULT_CATEGORY)) {
                category.setCategoryParent(null);
            }
            redirectAttrs.addFlashAttribute(PROCESS_RESULT, categoryService.addCategory(category));
        }
        return "redirect:/category";
    }

    /**
     *
     * @param categoryId
     * @param redirectAttrs
     * @return
     */
    @RequestMapping(value = "/category/delete/{categoryId}", method = RequestMethod.GET)
    public String deleteCategory(@PathVariable("categoryId") Integer categoryId, RedirectAttributes redirectAttrs) {
        redirectAttrs.addFlashAttribute(PROCESS_RESULT, categoryService.removeCategory(categoryId));
        return "redirect:/category";
    }

    //Video Section
    /**
     *
     * @return
     */
    @RequestMapping("/video")
    public ModelAndView listVideos() {
        ModelAndView mav = new ModelAndView("video");
        mav.addObject("video", new Video());
        mav.addObject("categoryList", categoryService.listCategories());
        mav.addObject("videoList", videoService.listVideos());
        return mav;
    }

    /**
     *
     * @param video
     * @param result
     * @return
     */
    @RequestMapping("/video/add")
    public ModelAndView addVideo(@ModelAttribute("video") Video video, BindingResult result) {
        ModelAndView mav = listVideos();
        mav.getModelMap().addAttribute(PROCESS_RESULT, videoService.addVideo(video));
        return mav;

    }

    /**
     *
     * @param videoId
     * @return
     */
    @RequestMapping("/video/delete/{videoId}")
    public ModelAndView deleteVideo(@PathVariable("videoId") Integer videoId) {
        //ModelAndView mav = listVideos();
        ModelAndView mav = new ModelAndView("redirect:/video");
        mav.addObject(PROCESS_RESULT, videoService.removeVideo(videoId));
        return mav;
    }

}
