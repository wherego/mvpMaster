package mvpmaster.lht.com.lht.ui.fragment.zhuhu;

import android.util.Log;

import mvpmaster.lht.com.lht.conf.HttpConf;
import mvpmaster.lht.com.lht.conf.OkHttpCallBack;
import mvpmaster.lht.com.lht.ui.beanIml.NewsTimeLine;
import mvpmaster.lht.com.lht.utils.APIService;
import mvpmaster.lht.com.lht.utils.RetrofitUtils;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Ly on 2016/11/2.
 */

public class ZhiHuModel implements ZhiHuContract.ZhiHuModel {

    @Override
    public void getDataList(OkHttpCallBack<NewsTimeLine> okHttpCallBack) {
        RetrofitUtils.getInstance(HttpConf.getZhihuBaseUrl())
                .create(APIService.class)
                .getZhiHuList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<NewsTimeLine>() {
                    @Override
                    public void onCompleted() {
                        okHttpCallBack.onFinish();
                    }

                    @Override
                    public void onError(Throwable e) {
                        okHttpCallBack.onFaild(e);
                    }

                    @Override
                    public void onNext(NewsTimeLine newsTimeLine) {
                        Log.e("LHT", "onNext: " + newsTimeLine.toString());
                        okHttpCallBack.onSuccess(newsTimeLine);
                    }
                });
    }

    @Override
    public void getBeforeDateList(String time, OkHttpCallBack<NewsTimeLine> okHttpCallBack) {
        RetrofitUtils.getInstance(HttpConf.getZhihuBaseUrl())
                .create(APIService.class)
                .getBeforetNews(time)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<NewsTimeLine>() {
                    @Override
                    public void onCompleted() {
                        okHttpCallBack.onFinish();
                    }

                    @Override
                    public void onError(Throwable e) {
                        okHttpCallBack.onFaild(e);
                    }

                    @Override
                    public void onNext(NewsTimeLine newsTimeLine) {
                        okHttpCallBack.onSuccess(newsTimeLine);
                    }
                });
    }


}
