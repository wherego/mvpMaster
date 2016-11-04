package mvpmaster.lht.com.lht.base;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.MenuItem;

import butterknife.ButterKnife;
import mvpmaster.lht.com.lht.R;

/**
 * Created by Ly on 2016/11/2.
 */

public abstract class BaseActivity<V, T extends BasePresenter<V>> extends AppCompatActivity {

    protected T mPresenter;
    private AppBarLayout mAppBar;
    private Toolbar mToolbar;
    private SwipeRefreshLayout mRefreshLayout;

    public Context mContext;
    private boolean mIsRequestDataRefresh = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        // 允许为空 不是所有的都要实现这个模式
        if (createPresenter() != null) {
            mPresenter = createPresenter();
            mPresenter.attachView((V) this);
        }
        setContentView(provideContentViewId());
        ButterKnife.bind(this);

        mAppBar = (AppBarLayout) findViewById(R.id.app_bar_layout);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (mToolbar != null && mAppBar != null) {
            setSupportActionBar(mToolbar); //把Toolbar当做ActionBar给设置

            if (canBack()) {
                ActionBar actionBar = getSupportActionBar();
                if (null != actionBar) {
                    //设置ActionBar一个返回箭头，主界面没有，次级界面有
                    actionBar.setDisplayHomeAsUpEnabled(true);
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    //Z轴浮动
                    mAppBar.setElevation(10.6F);
                }
            }
        }
        if (isSetRefresh()) {
            setupSwipeRefresh();
        }

    }

    public static void toIntent(Context context, String... str) {
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // 此时android.R.id.home即为返回箭头
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            finish();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    /**
     * 生成下拉刷新
     */
    private void setupSwipeRefresh() {
        mRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        if (null != mRefreshLayout) {
            mRefreshLayout.setColorSchemeResources(R.color.colorAccent, R.color.colorPrimary);
            mRefreshLayout.setProgressViewOffset(true,
                    0,
                    (int) TypedValue.applyDimension
                            (TypedValue.COMPLEX_UNIT_DIP, 24, getResources()
                                    .getDisplayMetrics()));
        }
    }

    /**
     * 设置刷新
     *
     * @param requestDataRefresh
     */
    public void setRefresh(boolean requestDataRefresh) {
        if (mRefreshLayout == null) {
            return;
        }
        if (!requestDataRefresh) {
            mIsRequestDataRefresh = false;
            mRefreshLayout.postDelayed(() -> {
                if (mRefreshLayout != null) {
                    mRefreshLayout.setRefreshing(false);
                }
            }, 1000);
        } else {
            mRefreshLayout.setRefreshing(true);
        }
    }

    /**
     * 数据刷新
     */
    public void requestDataRefresh() {
        mIsRequestDataRefresh = true;
    }

    /**
     * 判断当前 Activity 是否允许返回
     * 主界面不允许返回，次级界面允许返回
     *
     * @return false
     */
    public boolean canBack() {
        return false;
    }

    /**
     * 判断子Activity是否需要刷新功能
     *
     * @return false
     */
    public Boolean isSetRefresh() {
        return false;
    }

    /**
     * 创建P
     *
     * @return T
     */
    protected abstract T createPresenter();

    /**
     * 用于引入布局文件
     *
     * @return
     */
    abstract protected int provideContentViewId();
}
