package com.gjg.learn.yixin.sms;

import android.app.ActionBar;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gjg.learn.yixin.R;
import com.gjg.learn.yixin.entity.SmsEntity;

import java.util.List;

/**
 * Created by Junguang_Gao on 2016/6/15.
 */
public class SmsListAdapter extends BaseAdapter {
    private Context context;
    private List<SmsEntity> smsEntities;
    private ViewHolder1 viewHolder1;
    private ViewHolder2 viewHolder2;

    public SmsListAdapter(List<SmsEntity> list, Context con) {
        this.smsEntities = list;
        this.context = con;

    }

    @Override
    public int getCount() {
        return smsEntities.size();
    }

    @Override
    public Object getItem(int position) {
        return smsEntities.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder1 = new ViewHolder1();
        // if(convertView==null){

        viewHolder2 = new ViewHolder2();

        // convertView.setTag(viewHolder);

        /*}else {
            viewHolder= (ViewHolder) convertView.getTag();

        }*/
        SmsEntity sms = smsEntities.get(position);
        int pos = position % 3;
        switch (pos) {
            case 0:
                convertView = LayoutInflater.from(context).inflate(R.layout.sms_list_top_item, null);
                viewHolder1.top_image = (ImageView) convertView.findViewById(R.id.iv_sms_list_top_image);
                viewHolder1.top_title = (TextView) convertView.findViewById(R.id.tv_sms_lsit_top_title);
                // viewHolder1.time= (TextView) convertView.findViewById(R.id.tv_sms_list_time);

                viewHolder1.top_image.setImageResource(sms.getImage_resource_id());
                viewHolder1.top_title.setText(sms.getSms_title());
                //  viewHolder1.time.setText(sms.getSms_receive_time());
                break;
            case 1:

            case 2:
                convertView = LayoutInflater.from(context).inflate(R.layout.sms_list_normal_item, null);
                viewHolder2.normal_image = (ImageView) convertView.findViewById(R.id.iv_sms_list_normal_image);
                viewHolder2.normal_title = (TextView) convertView.findViewById(R.id.tv_sms_lsit_normal_title);
                viewHolder2.normal_image.setImageResource(sms.getImage_resource_id());
                viewHolder2.normal_title.setText(sms.getSms_title());
                if (pos == 2) {
                    //添加发布的时间
                    LinearLayout linearLayout = (LinearLayout) convertView.findViewById(R.id.ll_sms_list_normal_time_contain);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    //linearLayout.setOrientation(LinearLayout.VERTICAL);
                    WindowManager windowManager= (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
                    int width=windowManager.getDefaultDisplay().getWidth();

                    layoutParams.setMargins(width/3, 8, 0, 20);

                    TextView tv = new TextView(context);
                    tv.setText(sms.getSms_receive_time());
                    tv.setTextSize(10);
                    tv.setGravity(Gravity.CENTER);

                    Drawable drawable = context.getResources().getDrawable(R.drawable.sms_list_time_bg);
                    tv.setBackgroundDrawable(drawable);
                    tv.setLayoutParams(layoutParams);

                    //增加行
                    LinearLayout ll = new LinearLayout(context);
                    ll.setOrientation(LinearLayout.VERTICAL);
                    ll.addView(tv);

                    //再增加一行
                    linearLayout.addView(ll);

                }
                break;
        }

        return convertView;
    }

    private static class ViewHolder1 {
        private ImageView top_image;
        private TextView top_title;

        // private TextView time;

    }

    private static class ViewHolder2 {

        private ImageView normal_image;
        private TextView normal_title;
        // private TextView time;

    }
}
