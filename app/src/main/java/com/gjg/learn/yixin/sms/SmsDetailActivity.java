package com.gjg.learn.yixin.sms;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.gjg.learn.yixin.MainActivity;
import com.gjg.learn.yixin.R;
import com.gjg.learn.yixin.entity.SmsEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Junguang_Gao on 2016/6/15.
 */
public class SmsDetailActivity extends Activity implements View.OnClickListener {
    private TextView tv_title;
    private ImageButton iv_back;
    private ImageButton iv_about;
    private ImageView iv_keyboard;
    private LinearLayout ll_indicator_up;
    private LinearLayout ll_indicator_down;
    private ImageView iv_keyboard_down;


    private Button bt_help;
    private Button bt_safe_tip;
    private Button bt_more_service;
    private Button bt_activity_center;

    private ListView lv_sms;
    private List<SmsEntity> smsEntityList;
    private SmsListAdapter smsListAdapter;

    private int[] image_sms = new int[]{
            R.drawable.bobo_main_share_thumb, R.drawable.bonus_number_animation_66, R.drawable.bonus_number_animation_163,
            R.drawable.show_event_arena_image_tips, R.drawable.bonus_number_animation_2222, R.drawable.bonus_number_animation_yuanxiao,
            R.drawable.bobo_main_share_thumb, R.drawable.bonus_number_animation_66, R.drawable.bonus_number_animation_163,
            R.drawable.show_event_arena_image_tips, R.drawable.bonus_number_animation_2222, R.drawable.bonus_number_animation_yuanxiao,
            R.drawable.bobo_main_share_thumb, R.drawable.bonus_number_animation_66, R.drawable.bonus_number_animation_163,
            R.drawable.show_event_arena_image_tips, R.drawable.bonus_number_animation_2222, R.drawable.bonus_number_animation_yuanxiao,
            R.drawable.bobo_main_share_thumb, R.drawable.bonus_number_animation_66, R.drawable.bonus_number_animation_163,
            R.drawable.show_event_arena_image_tips, R.drawable.bonus_number_animation_2222, R.drawable.bonus_number_animation_yuanxiao
    };

    private String[] title_sms = new String[]{
            "抽毁灭大锤，看魔兽电影！", "手机双镜头，有什么不一样？", "飞行模式这么好用？谁用谁知道！",
            "郑州4名“黑孩”为入学做亲子鉴定", "外媒：奥巴马今天将会见达赖", "南方大范围暴雨，北方频现冰雹",
            "浙江警方查获1亿多粒毒胶囊", "A股第三次闯关MSCI宣告失败", "轻松一刻：第8次百年一遇暴雨",
            "台湾劳工抗议 要求每周休2天", "男子虐待2岁女儿发图给前妻", "李易峰网络发声破涉毒传闻",
            "抽毁灭大锤，看魔兽电影！", "手机双镜头，有什么不一样？", "飞行模式这么好用？谁用谁知道！",
            "郑州4名“黑孩”为入学做亲子鉴定", "外媒：奥巴马今天将会见达赖", "南方大范围暴雨，北方频现冰雹",
            "浙江警方查获1亿多粒毒胶囊", "A股第三次闯关MSCI宣告失败", "轻松一刻：第8次百年一遇暴雨",
            "台湾劳工抗议 要求每周休2天", "男子虐待2岁女儿发图给前妻", "李易峰网络发声破涉毒传闻"
    };

    private String[] time_sms = new String[]{
            "昨天 08:04", "昨天 08:04", "昨天 08:04",
            "昨天 14:57", "昨天 14:57", "昨天 14:57",
            "今天 10:26", "今天 10:26", "今天 10:26",
            "今天 17:41", "今天 17:41", "今天 17:41",
            "昨天 11:24", "昨天 11:24", "昨天 11:24",
            "昨天 19:57", "昨天 19:57", "昨天 19:57",
            "今天 07:41", "今天 07:41", "今天 07:41",
            "今天 15:41", "今天 15:41", "今天 15:41",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.sms_detail_activity);

