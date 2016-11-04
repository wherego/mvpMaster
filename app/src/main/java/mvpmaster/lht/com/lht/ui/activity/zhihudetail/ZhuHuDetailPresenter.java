package mvpmaster.lht.com.lht.ui.activity.zhihudetail;

import mvpmaster.lht.com.lht.base.BasePresenter;
import mvpmaster.lht.com.lht.conf.OkHttpCallBack;
import mvpmaster.lht.com.lht.ui.beanIml.NewsDetailBean;

/**
 * Created by Ly on 2016/11/3.
 */

public class ZhuHuDetailPresenter extends BasePresenter<ZhiHuDetailContract.ZhiHuView> implements ZhiHuDetailContract.ZhuHuPreseter {
    private ZhiHuDetailContract.ZhiHuView zhiHuView;
    private ZhiHuDetailContract.ZhiHuModel zhiHuModel;

    public ZhuHuDetailPresenter(ZhiHuDetailContract.ZhiHuView zhiHuView) {
        this.zhiHuView = zhiHuView;
        zhiHuModel = new ZhiHuDetailModel();
    }

    @Override
    public void dogetDetail(String id) {
        zhiHuModel.dogetDetail(id, new OkHttpCallBack<NewsDetailBean>() {
            @Override
            public void onSuccess(NewsDetailBean newsDetailBean) {
                if (null != newsDetailBean) {
                    zhiHuView.dogetPageData(newsDetailBean);
                } else {
                    zhiHuView.dogetPageFail();
                }
            }

            @Override
            public void onFaild(Throwable e) {
                zhiHuView.dogetPageFail();
            }

            @Override
            public void onFinish() {

            }
        });
    }
}
