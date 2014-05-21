package com.youeduapp.dao;

import com.youeduapp.domain.Video;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author o.villalobos.alfaro
 */
@Repository
public class VideoDAOImpl implements VideoDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addVideo(Video video) {
        sessionFactory.getCurrentSession().save(video);
    }

    @Override
    public List<Video> listVideos() {
        return sessionFactory.getCurrentSession().createQuery("from Video").list();
    }

    @Override
    public void removeVideo(Integer id) {
        Video video = (Video) sessionFactory.getCurrentSession().load(Video.class, id);
        if (video != null) {
            sessionFactory.getCurrentSession().delete(video);
        }
    }

}
