package com.gjg.learn.yixin;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by Junguang_Gao on 2016/6/8.
 */
public class MenuActivity extends Activity {
    private GridView gd_menu;
    private MenuAdapter menuAdapter;
    private static int[] images=new int[]{
            R.drawable.main_menu_action_chatting,R.drawable.main_menu_action_free_sms,
            R.drawable.main_menu_action_phone_call,R.drawable.main_menu_action_night_icon,
            R.drawable.main_menu_action_scan,R.drawable.main_menu_add_friend
    };
    private static int[] menus_text=new int[]{
            R.string.group_chat,R.string.free_sms,
            R.string.play_phone,R.string.night,
            R.string.scan,R.string.add_friends
    };

    private ImageView iv_close_menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_menu);
        gd_menu= (GridView) this.findViewById(R.id.gridview_menu);
        iv_close_menu= (ImageView) this.findViewById(R.id.iv_close_menu);
        menuAdapter =new MenuAdapter(images,menus_text,MenuActivity.this);
        gd_menu.setAdapter(menuAdapter);
        iv_close_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
