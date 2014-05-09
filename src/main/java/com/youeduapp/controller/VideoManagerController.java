package com.youeduapp.controller;

import com.youeduapp.domain.Video;
import com.youeduapp.service.VideoService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author o.villalobos.alfaro
 */
@Controller
public class VideoManagerController {

    @Autowired
    protected VideoService videoService;

    @RequestMapping("/index")
    public String listContacts(Map<String, Object> map) {
        map.put("video", new Video());
        map.put("videoList", videoService.listVideos());
        return "video";
    }

    @RequestMapping("/add")
    public String addContact(@ModelAttribute("video") Video video, BindingResult result) {
        videoService.addVideo(video);
        return "redirect:/index";
    }

    @RequestMapping("/delete/{videoId}")
    public String deleteContact(@PathVariable("videoId") Integer videoId) {
        videoService.removeVideo(videoId);
        return "redirect:/index";
    }

}
