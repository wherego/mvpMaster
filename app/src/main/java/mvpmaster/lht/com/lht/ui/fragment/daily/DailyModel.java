package mvpmaster.lht.com.lht.ui.fragment.daily;

import mvpmaster.lht.com.lht.conf.HttpConf;
import mvpmaster.lht.com.lht.conf.OkHttpCallBack;
import mvpmaster.lht.com.lht.ui.beanIml.DailyBean;
import mvpmaster.lht.com.lht.utils.APIService;
import mvpmaster.lht.com.lht.utils.RetrofitUtils;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Ly on 2016/11/3.
 */

public class DailyModel implements DailyContract.DailyModel {
    @Override
    public void loadDailyData(String num, OkHttpCallBack<DailyBean> okHttpCallBack) {
//        RetrofitUtils.getInstance(HttpConf.getDailyBaseUrl())
//                .create(APIService.class)
//                .getDailyTimeLine(num)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(dailyBean -> {
//                    if (dailyBean.getMeta().getMsg().equals("success")) {
//                        okHttpCallBack.onSuccess(dailyBean);
//                    }
//                });
        RetrofitUtils.getInstance(HttpConf.getDailyBaseUrl())
                .create(APIService.class)
                .getDailyTimeLine(num)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<DailyBean>() {
                    @Override
                    public void onCompleted() {
                        okHttpCallBack.onFinish();
                    }

                    @Override
                    public void onError(Throwable e) {
                        okHttpCallBack.onFaild(e);
                    }

                    @Override
                    public void onNext(DailyBean dailyBean) {
                        okHttpCallBack.onSuccess(dailyBean);
                    }
                });
    }
}
