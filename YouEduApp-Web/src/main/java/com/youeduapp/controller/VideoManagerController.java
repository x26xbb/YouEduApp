package com.youeduapp.controller;

import com.youeduapp.domain.Category;
import com.youeduapp.domain.Video;
import com.youeduapp.domain.constants.BusinessContants;
import com.youeduapp.helper.MenuHelper;
import com.youeduapp.helper.YouTubeHelper;
import com.youeduapp.service.interfaces.CategoryService;
import com.youeduapp.service.interfaces.VideoService;
import com.youeduapp.vo.YouTubePlayerVO;
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
    @Autowired
    private YouTubeHelper youTubeHelper;

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

    /**
     *
     * @param map
     * @param videoID
     * @return
     * @throws java.lang.Exception
     */
    @RequestMapping("/video/{videoID}")
    public String videoPage(Map<String, Object> map, @PathVariable("videoID") Integer videoID)
            throws Exception {
        Video video = videoService.findVideoById(videoID);
        if (video == null || video.getVideoURL() == null) {
            throw new Exception("The ID for the video is wrong, v=" + videoID);
        } else {
            menuHelper.getMenuList(map);
            map.put(BusinessContants.DEFAULT_CATEGORY, BusinessContants.DEFAULT_CATEGORY);
            map.put("videoPath", youTubeHelper.getEmbedURL(video.getVideoURL()));
        }
        return "videos/video";
    }

     /**
     *
     * @param map
     * @return
     */
    @RequestMapping("/admin/")
    public String adminHome(Map<String, Object> map) {  
        //in case need to place something in the map
        return "admin/home";
    }
    
    //Category Section
    /**
     *
     * @param map
     * @return
     */
    @RequestMapping("/admin/category")
    public String listCategories(Map<String, Object> map) {
        map.put("category", new Category());
        map.put("categoryList", categoryService.listCategories());
        map.put(BusinessContants.DEFAULT_CATEGORY, BusinessContants.DEFAULT_CATEGORY);
        return "admin/category";
    }
    
  

    /**
     *
     * @param map
     * @return
     */
    @RequestMapping(value = "/admin/player", method = RequestMethod.GET)
    public String youTubeAdmin(Map<String, Object> map) {
        System.out.println(youTubeHelper.getYouTubePlayerVO().isAutoPlay() + "-" + youTubeHelper.getYouTubePlayerVO().isHideControls() + "-" + youTubeHelper.getYouTubePlayerVO().isHideInfo());
        map.put("youTubePlayerVO", youTubeHelper.getYouTubePlayerVO());
        return "admin/player";
    }

    /**
     *
     * @param vo
     * @param redirectAttrs
     * @return
     */
    @RequestMapping(value = "admin/player/submit", method = RequestMethod.POST)
    public String youTubeAdminSubmit(@ModelAttribute("YouTubePlayerVO") YouTubePlayerVO vo, RedirectAttributes redirectAttrs) {
        // ModelAndView mav = listCategories();
        if (vo != null) {
            System.out.println(vo.isAutoPlay() + "-" + vo.isHideControls() + "-" + vo.isHideInfo());
            youTubeHelper.getYouTubePlayerVO().setAutoPlay(vo.isAutoPlay());
            youTubeHelper.getYouTubePlayerVO().setHideControls(vo.isHideControls());
            youTubeHelper.getYouTubePlayerVO().setHideInfo(vo.isHideInfo());
        }
        return "redirect:/admin/player";
    }

    /**
     *
     * @param category
     * @param redirectAttrs
     * @return
     */
    @RequestMapping(value = "/admin/category/add", method = RequestMethod.POST)
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
    @RequestMapping(value = "/admin/category/delete/{categoryId}", method = RequestMethod.GET)
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
    @RequestMapping("/admin/video")
    public String listVideos(Map<String, Object> map
    ) {
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
    @RequestMapping(value = "/admin/video/add", method = RequestMethod.POST)
    public String addVideo(@ModelAttribute("video") Video video, RedirectAttributes redirectAttrs) {
        if (video != null && video.getCategory() != null) {
            Category cat = categoryService.findCategoryById(Integer.parseInt(video.getCategory().getCategoryName()));
            if (cat != null) {
                video.setCategory(cat);
                video.setVideoURL(youTubeHelper.getYouTubeID(video.getVideoURL()));
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
    @RequestMapping(value = "/admin/video/delete/{videoId}", method = RequestMethod.GET)
    public String deleteVideo(@PathVariable("videoId") Integer videoId, RedirectAttributes redirectAttrs) {
        redirectAttrs.addFlashAttribute(BusinessContants.PROCESS_RESULT, videoService.removeVideo(videoId));
        return "redirect:/admin/video";
    }

}
