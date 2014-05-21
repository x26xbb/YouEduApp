package com.youeduapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *@author o.villalobos.alfaro
 * 
 */

@Entity
@Table(name="VIDEO")
public class Video {
    
    @Id
    @Column(name="ID")
    @GeneratedValue
    private Integer id;
    
    @Column(name="VIDEOURL")
    private String videoURL;
    
    @Column(name="VIDEONAME")
    private String videoName;
    
    @Column(name="VIDEODESC")
    private String videoDescription;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the videoURL
     */
    public String getVideoURL() {
        return videoURL;
    }

    /**
     * @param videoURL the videoURL to set
     */
    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }

    /**
     * @return the videoName
     */
    public String getVideoName() {
        return videoName;
    }

    /**
     * @param videoName the videoName to set
     */
    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    /**
     * @return the videoDescription
     */
    public String getVideoDescription() {
        return videoDescription;
    }

    /**
     * @param videoDescription the videoDescription to set
     */
    public void setVideoDescription(String videoDescription) {
        this.videoDescription = videoDescription;
    }
    


        
}
