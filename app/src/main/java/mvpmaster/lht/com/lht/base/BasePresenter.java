package mvpmaster.lht.com.lht.base;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by Ly on 2016/11/2.
 * base P 层父类
 */

public abstract class BasePresenter<V> {
    protected Reference<V> mViewRef;

    public void attachView(V view) {
        mViewRef = new WeakReference<V>(view);
    }

    protected V getView() {
        return mViewRef.get();
    }

    public boolean isViewAttached() {
        return mViewRef != null && mViewRef.get() != null;
    }

    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }
}
