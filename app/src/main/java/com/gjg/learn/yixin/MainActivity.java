package com.gjg.learn.yixin;

import android.content.Intent;
import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v4.widget.ViewDragHelper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;

import com.astuetz.PagerSlidingTabStrip;

import java.lang.reflect.Field;

public class MainActivity extends FragmentActivity {
    private PagerSlidingTabStrip pagerSlidingTabStrip;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if((Build.VERSION.SDK_INT >= 10) & (Build.VERSION.SDK_INT < 21)) {
            setOverflowButtonAlways();
        }
        //不显示actionbar上的图标
        getActionBar().setDisplayShowHomeEnabled(false);

        pagerSlidingTabStrip= (PagerSlidingTabStrip) this.findViewById(R.id.pager_tabs);
        viewPager= (ViewPager) this.findViewById(R.id.pager);
        //设置滑动的页面数
        viewPager.setOffscreenPageLimit(5);
        viewPager.setAdapter(new MainPagerAdapter(getSupportFragmentManager()));
        pagerSlidingTabStrip.setViewPager(viewPager);






    }

    private void setOverflowButtonAlways() {
        try {
            ViewConfiguration configuration=ViewConfiguration.get(this);
            Field field=ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            field.setAccessible(true);
            field.setBoolean(configuration,false);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_add:
                Intent intent=new Intent(MainActivity.this,MenuActivity.class);
                startActivity(intent);
                break;
        }

        return super.onMenuItemSelected(featureId, item);
    }
}
