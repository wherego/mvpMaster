package mvpmaster.lht.com.lht.ui.activity.zhihudetail;

import mvpmaster.lht.com.lht.base.BaseContract;
import mvpmaster.lht.com.lht.base.BaseModel;
import mvpmaster.lht.com.lht.base.BaseView;
import mvpmaster.lht.com.lht.conf.OkHttpCallBack;
import mvpmaster.lht.com.lht.ui.beanIml.NewsDetailBean;

/**
 * Created by Ly on 2016/11/3.
 */

public class ZhiHuDetailContract extends BaseContract {

    //V视图
    public interface ZhiHuView extends BaseView {
        void dogetPageData(NewsDetailBean newsDetailBean);
        void dogetPageFail();
    }

    //M 视图
    public interface ZhiHuModel extends BaseModel {
        void dogetDetail(String id, OkHttpCallBack<NewsDetailBean> okHttpCallBack);
    }

    //P视图
    public interface ZhuHuPreseter {
        void dogetDetail(String id);
    }
}
