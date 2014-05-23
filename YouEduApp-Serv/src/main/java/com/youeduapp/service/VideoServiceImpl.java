package com.youeduapp.service;

import com.youeduapp.service.interfaces.VideoService;
import com.youeduapp.dao.VideoDAO;
import com.youeduapp.domain.Video;
import com.youeduapp.domain.constants.BusinessContants;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author o.villalobos.alfaro
 */
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoDAO videoDAO;

    @Override
    public String addVideo(Video video) {
        String msg = BusinessContants.SUCCESS_TRANSACTION_CODE;
        try {
            videoDAO.save(video);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            msg = BusinessContants.ERROR_TRANSACTION_CODE;
        }
        return msg;
    }

    @Override
    public List<Video> listVideos() {
        return videoDAO.findAll();
    }

    @Override
    public String removeVideo(Integer id) {
        String msg = BusinessContants.SUCCESS_TRANSACTION_CODE;
        Video videoToDelete = null;
        try {
            videoToDelete = findVideoById(id);
            videoDAO.makeTransient(videoToDelete);
        } catch (Exception be) {
            msg = BusinessContants.ERROR_TRANSACTION_CODE;
            System.err.println(be.getMessage());
        }
        return msg;
    }

    @Override
    public Video findVideoById(Integer videoId) {
        return videoDAO.findById(videoId);
    }

}
