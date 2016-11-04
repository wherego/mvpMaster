package mvpmaster.lht.com.lht.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.List;

import mvpmaster.lht.com.lht.base.BaseFragment;

/**
 * Created by Ly on 2016/11/2.
 */

public class mainVpAdapter extends FragmentPagerAdapter {
    private List<BaseFragment> list;

    public mainVpAdapter(FragmentManager fm, List<BaseFragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        if (null != list) {
            return list.size();
        } else {
            return 0;
        }
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "知乎";
            case 1:
                return "干货";
            case 2:
                return "日报";
            default:
                return "";
        }
    }
}
