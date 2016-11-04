package mvpmaster.lht.com.lht.ui.fragment.daily;

import mvpmaster.lht.com.lht.base.BasePresenter;
import mvpmaster.lht.com.lht.conf.OkHttpCallBack;
import mvpmaster.lht.com.lht.ui.beanIml.DailyBean;

/**
 * Created by Ly on 2016/11/3.
 */

public class DailyPresenter extends BasePresenter<DailyContract.DailyView> implements DailyContract.DailyPresenter {
    private DailyContract.DailyView dailyView;
    private DailyContract.DailyModel dailyModel;

    public DailyPresenter(DailyContract.DailyView dailyView) {
        this.dailyView = dailyView;
        dailyModel = new DailyModel();
    }

    @Override
    public void loadDailyData(boolean isLoadMore, String num) {
        dailyModel.loadDailyData(num, new OkHttpCallBack<DailyBean>() {
            @Override
            public void onSuccess(DailyBean dailyBean) {
                if (null != dailyBean && null != dailyBean.getResponse()) {
                    if (isLoadMore) {
                        dailyView.loadFinishAndAdd(dailyBean, dailyBean.getResponse().getLast_key());
                    } else {
                        dailyView.loadFinishAndReset(dailyBean, dailyBean.getResponse().getLast_key());
                    }
                } else {
                    dailyView.loadFailure("加载失败了");
                }
            }

            @Override
            public void onFaild(Throwable e) {
                dailyView.loadFailure(e.getMessage());
            }

            @Override
            public void onFinish() {
                dailyView.loadFinish();
            }
        });
    }
}
