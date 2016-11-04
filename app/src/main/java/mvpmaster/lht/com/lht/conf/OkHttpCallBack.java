package mvpmaster.lht.com.lht.conf;

/**
 * Created by Ly on 2016/10/13.
 */

public interface OkHttpCallBack<T> {
    void onSuccess(T t);//成功的回调

    void onFaild(Throwable e);//失败的回调

    void onFinish();
}
