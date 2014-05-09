package com.youeduapp.service;

import com.youeduapp.domain.Video;
import java.util.List;

/**
 *
 * @author o.villalobos.alfaro
 */
public interface VideoService {

    public void addVideo(Video video);

    public List<Video> listVideos();

    public void removeVideo(Integer id);

}
