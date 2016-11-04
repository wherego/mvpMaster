package mvpmaster.lht.com.lht.ui.activity.zhihudetail;

import mvpmaster.lht.com.lht.conf.HttpConf;
import mvpmaster.lht.com.lht.conf.OkHttpCallBack;
import mvpmaster.lht.com.lht.ui.beanIml.NewsDetailBean;
import mvpmaster.lht.com.lht.utils.APIService;
import mvpmaster.lht.com.lht.utils.RetrofitUtils;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Ly on 2016/11/3.
 */

public class ZhiHuDetailModel implements ZhiHuDetailContract.ZhiHuModel {
    @Override
    public void dogetDetail(String id, OkHttpCallBack<NewsDetailBean> okHttpCallBack) {
        RetrofitUtils.getInstance(HttpConf.getZhihuBaseUrl())
                .create(APIService.class)
                .getDetailNews(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<NewsDetailBean>() {
                    @Override
                    public void onCompleted() {
                        okHttpCallBack.onFinish();
                    }

                    @Override
                    public void onError(Throwable e) {
                        okHttpCallBack.onFaild(e);
                    }

                    @Override
                    public void onNext(NewsDetailBean newsDetailBean) {
                        okHttpCallBack.onSuccess(newsDetailBean);
                    }
                });
    }
}
