package mvpmaster.lht.com.lht.utils;

import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by Ly on 2016/10/14.
 */

public class RetrofitUtils {
    private static final int READ_TIMEOUT = 60;//读取超时时间 单位 秒
    private static final int CONN_TIMEOUT = 60;//连接超时时间 单位 秒
    private static Retrofit retrofit;

    public RetrofitUtils() {
    }

    public static Retrofit getInstance(String url) {
        retrofit = null;
        // 初始化一个okhttpClicent的对象 不然ref会自己添加一个
        OkHttpClient client = new OkHttpClient();
//        设置读取时间为1分钟
        client.setReadTimeout(READ_TIMEOUT, TimeUnit.MINUTES);
//        设置链接时间为12s
        client.setConnectTimeout(CONN_TIMEOUT, TimeUnit.SECONDS);
        retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit;
    }
}
