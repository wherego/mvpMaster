package mvpmaster.lht.com.lht.ui.activity.dailydetail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import butterknife.Bind;
import butterknife.OnClick;
import mvpmaster.lht.com.lht.R;
import mvpmaster.lht.com.lht.base.BaseActivity;
import mvpmaster.lht.com.lht.utils.ShareUtils;

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

    String title = "一个小小app", text = "这篇文章很不错哟", imgPath;

    @OnClick(R.id.fabt_share)
    void share(View view) {
        Log.e("LHT", "share: " + title);
        Log.e("LHT", "share: " + text);
        ShareUtils.shareMsg(mContext, "凌宇", title, text, R.drawable.share_img, false);
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
            text += url;
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
