package com.youeduapp.domain;

import com.youeduapp.sorting.SortedObject;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CATEGORY")
public class Category extends SortedObject{

    @Id
    @Column(name = "CATEGORYID")
    @GeneratedValue
    private Integer categoryId;

    @Column(name = "CATEGORYNAME")
    private String categoryName;

    @OneToMany(mappedBy = "category")
    private List<Video> videos = new LinkedList<Video>();

    @ManyToOne //(cascade={CascadeType.ALL})
    @JoinColumn(name = "CATEGORY_PARENT")
    private Category categoryParent;

    @OneToMany(mappedBy = "categoryParent")
    private List<Category> categories = new LinkedList<Category>();
    
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

    public Category() {
        super();
        categoryParent=null;
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

    /**
     * @return the categoryParent
     */
    public Category getCategoryParent() {
        return categoryParent;
    }

    /**
     * @param categoryParent the categoryParent to set
     */
    public void setCategoryParent(Category categoryParent) {
        this.categoryParent = categoryParent;
    }

    /**
     * @return the categories
     */
    public List<Category> getCategories() {
        return categories;
    }

    /**
     * @param categories the categories to set
     */
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
   

    @Override
    public String toString() {
        return getCategoryName();
    }

    @Override
    public String getName() {
        return getCategoryName();        
    }
    

}
