package mvpmaster.lht.com.lht;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import mvpmaster.lht.com.lht.base.BaseActivity;
import mvpmaster.lht.com.lht.base.BaseFragment;
import mvpmaster.lht.com.lht.base.BasePresenter;
import mvpmaster.lht.com.lht.ui.adapter.mainVpAdapter;
import mvpmaster.lht.com.lht.ui.fragment.daily.DailyFragment;
import mvpmaster.lht.com.lht.ui.fragment.zhuhu.ZhiHuFragment;

public class MainActivity extends BaseActivity {
    @Bind(R.id.tabLayout)
    TabLayout tableLayout;
    @Bind(R.id.content_viewPager)
    ViewPager viewPager;

    private List<BaseFragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initTabLayout();
    }

    private void initTabLayout() {
        fragments = new ArrayList<>();
        fragments.add(ZhiHuFragment.newInstance());
//        fragments.add(GankFragment.newInstance());
        fragments.add(DailyFragment.newInstance());
        viewPager.setOffscreenPageLimit(fragments.size() - 1);
        viewPager.setAdapter(new mainVpAdapter(getSupportFragmentManager(), fragments));
        tableLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_main;
    }
}
