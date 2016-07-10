package com.gjg.learn.yixin.found;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.ViewDragHelper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gjg.learn.yixin.R;
import com.gjg.learn.yixin.RecycleViewDivider;
import com.gjg.learn.yixin.entity.FoundEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Junguang_Gao on 2016/6/22.
 */
public class FoundFragment extends Fragment {
    private RecyclerView recyclerView;
    private FoundAdapter foundAdapter;
    private List<FoundEntity> list;
    private int[] images=new int[]{
            R.drawable.application_friend_icon,R.drawable.application_star_shop_icon,
            R.drawable.application_show_icon,R.drawable.application_meet_icon,
            R.drawable.application_bobo_icon,R.drawable.application_teamsquare_icon,
            R.drawable.application_ask_icon,R.drawable.application_game_icon,
            R.drawable.application_mail_icon,R.drawable.application_enterprise_icon,
            R.drawable.application_game_ad_icon,R.drawable.application_worldcup_icon,
            R.drawable.application_scan_icon,R.drawable.application_more_icon
    };
    private String[] titles=new String[]{
            "朋友圈","星币商城",
            "晒一晒","偶遇",
            "靓直播","群广场",
            "问一问","游戏",
            "邮件","娱乐",
            "游戏广告","欧洲杯",
            "扫一扫","更多"
    };
    private String[] desc=new String[]{
            "","金色星期三：抢购千份流量",
            "我要上封面！招募脚力达人","附近有5170位帅哥美女",
            "海量美女帅哥视频直播","就这样被你撩到了！",
            "你听过最假的一句话是？","玩捕鱼，拿拍立得，50元话费等你拿哦！",
            "","这里有你最想玩的，快来尝试下吧！",
            "","海量欧洲杯精彩赛事等你看！",
            "","",
    };

    private String[] other=new String[]{
            "","64星币",
            "","",
            "","",
            "","",
            "","",
            "","",
            "","",
    };
    private String[] type=new String[]{
            "0","2",
            "2","1",
            "1","1",
            "1","1",
            "0","1",
            "0","1",
            "0","0",
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=LayoutInflater.from(getActivity()).inflate(R.layout.found_fragment,container,false);
        recyclerView= (RecyclerView) view.findViewById(R.id.rv_found);
        initDatas();
        foundAdapter=new FoundAdapter(getActivity(),list);
        LinearLayoutManager linear=new LinearLayoutManager(getActivity());
        linear.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linear);
        recyclerView.setAdapter(foundAdapter);
        recyclerView.addItemDecoration(new RecycleViewDivider(getActivity(), LinearLayoutManager.VERTICAL));
        return view;
    }

    private void initDatas() {
        list=new ArrayList<FoundEntity>();
        for(int i=0;i<images.length;i++){
            FoundEntity entity=new FoundEntity(images[i],titles[i],desc[i],other[i],type[i]);
            list.add(entity);
        }

    }
}
