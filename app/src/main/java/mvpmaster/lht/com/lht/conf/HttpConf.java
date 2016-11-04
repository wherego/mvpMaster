package mvpmaster.lht.com.lht.conf;

/**
 * Created by Ly on 2016/11/2.
 */

public class HttpConf {
    private static final String ZHIHU_BASE_URL = "http://news-at.zhihu.com/api/4/";
    private static final String GANK_BASE_URL = "http://gank.io/api/";
    private static final String DAILY_BASE_URL = "http://app3.qdaily.com/app3/";

    public static String getZhihuBaseUrl() {
        return ZHIHU_BASE_URL;
    }

    public static String getGankBaseUrl() {
        return GANK_BASE_URL;
    }

    public static String getDailyBaseUrl() {
        return DAILY_BASE_URL;
    }
}
