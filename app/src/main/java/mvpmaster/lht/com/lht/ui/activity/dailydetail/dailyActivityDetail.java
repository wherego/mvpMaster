package mvpmaster.lht.com.lht.ui.activity.dailydetail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import butterknife.Bind;
import mvpmaster.lht.com.lht.R;
import mvpmaster.lht.com.lht.base.BaseActivity;

/**
 * Created by Ly on 2016/11/4.
 */

public class dailyActivityDetail extends BaseActivity<dailyActivityContract.dailyDetailView, dailyActivityPresenter> implements dailyActivityContract.dailyDetailView {

    @Bind(R.id.web_view)
    WebView webView;

    public static void toIntent(Context context, String... str) {
        Intent intent = new Intent(context, dailyActivityDetail.class);
        Bundle bundle = new Bundle();
        if (str.length > 0)
            bundle.putString("url", str[0]);
        intent.putExtra("extra", bundle);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        Bundle bundle = getIntent().getBundleExtra("extra");
        if (null != bundle) {
            String url = bundle.getString("url");
            webView.loadUrl(url);
        }
    }

    @Override
    protected dailyActivityPresenter createPresenter() {
        return null;
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_detail_daily;
    }

    @Override
    public void TsShow(String msg) {

    }
}
