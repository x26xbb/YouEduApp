package com.youeduapp.helper;

import com.youeduapp.vo.YouTubePlayerVO;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author o.villalobos.alfaro
 */
public class YouTubeHelper {

    private YouTubePlayerVO youTubePlayerVO = new YouTubePlayerVO();

    public String getYouTubeID(String url) {       
        String pattern = "(?<=watch\\?v=|/videos/|embed\\/|.be/|&v=)[^#\\&\\?]*";// aqui se meten las exception de links
        String id = "";
        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(url);
        if (matcher.find()) {
            id = matcher.group();
        }
        return id;
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
