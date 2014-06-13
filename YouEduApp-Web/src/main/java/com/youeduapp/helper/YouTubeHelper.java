package com.youeduapp.helper;

import com.youeduapp.vo.YouTubePlayerVO;

/**
 *
 * @author o.villalobos.alfaro
 */
public class YouTubeHelper {

    
    private YouTubePlayerVO youTubePlayerVO = new YouTubePlayerVO();
    
    
    public String getYouTubeID(String url) {
        return "dsYMa44m69g";
    }

    public String getEmbedURL(String youTubeVideoID) {
        StringBuilder ss = new StringBuilder();
        ss.append("http://www.youtube.com/embed/");
        ss.append(youTubeVideoID);
        ss.append("?rel=0");
        if (getYouTubePlayerVO().isHideControls()) {
            ss.append("&controls=0");
        }
        if (getYouTubePlayerVO().isAutoPlay()) {
            ss.append("&autoplay=1");
        }
        if (getYouTubePlayerVO().isHideInfo()) {
            ss.append("&showinfo=0");
        }
        ss.append("&html5=True");
        return ss.toString();
    }

    /**
     * @return the youTubePlayerVO
     */
    public YouTubePlayerVO getYouTubePlayerVO() {
        return youTubePlayerVO;
    }

    /**
     * @param youTubePlayerVO the youTubePlayerVO to set
     */
    public void setYouTubePlayerVO(YouTubePlayerVO youTubePlayerVO) {
        this.youTubePlayerVO = youTubePlayerVO;
    }   
    
    
}
