package com.gjg.learn.yixin;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

/**
 * Created by Junguang_Gao on 2016/6/8.
 */
public class MyPagerAdapter extends FragmentPagerAdapter {
    private Context context;

    public Context getContext() {
        return context;
    }


    //private String[] TAB_TITLES=getContext().getResources().getStringArray(R.array.tab_page);
    private String[] TAB_TITLES=new String[]{"消息","电话","发现","好友","我"};

    public MyPagerAdapter(FragmentManager supportFragmentManager) {
        super(supportFragmentManager);

    }

    @Override
    public Fragment getItem(int position) {
        Bundle bundle=new Bundle();
        Fragment pageFragment=new Fragment();
        bundle.putInt("page_num",position);
        pageFragment.setArguments(bundle);
        return pageFragment;
    }

    @Override
    public int getCount() {
        return TAB_TITLES.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TAB_TITLES[position];
    }
}
