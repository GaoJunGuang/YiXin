package com.gjg.learn.yixin.sms;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

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
public class SmsFragment extends Fragment implements AdapterView.OnItemClickListener {
    private ListView lv_sms_fragment;

    private List<SmsEntity> smsEntityList;

    private int[] sms_image_ids=new int[]{
            R.drawable.head_default_file,R.drawable.head_default_mail,
            R.drawable.head_default_meetfold,R.drawable.head_default_pafold,
            R.drawable.head_default_public,R.drawable.head_default_team_ent,
            R.drawable.head_default_file,R.drawable.head_default_mail,
            R.drawable.head_default_meetfold,R.drawable.head_default_pafold,
            R.drawable.head_default_public,R.drawable.head_default_team_ent
    };

    private String[] sms_titles=new String[]{
            "易信快传","163邮箱提醒","私密消息","公众号","易信团队","好友消息",
            "易信快传","163邮箱提醒","私密消息","公众号","易信团队","好友消息"
    };
    private String[] sms_contents=new String[]{
            "易信快传，速度是非一般的快，你值得试一试！",
            "9.9包邮，全国包邮，亲，包括港澳台地区哦，快来体验吧！",
            "您好，您的私密消息已经存储起来了，请赶快阅读。",
            "您关注的公众号发来新的消息，请及时查看。",
            "易新群才是你最长情的告白。",
            "胡歌请求加你为好友，请确认。",
            "易信快传，速度是非一般的快，你值得试一试！",
            "9.9包邮，全国包邮，亲，包括港澳台地区哦，快来体验吧！",
            "您好，您的私密消息已经存储起来了，请赶快阅读。",
            "您关注的公众号发来新的消息，请及时查看。",
            "易新群才是你最长情的告白。",
            "胡歌请求加你为好友，请确认。"
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.sms_fragment,container,false);
        lv_sms_fragment= (ListView) view.findViewById(R.id.lv_sms_fragment);

        initSmsDatas(sms_image_ids,sms_titles,sms_contents);

        SmsFragmentAdapter smsFragmentAdapter=new SmsFragmentAdapter(smsEntityList,getActivity());
        lv_sms_fragment.setAdapter(smsFragmentAdapter);
        lv_sms_fragment.setOnItemClickListener(this);
        return view;
    }

    private void initSmsDatas(int[] images,String[] titles,String[] contents) {
        smsEntityList=new ArrayList<SmsEntity>();
        Random random=new Random();
        Date date=new Date();
        long date_long=date.getTime();
        DateFormat format1=new SimpleDateFormat("yyyy-MM-dd");
        DateFormat format2=new SimpleDateFormat("MM-dd hh:mm");

        for(int i=0;i<titles.length;i++){
            String time;
            if(i%3==0){
                time=format1.format(date);
            }else {
                date_long+=random.nextLong();
                time=format2.format(date_long);
            }

            SmsEntity sms=new SmsEntity(images[i],titles[i],contents[i],time,random.nextInt(4)+"");
            smsEntityList.add(sms);
        }
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent=new Intent(getActivity(),SmsDetailActivity.class);
        String sms_title=smsEntityList.get(position).getSms_title();
        intent.putExtra("sms_title",sms_title);
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.activity_in, R.anim.activity_out);

    }
}
