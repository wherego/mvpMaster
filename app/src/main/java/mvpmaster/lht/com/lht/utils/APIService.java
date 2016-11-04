package mvpmaster.lht.com.lht.utils;


import mvpmaster.lht.com.lht.ui.beanIml.DailyBean;
import mvpmaster.lht.com.lht.ui.beanIml.NewsDetailBean;
import mvpmaster.lht.com.lht.ui.beanIml.NewsTimeLine;
import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by Ly on 2016/10/14.
 */

public interface APIService {


    @GET("news/latest")
    Observable<NewsTimeLine> getZhiHuList();

    @GET("news/before/{time}")
    Observable<NewsTimeLine> getBeforetNews(@Path("time") String time);

    @GET("news/{id}")
    Observable<NewsDetailBean> getDetailNews(@Path("id") String id);


    //    for daily
    @GET("homes/index/{num}.json")
    Observable<DailyBean> getDailyTimeLine(@Path("num") String num);

}
