package com.gjg.learn.yixin;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.gjg.learn.yixin.found.FoundFragment;
import com.gjg.learn.yixin.friend.FriendFragment;
import com.gjg.learn.yixin.me.MeFragment;
import com.gjg.learn.yixin.phone.PhoneFragment;
import com.gjg.learn.yixin.sms.SmsFragment;

/**
 * Created by Junguang_Gao on 2016/6/8.
 */
public class MainPagerAdapter extends FragmentPagerAdapter {

    //private String[] TAB_TITLES=getContext().getResources().getStringArray(R.array.tab_page);
    private String[] TAB_TITLES=new String[]{"消息","电话","发现","好友","我"};

    public MainPagerAdapter(FragmentManager supportFragmentManager) {
        super(supportFragmentManager);

    }

    @Override
    public Fragment getItem(int position) {
        Bundle bundle=new Bundle();
        Fragment pageFragment = null;
        switch (position){
            case 0:
                pageFragment=new SmsFragment();
                break;
            case 1:
                pageFragment=new PhoneFragment();
                break;
            case 2:
                pageFragment=new FoundFragment();
                break;
            case 3:
                pageFragment=new FriendFragment();
                break;
            case 4:
                pageFragment=new MeFragment();
                break;

        }

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
