package com.gjg.learn.yixin.sms;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.gjg.learn.yixin.R;
import com.gjg.learn.yixin.entity.SmsEntity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by Junguang_Gao on 2016/6/10.
 */
public class SmsFragmentAdapter extends BaseAdapter{

    private List<SmsEntity> smsEntityList;
    private Context context;

    public SmsFragmentAdapter(List<SmsEntity> list, Context cont){
        this.context=cont;
        this.smsEntityList=list;
    }



    @Override
    public int getCount() {
        return smsEntityList.size();
    }

    @Override
    public Object getItem(int position) {
        return smsEntityList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return smsEntityList.get(position).getImage_resource_id();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if(convertView==null){
            viewHolder=new ViewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.sms_fragment_item,null);

            viewHolder.sms_image_id= (ImageView) convertView.findViewById(R.id.iv_sms_id);

            viewHolder.sms_title= (TextView) convertView.findViewById(R.id.tv_sms_title);

            viewHolder.sms_content= (TextView) convertView.findViewById(R.id.tv_sms_content);

            viewHolder.sms_time= (TextView) convertView.findViewById(R.id.tv_sms_time);

            viewHolder.sms_remind= (TextView) convertView.findViewById(R.id.tv_sms_remind);

            convertView.setTag(viewHolder);

        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.sms_image_id.setImageResource(smsEntityList.get(position).getImage_resource_id());
        viewHolder.sms_title.setText(smsEntityList.get(position).getSms_title());
        viewHolder.sms_content.setText(smsEntityList.get(position).getSms_content());
        viewHolder.sms_time.setText(smsEntityList.get(position).getSms_receive_time());
        if("0".equals(smsEntityList.get(position).getSms_not_read())){
            viewHolder.sms_remind.setVisibility(View.INVISIBLE);
        }else {
            viewHolder.sms_remind.setText(smsEntityList.get(position).getSms_not_read());
        }

        return convertView;
    }


    public static class ViewHolder{
        private ImageView sms_image_id;
        private TextView sms_title;
        private TextView sms_content;
        private TextView sms_time;
        private TextView sms_remind;
    }
}