        Intent intent = getIntent();
        String sms_title = intent.getStringExtra("sms_title");
        tv_title = (TextView) this.findViewById(R.id.tv_sms_detail_name);
        tv_title.setText(sms_title);

        initView();
        initDatas();

        smsListAdapter = new SmsListAdapter(smsEntityList, SmsDetailActivity.this);
        lv_sms.setAdapter(smsListAdapter);
    }

    /**
     * 模拟新闻消息数据
     */
    private void initDatas() {
        smsEntityList = new ArrayList<SmsEntity>();
        for (int i = 0; i < title_sms.length; i++) {
            SmsEntity sms = new SmsEntity(image_sms[i], title_sms[i], time_sms[i]);
            smsEntityList.add(sms);
        }


    }

    private void initView() {
        iv_back = (ImageButton) this.findViewById(R.id.iv_sms_detail_back);
        iv_back.setOnClickListener(this);
        iv_about = (ImageButton) this.findViewById(R.id.iv_sms_detail_about);
        iv_about.setOnClickListener(this);
        lv_sms = (ListView) this.findViewById(R.id.lv_sms_many);

        bt_help= (Button) this.findViewById(R.id.bt_sms_detail_indicator_help);
        bt_help.setOnClickListener(this);
        bt_safe_tip= (Button) this.findViewById(R.id.bt_sms_detail_indicator_safe_tips);
        bt_safe_tip.setOnClickListener(this);
        bt_more_service= (Button) this.findViewById(R.id.bt_sms_detail_indicator_more_service);
        bt_more_service.setOnClickListener(this);
        bt_activity_center= (Button) this.findViewById(R.id.bt_sms_detail_indicator_activity_center);
        bt_activity_center.setOnClickListener(this);

        iv_keyboard= (ImageView) this.findViewById(R.id.iv_sms_detail_keyboard_message);
        iv_keyboard.setOnClickListener(this);

        ll_indicator_up= (LinearLayout) this.findViewById(R.id.ll_sms_detail_indicator_up);
        ll_indicator_down= (LinearLayout) this.findViewById(R.id.ll_sms_detail_indicator_down);

        iv_keyboard_down= (ImageView) this.findViewById(R.id.iv_sms_indicator_keyboard_down);
        iv_keyboard_down.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_sms_detail_back:
                finish();
                break;
            case R.id.iv_sms_detail_about:
                Intent intent = new Intent(SmsDetailActivity.this, SubscriptionActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
                break;
            case R.id.bt_sms_detail_indicator_help:
                //Log.d("SmsDetailActivity","width--->------- height2--->");
                showPopupWindow1(v);
                Drawable drawable1=getResources().getDrawable(R.drawable.icon_menuitem_expand_down);
                // 这一步必须要做,否则不会显示.
                drawable1.setBounds(0, 0, drawable1.getMinimumWidth(), drawable1.getMinimumHeight());
                bt_help.setCompoundDrawables(drawable1,null,null,null);
                break;
            case R.id.bt_sms_detail_indicator_safe_tips:
                showPopupWindow2(v);
                Drawable drawable2=getResources().getDrawable(R.drawable.icon_menuitem_expand_down);
                // 这一步必须要做,否则不会显示.
                drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                bt_safe_tip.setCompoundDrawables(drawable2,null,null,null);
                break;
            case R.id.bt_sms_detail_indicator_more_service:
                showPopupWindow3(v);
                Drawable drawable3=getResources().getDrawable(R.drawable.icon_menuitem_expand_down);
                // 这一步必须要做,否则不会显示.
                drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                bt_more_service.setCompoundDrawables(drawable3,null,null,null);
                break;
            case R.id.bt_sms_detail_indicator_activity_center:
                showPopupWindow4(v);
                Drawable drawable4=getResources().getDrawable(R.drawable.icon_menuitem_expand_down);
                // 这一步必须要做,否则不会显示.
                drawable4.setBounds(0, 0, drawable4.getMinimumWidth(), drawable4.getMinimumHeight());
                bt_activity_center.setCompoundDrawables(drawable4,null,null,null);
                break;
            case R.id.iv_sms_detail_keyboard_message:
                ll_indicator_up.setVisibility(View.INVISIBLE);
                ll_indicator_down.setVisibility(View.VISIBLE);
                //showKeyBoardPopupWindow(v);
                break;
            case R.id.iv_sms_indicator_keyboard_down:
                ll_indicator_up.setVisibility(View.VISIBLE);
                //ll_indicator_up.scrollBy(0,40);
                ll_indicator_down.setVisibility(View.INVISIBLE);
               // ll_indicator_down.scrollBy(0,-40);
                break;

        }


    }

    private void showPopupWindow4(View v) {
        View contentView= LayoutInflater.from(this).inflate(R.layout.sms_detail_indicator_popwindow4,null);
        contentView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        PopupWindow popupWindow=new PopupWindow(contentView, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT,true);

        popupWindow.setTouchable(true);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });

        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                Drawable drawable=getResources().getDrawable(R.drawable.icon_menuitem_expand_up);
                // 这一步必须要做,否则不会显示.
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                bt_activity_center.setCompoundDrawables(drawable,null,null,null);
            }
        });

        // 实例化一个ColorDrawable颜色为透明
        ColorDrawable dw = new ColorDrawable(0x00000000);
        popupWindow.setBackgroundDrawable(dw);
        popupWindow.setAnimationStyle(R.style.sms_subscription_pop_anim_style);

        // 设置好参数之后再show
        //popupWindow.showAsDropDown(contentView);
        int w = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        bt_activity_center.measure(w, h);
        int height1 = bt_activity_center.getMeasuredHeight();

        int[] location = new int[2];
        v.getLocationOnScreen(location);

        // 在底部显示,注意设置Gravity.NO_GRAVITY使得后面的x,y偏移量生效  直接popupWindow.getHight()得不到，需要用下面的方式得到popupWindow的高度
        popupWindow.showAtLocation(SmsDetailActivity.this.findViewById(R.id.bt_sms_detail_indicator_activity_center),
                Gravity.NO_GRAVITY, location[0], location[1]-popupWindow.getContentView().getMeasuredHeight()+height1/4);



    }

    private void showPopupWindow3(View v) {
        View contentView= LayoutInflater.from(this).inflate(R.layout.sms_detail_indicator_popwindow3,null);
        contentView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        PopupWindow popupWindow=new PopupWindow(contentView, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT,true);

        popupWindow.setTouchable(true);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });

        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                Drawable drawable=getResources().getDrawable(R.drawable.icon_menuitem_expand_up);
                // 这一步必须要做,否则不会显示.
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                bt_more_service.setCompoundDrawables(drawable,null,null,null);
            }
        });

        // 实例化一个ColorDrawable颜色为透明
        ColorDrawable dw = new ColorDrawable(0x00000000);
        popupWindow.setBackgroundDrawable(dw);
        popupWindow.setAnimationStyle(R.style.sms_subscription_pop_anim_style);

        // 设置好参数之后再show
        //popupWindow.showAsDropDown(contentView);
        int w = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        bt_more_service.measure(w, h);
        int height1 = bt_more_service.getMeasuredHeight();

        int[] location = new int[2];
        v.getLocationOnScreen(location);

        // 在底部显示,注意设置Gravity.NO_GRAVITY使得后面的x,y偏移量生效  直接popupWindow.getHight()得不到，需要用下面的方式得到popupWindow的高度
        popupWindow.showAtLocation(SmsDetailActivity.this.findViewById(R.id.bt_sms_detail_indicator_more_service),
                Gravity.NO_GRAVITY, location[0], location[1]-popupWindow.getContentView().getMeasuredHeight()+height1/4);



    }

    private void showPopupWindow2(View v) {
        //popwin_layout.xml的根Layout必须为LinearLayout；如果为RelativeLayout的话，会在第158行代码出现空指针错误，导致程序崩溃
        View contentView= LayoutInflater.from(this).inflate(R.layout.sms_detail_indicator_popwindow2,null);
        //在初始化contentView的时候，强制绘制contentView，并且马上初始化contentView的尺寸
        contentView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        PopupWindow popupWindow=new PopupWindow(contentView, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT,true);

        popupWindow.setTouchable(true);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // 这里如果返回true的话，touch事件将被拦截
                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
                return false;
            }
        });

        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                Drawable drawable=getResources().getDrawable(R.drawable.icon_menuitem_expand_up);
                // 这一步必须要做,否则不会显示.
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                bt_safe_tip.setCompoundDrawables(drawable,null,null,null);
            }
        });

        // 实例化一个ColorDrawable颜色为透明
        ColorDrawable dw = new ColorDrawable(0x00000000);
        popupWindow.setBackgroundDrawable(dw);
        popupWindow.setAnimationStyle(R.style.sms_subscription_pop_anim_style);

        // 设置好参数之后再show
        //popupWindow.showAsDropDown(contentView);
        int w = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        bt_safe_tip.measure(w, h);
        int height1 = bt_safe_tip.getMeasuredHeight();
        int width1 = bt_safe_tip.getMeasuredWidth();

        int[] location = new int[2];
        v.getLocationOnScreen(location);

        // 在底部显示,注意设置Gravity.NO_GRAVITY使得后面的x,y偏移量生效  直接popupWindow.getHight()得不到，需要用下面的方式得到popupWindow的高度
        popupWindow.showAtLocation(SmsDetailActivity.this.findViewById(R.id.bt_sms_detail_indicator_safe_tips),
                Gravity.NO_GRAVITY, location[0], location[1]-popupWindow.getContentView().getMeasuredHeight()+height1/4);



    }


    private void showPopupWindow1(View v) {
        //popwin_layout.xml的根Layout必须为LinearLayout；如果为RelativeLayout的话，会在第158行代码出现空指针错误，导致程序崩溃
        View contentView= LayoutInflater.from(this).inflate(R.layout.sms_detail_indicator_popwindow1,null);
        //在初始化contentView的时候，强制绘制contentView，并且马上初始化contentView的尺寸
        contentView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        PopupWindow popupWindow=new PopupWindow(contentView, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT,true);

        popupWindow.setTouchable(true);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // 这里如果返回true的话，touch事件将被拦截
                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
                return false;
            }
        });

        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                Drawable drawable=getResources().getDrawable(R.drawable.icon_menuitem_expand_up);
                // 这一步必须要做,否则不会显示.
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                bt_help.setCompoundDrawables(drawable,null,null,null);
            }
        });

        // 实例化一个ColorDrawable颜色为透明
        ColorDrawable dw = new ColorDrawable(0x00000000);
        popupWindow.setBackgroundDrawable(dw);
        popupWindow.setAnimationStyle(R.style.sms_subscription_pop_anim_style);

        // 设置好参数之后再show
        //popupWindow.showAsDropDown(contentView);
        int w = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        bt_help.measure(w, h);
        int height1 = bt_help.getMeasuredHeight();
        int width1 = bt_help.getMeasuredWidth();

        int[] location = new int[2];
        v.getLocationOnScreen(location);

        Log.e("SmsDetailActivity","----- location[0]--->"+location[0]);//48  x=35
        Log.e("SmsDetailActivity","---- location[1]--->"+location[1]);//64  y=440
        Log.e("SmsDetailActivity","---- popupWindow.getHeight()--->"+popupWindow.getContentView().getMeasuredHeight());
        // 在底部显示,注意设置Gravity.NO_GRAVITY使得后面的x,y偏移量生效  直接popupWindow.getHight()得不到，需要用下面的方式得到popupWindow的高度
        popupWindow.showAtLocation(SmsDetailActivity.this.findViewById(R.id.bt_sms_detail_indicator_help),
                Gravity.NO_GRAVITY, location[0], location[1]-popupWindow.getContentView().getMeasuredHeight()+height1/4);


    }
}
