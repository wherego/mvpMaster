package mvpmaster.lht.com.lht.ui.fragment.zhuhu;

import mvpmaster.lht.com.lht.base.BasePresenter;
import mvpmaster.lht.com.lht.conf.OkHttpCallBack;
import mvpmaster.lht.com.lht.ui.beanIml.NewsTimeLine;

/**
 * Created by Ly on 2016/11/2.
 */

public class ZhiHuPresenter extends BasePresenter<ZhiHuContract.ZhiHuView> implements ZhiHuContract.ZhiHuPresenter {
    private ZhiHuContract.ZhiHuView zhiHuView;
    private ZhiHuContract.ZhiHuModel zhiHuModel;

    public ZhiHuPresenter(ZhiHuContract.ZhiHuView zhiHuView) {
        this.zhiHuView = zhiHuView;
        zhiHuModel = new ZhiHuModel();
    }


    @Override
    public void getDataList() {
        zhiHuModel.getDataList(new OkHttpCallBack<NewsTimeLine>() {
            @Override
            public void onSuccess(NewsTimeLine newsTimeLine) {
                zhiHuView.loadFinishAndReset(newsTimeLine, newsTimeLine.getDate());
            }

            @Override
            public void onFaild(Throwable e) {
                loadError(e);
                zhiHuView.loadFailure();
            }

            @Override
            public void onFinish() {

            }
        });
    }

    @Override
    public void getBeforeDateList(String time) {
        zhiHuModel.getBeforeDateList(time, new OkHttpCallBack<NewsTimeLine>() {
            @Override
            public void onSuccess(NewsTimeLine newsTimeLine) {
                zhiHuView.loadFinishAndAdd(newsTimeLine, newsTimeLine.getDate());
            }

            @Override
            public void onFaild(Throwable e) {
                loadError(e);
                zhiHuView.loadFailure();
            }

            @Override
            public void onFinish() {

            }
        });
    }

    private void loadError(Throwable throwable) {
        throwable.printStackTrace();
        zhiHuView.TsShow(throwable.getMessage());
    }
}
