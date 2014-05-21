package com.youeduapp.domain;

import java.util.LinkedList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORY")
public class Category {

    @Id
    @Column(name = "CATEGORYID")
    @GeneratedValue
    private Integer categoryId;

    @Column(name = "CATEGORYNAME")
    private String categoryName;

    @OneToMany(mappedBy = "CATEGORY")
    private List<Video> videos = new LinkedList<Video>();

    public Category() {
    }

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * @return the categoryId
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId the categoryId to set
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @return the categoryName
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * @param categoryName the categoryName to set
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * @return the videos
     */
    public List<Video> getVideos() {
        return videos;
    }

    /**
     * @param videos the videos to set
     */
    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

}
