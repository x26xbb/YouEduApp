package com.youeduapp.domain;

import com.youeduapp.sorting.SortedObject;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author o.villalobos.alfaro
 *
 */
@Entity
@Table(name = "VIDEO")
public class Video extends SortedObject {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;

    @Column(name = "VIDEOURL")
    private String videoURL;

    @Column(name = "VIDEONAME")
    private String videoName;

    @Column(name = "VIDEODESC")
    private String videoDescription;

    @ManyToOne
    @JoinColumn(name = "CATEGORY")
    private Category category;

     @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATECREATED")
    protected Date dateCreated;

    /**
     * @return the dateCreated
     */
    public Date getDateCreated() {
        return dateCreated;
    }

    /**
     * @param dateCreated the dateCreated to set
     */
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
    
    public Video() {
        super();
    }

    public Video(String videoURL, String videoName, String videoDescription) {
        this.videoURL = videoURL;
        this.videoName = videoName;
        this.videoDescription = videoDescription;
    }

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

    /**
     * @return the category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return getVideoName();
    }

    @Override
    public String getName() {
        return getVideoName();
    }

}
