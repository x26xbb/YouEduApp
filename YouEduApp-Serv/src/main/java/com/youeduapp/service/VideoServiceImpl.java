package com.youeduapp.service;

import com.youeduapp.dao.VideoDAO;
import com.youeduapp.domain.Video;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author o.villalobos.alfaro
 */
@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoDAO videoDAO;

    @Transactional
    @Override
    public void addVideo(Video video) {
        videoDAO.addVideo(video);
    }

    @Transactional
    @Override
    public List<Video> listVideos() {
        return videoDAO.listVideos();
    }

    @Transactional
    @Override
    public void removeVideo(Integer id) {
        videoDAO.removeVideo(id);
    }

}
