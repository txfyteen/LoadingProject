package com.hrobbie.loadingproject.fragment;

import android.support.v4.app.Fragment;

/**
 * user:HRobbie
 * Date:2017/2/28
 * Time:18:02
 * 邮箱：hwwyouxiang@163.com
 * Description:Page Function.
 */

public abstract class BaseFragment extends Fragment {
    protected boolean isVisible;
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (getUserVisibleHint()){
            isVisible=true;
            onVisible();
        }else {
            isVisible=false;
            onInvisible();
        }
    }

    /**
     * visible->lazyLoad
     */
    protected void onVisible() {
        lazyLoad();
    }
    /**
     * 显示时加载数据,需要这样的使用
     * 注意声明 isPrepared，先初始化
     * 生命周期会先执行 setUserVisibleHint 再执行onActivityCreated
     * 在 onActivityCreated 之后第一次显示加载数据，只加载一次
     */
    protected abstract void lazyLoad();
    protected void onInvisible() {

    }
}
