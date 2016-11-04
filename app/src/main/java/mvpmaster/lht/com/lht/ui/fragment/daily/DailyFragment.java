package mvpmaster.lht.com.lht.ui.fragment.daily;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import butterknife.Bind;
import mvpmaster.lht.com.lht.R;
import mvpmaster.lht.com.lht.base.BaseFragment;
import mvpmaster.lht.com.lht.ui.adapter.DailyAdapter;
import mvpmaster.lht.com.lht.ui.beanIml.DailyBean;

/**
 * Created by Ly on 2016/11/2.
 */

public class DailyFragment extends BaseFragment<DailyContract.DailyView, DailyPresenter> implements DailyContract.DailyView {
    @Bind(R.id.swipe_refresh)
    SwipeRefreshLayout mSwDaily;
    @Bind(R.id.content_list)
    RecyclerView mRcvContent;

    private DailyAdapter mDailyAdapter;
    private LinearLayoutManager linearLayoutManager;

    // 最后一个可见的视图
    private int lastVisibleItem;
    // 是否加载过更多
    private boolean isLoadMore = false;
    // 日报需要的下一个参数
    private String num;

    public static DailyFragment newInstance() {
        Bundle args = new Bundle();
        DailyFragment fragment = new DailyFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setDataRefresh(true);
        mPresenter.loadDailyData(false, "0");
        scrollRecycleView();
    }

    public void scrollRecycleView() {
        mRcvContent.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    lastVisibleItem = linearLayoutManager
                            .findLastVisibleItemPosition();
                    if (linearLayoutManager.getItemCount() == 1) {
                        mDailyAdapter.updateLoadStatus(mDailyAdapter.getLoadMore());
                        return;
                    }
                    if (lastVisibleItem + 1 == linearLayoutManager
                            .getItemCount()) {
                        mDailyAdapter.updateLoadStatus(mDailyAdapter.getLoadPullTo());
                        isLoadMore = true;
                        mDailyAdapter.updateLoadStatus(mDailyAdapter.getLoadMore());
                        mPresenter.loadDailyData(true, num);
                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
            }
        });
    }

    @Override
    public void requestDataRefresh() {
        super.requestDataRefresh();
        setDataRefresh(true);
        mPresenter.loadDailyData(true, "0");
    }

    @Override
    protected DailyPresenter createPresenter() {
        return new DailyPresenter(this);
    }

    @Override
    protected int createViewLayoutId() {
        return R.layout.fragment_zhihu;
    }

    @Override
    public void TsShow(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setDataRefresh(boolean refresh) {
        setRefresh(refresh);
    }

    @Override
    public void loadFinishAndReset(DailyBean dailyBean, String num) {
        setDataRefresh(false);
        mDailyAdapter.resetData(dailyBean);
        this.num = num;
    }

    @Override
    public void loadFinishAndAdd(DailyBean dailyBean, String num) {
        mDailyAdapter.addData(dailyBean);
        this.num = num;
    }

    @Override
    public void loadFailure(String msg) {
        TsShow(msg);
        setDataRefresh(false);
    }

    @Override
    public void loadFinish() {
        setDataRefresh(false);
    }

    @Override
    protected void initView(View rootView) {
        super.initView(rootView);
        mDailyAdapter = new DailyAdapter(mContext);
        linearLayoutManager = new LinearLayoutManager(mContext);
        mRcvContent.setLayoutManager(linearLayoutManager);
        mRcvContent.setAdapter(mDailyAdapter);
    }
}
