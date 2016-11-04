package mvpmaster.lht.com.lht.ui.fragment.zhuhu;

import mvpmaster.lht.com.lht.base.BaseContract;
import mvpmaster.lht.com.lht.base.BaseModel;
import mvpmaster.lht.com.lht.base.BaseView;
import mvpmaster.lht.com.lht.conf.OkHttpCallBack;
import mvpmaster.lht.com.lht.ui.beanIml.NewsTimeLine;

/**
 * Created by Ly on 2016/11/2.
 */

public class ZhiHuContract extends BaseContract {

    //    view 视图
    public interface ZhiHuView extends BaseView {
        //启动刷新
        void setDataRefresh(boolean refresh);

        // 读取完毕 重设数据
        void loadFinishAndReset(NewsTimeLine newsTimeLine, String time);

        // 读取完毕 添加数据
        void loadFinishAndAdd(NewsTimeLine newsTimeLine, String time);

        // 因为各种原因加载失败了
        void loadFailure();
    }

    public interface ZhiHuModel extends BaseModel {
        //拿到第一次的数据
        void getDataList(OkHttpCallBack<NewsTimeLine> okHttpCallBack);

        //拿到后续的数据
        void getBeforeDateList(String time, OkHttpCallBack<NewsTimeLine> okHttpCallBack);
    }

    public interface ZhiHuPresenter {
        //拿到第一次的数据
        void getDataList();

        //拿到后续的数据
        void getBeforeDateList(String time);
    }

}
