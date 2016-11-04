package mvpmaster.lht.com.lht.ui.fragment;

import android.os.Bundle;

import mvpmaster.lht.com.lht.base.BaseFragment;
import mvpmaster.lht.com.lht.base.BasePresenter;

/**
 * Created by Ly on 2016/11/2.
 */

public class GankFragment extends BaseFragment {
    public static GankFragment newInstance() {
        Bundle args = new Bundle();
        GankFragment fragment = new GankFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int createViewLayoutId() {
        return 0;
    }
}
