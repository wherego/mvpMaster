package mvpmaster.lht.com.lht.ui.fragment.zhuhu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import butterknife.Bind;
import mvpmaster.lht.com.lht.R;
import mvpmaster.lht.com.lht.base.BaseFragment;
import mvpmaster.lht.com.lht.ui.adapter.ZhiHuAdapter;
import mvpmaster.lht.com.lht.ui.beanIml.NewsTimeLine;

/**
 * Created by Ly on 2016/11/2.
 */

public class ZhiHuFragment extends BaseFragment<ZhiHuContract.ZhiHuView, ZhiHuPresenter> implements ZhiHuContract.ZhiHuView {
    @Bind(R.id.content_list)
    RecyclerView mRlvZhiHu;

    private LinearLayoutManager mLayoutManager;
    private ZhiHuAdapter zhiHuAdapter;

    // 最后一个可见的视图
    private int lastVisibleItem;
    // 是否加载过更多
    private boolean isLoadMore = false;
    // 知乎日报需要的下一个参数
    private String time;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initConf();
    }

    /**
     * 初始化配置
     */
    private void initConf() {
//        适配器
        zhiHuAdapter = new ZhiHuAdapter(getActivity());
//        manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRlvZhiHu.setLayoutManager(mLayoutManager);
        mRlvZhiHu.setAdapter(zhiHuAdapter);
//        启动自动刷新配置
        setDataRefresh(true);
//        获取第一次的数据
        mPresenter.getDataList();
//        检测recView的滑动状态
        scrollRecycleView();
    }

    /**
     * recyclerView Scroll listener , maybe in here is wrong ?
     */
    public void scrollRecycleView() {
        mRlvZhiHu.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    lastVisibleItem = mLayoutManager
                            .findLastVisibleItemPosition();
                    if (mLayoutManager.getItemCount() == 1) {
                        zhiHuAdapter.updateLoadStatus(zhiHuAdapter.getLOAD_MORE());
                        return;
                    }
                    if (lastVisibleItem + 1 == mLayoutManager
                            .getItemCount()) {
                        zhiHuAdapter.updateLoadStatus(zhiHuAdapter.getLOAD_PULL_TO());
                        isLoadMore = true;
                        zhiHuAdapter.updateLoadStatus(zhiHuAdapter.getLOAD_MORE());
                        mPresenter.getBeforeDateList(time);
                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = mLayoutManager.findLastVisibleItemPosition();
            }
        });
    }

    @Override
    public void requestDataRefresh() {
        super.requestDataRefresh();
        setDataRefresh(true);
        mPresenter.getDataList();
    }

    @Override
    protected ZhiHuPresenter createPresenter() {
        return new ZhiHuPresenter(this);
    }

    @Override
    protected int createViewLayoutId() {
        return R.layout.fragment_zhihu;
    }

    @Override
    public void setDataRefresh(boolean refresh) {
        setRefresh(refresh);
    }

    public static ZhiHuFragment newInstance() {
        Bundle args = new Bundle();
        ZhiHuFragment fragment = new ZhiHuFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void loadFinishAndReset(NewsTimeLine newsTimeLine, String time) {
        zhiHuAdapter.resetData(newsTimeLine);
        setDataRefresh(false);
        this.time = time;
    }

    @Override
    public void loadFinishAndAdd(NewsTimeLine newsTimeLine, String time) {
        zhiHuAdapter.addData(newsTimeLine);
        this.time = time;
    }

    @Override
    public void loadFailure() {
        setDataRefresh(false);
        zhiHuAdapter.updateLoadStatus(zhiHuAdapter.getLOAD_FAILURE());
    }

    @Override
    protected void initView(View rootView) {
        super.initView(rootView);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRlvZhiHu.setLayoutManager(mLayoutManager);
    }

    @Override
    public void TsShow(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }
}
