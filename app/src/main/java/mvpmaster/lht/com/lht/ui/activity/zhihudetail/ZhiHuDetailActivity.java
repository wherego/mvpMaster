package mvpmaster.lht.com.lht.ui.activity.zhihudetail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import butterknife.Bind;
import butterknife.OnClick;
import mvpmaster.lht.com.lht.R;
import mvpmaster.lht.com.lht.base.BaseActivity;
import mvpmaster.lht.com.lht.ui.beanIml.NewsDetailBean;
import mvpmaster.lht.com.lht.utils.ShareUtils;


/**
 * Created by Ly on 2016/11/3.
 */

public class ZhiHuDetailActivity extends BaseActivity
        <ZhiHuDetailContract.ZhiHuView, ZhuHuDetailPresenter>
        implements ZhiHuDetailContract.ZhiHuView {

    // 新闻的id
    private String id;

    @Bind(R.id.web_view)
    WebView mWbHtmlPage;
    @Bind(R.id.iv_web_img)
    ImageView mIvWebImg;
    @Bind(R.id.tv_img_title)
    TextView mTvWebTitle;
    @Bind(R.id.tv_img_source)
    TextView mTvWebImgSource;


    String title, text, imgPath;

    @OnClick(R.id.fabt_share)
    void share(View view) {
        Log.e("LHT", "share: " + title);
        Log.e("LHT", "share: " + text);
        ShareUtils.shareMsg(mContext, "凌宇", text, title, R.drawable.share_img, true);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dogetExtra();

    }

    private void dogetExtra() {
        Bundle bundle = getIntent().getBundleExtra("extra");
        if (bundle != null) {
            id = bundle.getString("id");
        }
        mPresenter.dogetDetail(id);
    }

    public static void ZhiHuDetailActivity(Context context, String id) {
        Intent intnet = new Intent(context, ZhiHuDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("id", id);
        intnet.putExtra("extra", bundle);
        context.startActivity(intnet);
    }


    @Override
    public void TsShow(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected ZhuHuDetailPresenter createPresenter() {
        return new ZhuHuDetailPresenter(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_detail_zhihu;
    }

    @Override
    public void dogetPageData(NewsDetailBean newsDetailBean) {
        WebSettings settings = mWbHtmlPage.getSettings();
        settings.setJavaScriptEnabled(true);
        mWbHtmlPage.setWebViewClient(new WebViewClient());
        mWbHtmlPage.setWebChromeClient(new WebChromeClient());
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        if (newsDetailBean.getCss().size() > 0) {
            String head = "<head>\n" +
                    "\t<link rel=\"stylesheet\" href=\"" + newsDetailBean.getCss().get(0) + "\"/>\n" +
                    "</head>";
            String img = "<div class=\"headline\">";
            String html = head + newsDetailBean.getBody().replace(img, " ");
            mWbHtmlPage.loadDataWithBaseURL(null, html, "text/html", "utf-8", null);
        }
        title = newsDetailBean.getTitle();
        text = newsDetailBean.getImage_source();
        imgPath = newsDetailBean.getImage();
        Glide.with(mContext).load(imgPath).centerCrop().into(mIvWebImg);
        mTvWebTitle.setText(title);
        mTvWebImgSource.setText(text);
    }

    @Override
    public void dogetPageFail() {

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getRepeatCount() == 0) {
            if (mWbHtmlPage.canGoBack()) {
                mWbHtmlPage.goBack();
            } else {
                finish();
            }
        }
        return false;
    }
}
