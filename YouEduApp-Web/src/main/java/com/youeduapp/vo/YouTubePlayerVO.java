package com.youeduapp.vo;

/**
 *
 * @author o.villalobos.alfaro
 */
public class YouTubePlayerVO {

    private boolean hideControls = true;
    private boolean autoPlay = true;
    private boolean hideInfo = true;

    public YouTubePlayerVO() {
    
    }  

    /**
     * @return the showControls
     */
    public boolean isHideControls() {
        return hideControls;
    }

    /**
     * @param hideControls the showControls to set
     */
    public void setHideControls(boolean hideControls) {
        this.hideControls = hideControls;
    }

    /**
     * @return the autoPlay
     */
    public boolean isAutoPlay() {
        return autoPlay;
    }

    /**
     * @param autoPlay the autoPlay to set
     */
    public void setAutoPlay(boolean autoPlay) {
        this.autoPlay = autoPlay;
    }

    /**
     * @return the showInfo
     */
    public boolean isHideInfo() {
        return hideInfo;
    }

    /**
     * @param hideInfo the showInfo to set
     */
    public void setHideInfo(boolean hideInfo) {
        this.hideInfo = hideInfo;
    }
}
