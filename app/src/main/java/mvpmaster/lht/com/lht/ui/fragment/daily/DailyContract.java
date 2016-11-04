package mvpmaster.lht.com.lht.ui.fragment.daily;

import mvpmaster.lht.com.lht.base.BaseModel;
import mvpmaster.lht.com.lht.base.BaseView;
import mvpmaster.lht.com.lht.conf.OkHttpCallBack;
import mvpmaster.lht.com.lht.ui.beanIml.DailyBean;

/**
 * Created by Ly on 2016/11/3.
 */

public class DailyContract {

    interface DailyView extends BaseView {
        //启动刷新
        void setDataRefresh(boolean refresh);

        // 读取完毕 重设数据
        void loadFinishAndReset(DailyBean dailyBean, String num);

        // 读取完毕 添加数据
        void loadFinishAndAdd(DailyBean dailyBean, String num);

        // 因为各种原因加载失败了
        void loadFailure(String msg);

        void loadFinish();
    }

    interface DailyModel extends BaseModel {
        void loadDailyData(String num, OkHttpCallBack<DailyBean> okHttpCallBack);
    }

    interface DailyPresenter {
        void loadDailyData(boolean isLoadMore, String num);
    }
}
