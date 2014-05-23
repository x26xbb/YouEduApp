package com.youeduapp.service.interfaces;

import com.youeduapp.domain.Video;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author o.villalobos.alfaro
 */
@Service
public interface VideoService {

    @Transactional
    public String addVideo(Video video);

    @Transactional
    public List<Video> listVideos();

    @Transactional
    public String removeVideo(Integer id);
    
    @Transactional
    public Video findVideoById(Integer videoId);
}
