package com.gjg.learn.yixin.friend;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.gjg.learn.yixin.R;
import com.gjg.learn.yixin.entity.FriendEntity;
import com.gjg.learn.yixin.util.StringHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by Junguang_gao on 2016/6/14.
 */
public class FriendFragment extends Fragment {
    private HashMap<String, Integer> selector;// 存放含有索引字母的位置
    private LinearLayout ll_index;
    private TextView tv_index;
    private FriendContactAdapter friendContactAdapter;
    private String[] indexStr = {"#", "A", "B", "C", "D", "E", "F", "G", "H",
            "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
            "V", "W", "X", "Y", "Z"};
    private List<FriendEntity> friends = null;
    private List<FriendEntity> newFriends = new ArrayList<FriendEntity>();
    private int height;// 字体高度
    private int height_linearlayout;
    private boolean flag = false;

    private ListView lv_friend_function_tab;
    private ListView lv_friend_contact;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.friend_fragment, container, false);


        lv_friend_function_tab = (ListView) view.findViewById(R.id.lv_friend_function_tab);
        FriendFunctionTabAdapter functionTabAdapter = new FriendFunctionTabAdapter(getActivity());
        lv_friend_function_tab.setAdapter(functionTabAdapter);
        //索引布局
        ll_index = (LinearLayout) view.findViewById(R.id.ll_index);
        ll_index.setBackgroundColor(Color.parseColor("#22dddddd"));
        ll_index.post(new Runnable() {
            @Override
            public void run() {
                height_linearlayout=ll_index.getHeight();
                Log.e("FriendFragment",height_linearlayout+"");
                height = height_linearlayout / indexStr.length;
                drawIndexView();

            }
        });
        /*ll_index.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                //ll_index.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                LinearLayout.LayoutParams layoutParams= (LinearLayout.LayoutParams) ll_index.getLayoutParams();
                height_linearlayout=layoutParams.height;
                Log.e("FriendFragment",height_linearlayout+"");
            }
        });*/

        //中间的字母
        tv_index = (TextView) view.findViewById(R.id.tv_index);
        tv_index.setVisibility(View.GONE);
        lv_friend_contact = (ListView) view.findViewById(R.id.lv_friend_contact);

        initContactDatas();
        String[] allContacts = getAfterSortData(friends);
        reSortList(allContacts);

        selector = new HashMap<String, Integer>();
        for (int j = 0; j < indexStr.length; j++) {// 循环字母表，找出newPersons中对应字母的位置
            for (int i = 0; i < newFriends.size(); i++) {
                if (newFriends.get(i).getFriend_name().equals(indexStr[j])) {
                    selector.put(indexStr[j], i);
                }
            }

        }

        friendContactAdapter = new FriendContactAdapter(getActivity(), newFriends);
        lv_friend_contact.setAdapter(friendContactAdapter);

        return view;
    }


   /* @Override
    public void onResume() {
        // 在oncreate里面执行下面的代码没反应，因为oncreate里面得到的getHeight=0
        if (!flag) {
            height = height_linearlayout / indexStr.length;
            Log.e("FriendFragment",height+"");
            Log.e("FriendFragment",indexStr.length+"");
            //drawIndexView();
            flag = true;
        }

        super.onResume();
    }*/

    /**
     * 绘制索引
     */
    private void drawIndexView() {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, height);
        for (int i = 0; i < indexStr.length; i++) {
            //绘制字母
            final TextView tv = new TextView(getActivity());
            tv.setLayoutParams(params);
            tv.setTextColor(Color.parseColor("#ff000000"));
            tv.setText(indexStr[i]);
            tv.setPadding(10, 0, 10, 0);
            ll_index.addView(tv);
            //点击字母事件
            ll_index.setOnTouchListener(new View.OnTouchListener() {

                @Override
                public boolean onTouch(View v, MotionEvent event)

                {
                    float y = event.getY();
                    int index = (int) (y / height);
                    if (index > -1 && index < indexStr.length) {// 防止越界
                        String key = indexStr[index];
                        if (selector.containsKey(key)) {
                            int pos = selector.get(key);
                            if (lv_friend_contact.getHeaderViewsCount() > 0) {// 防止ListView有标题栏，本例中没有。
                                lv_friend_contact.setSelectionFromTop(
                                        pos + lv_friend_contact.getHeaderViewsCount(), 0);
                            } else {
                                lv_friend_contact.setSelectionFromTop(pos, 0);// 滑动到第一项
                            }
                            tv_index.setVisibility(View.VISIBLE);
                            tv_index.setText(indexStr[index]);
                        } else {
                            //列表中对应的字母没有选项，就不可以点击
                            return true;
                        }
                    }
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            ll_index.setBackgroundColor(Color
                                    .parseColor("#606060"));
                            break;

                        case MotionEvent.ACTION_MOVE:

                            break;
                        case MotionEvent.ACTION_UP:
                            ll_index.setBackgroundColor(Color
                                    .parseColor("#00ffffff"));
                            tv_index.setVisibility(View.GONE);
                            break;
                    }
                    return true;
                }
            });
        }

    }


    /**
     * 重新排序获得新的list集合
     *
     * @param allContacts
     */
    private void reSortList(String[] allContacts) {
        for (int i = 0; i < allContacts.length; i++) {
            if (allContacts[i].length() != 1) {
                for (int j = 0; j < friends.size(); j++) {
                    if (allContacts[i].equals(friends.get(j).getPingyin_friend_name())) {
                        FriendEntity entity = new FriendEntity(friends.get(j).getFriend_name(),
                                friends.get(j).getPingyin_friend_name());
                        newFriends.add(entity);
                    }
                }
            } else {
                newFriends.add(new FriendEntity(R.drawable.head_protrait_guide_tips_icon, allContacts[i]));
            }
        }
    }

    /**
     * 获取排序后的新数据
     *
     * @param friends
     * @return
     */
    private String[] getAfterSortData(List<FriendEntity> friends) {
        //TreeSet有序，不能重复
        TreeSet<String> set = new TreeSet<String>();
        // 获取初始化数据源中的首字母，添加到set中
        for (FriendEntity contact : friends) {
            set.add(StringHelper.getPinYinHeadChar(contact.getFriend_name()).substring(
                    0, 1));
        }
        // 新数组的长度为原数据加上set的大小
        String[] names = new String[friends.size() + set.size()];
        int i = 0;

        for (String string : set) {
            names[i] = string;
            i++;
        }
        String[] pinYinNames = new String[friends.size()];
        for (int j = 0; j < friends.size(); j++) {
            friends.get(j).setPingyin_friend_name(
                    StringHelper.getPingYin(friends.get(j).getFriend_name().toString())
            );
            pinYinNames[j] = StringHelper.getPingYin(friends.get(j).getFriend_name().toString());
        }
        // 将原数据拷贝到新数据中
        System.arraycopy(pinYinNames, 0, names, set.size(), pinYinNames.length);
        // 自动按照首字母排序
        Arrays.sort(names, String.CASE_INSENSITIVE_ORDER);
        return names;
    }

    /**
     * 模拟数据
     */
    private void initContactDatas() {
        friends = new ArrayList<FriendEntity>();
        FriendEntity friend1 = new FriendEntity(R.drawable.head_protrait_guide_tips_icon, "高进");
        friends.add(friend1);
        FriendEntity friend2 = new FriendEntity(R.drawable.head_protrait_guide_tips_icon, "高标");
        friends.add(friend2);
        FriendEntity friend3 = new FriendEntity(R.drawable.head_protrait_guide_tips_icon, "Jagger");
        friends.add(friend3);
        FriendEntity friend4 = new FriendEntity(R.drawable.head_protrait_guide_tips_icon, "Ocean");
        friends.add(friend4);
        FriendEntity friend5 = new FriendEntity(R.drawable.head_protrait_guide_tips_icon, "王宝强");
        friends.add(friend5);
        FriendEntity friend6 = new FriendEntity(R.drawable.head_protrait_guide_tips_icon, "方冰冰");
        friends.add(friend6);
        FriendEntity friend7 = new FriendEntity(R.drawable.head_protrait_guide_tips_icon, "成龙");
        friends.add(friend7);
        FriendEntity friend8 = new FriendEntity(R.drawable.head_protrait_guide_tips_icon, "张馨予");
        friends.add(friend8);
        FriendEntity friend9 = new FriendEntity(R.drawable.head_protrait_guide_tips_icon, "张歆艺");
        friends.add(friend9);
        FriendEntity friend10 = new FriendEntity(R.drawable.head_protrait_guide_tips_icon, "乐嘉");
        friends.add(friend10);
        FriendEntity friend11 = new FriendEntity(R.drawable.head_protrait_guide_tips_icon, "汤唯");
        friends.add(friend11);
        FriendEntity friend12 = new FriendEntity(R.drawable.head_protrait_guide_tips_icon, "贺礼");
        friends.add(friend12);
        FriendEntity friend13 = new FriendEntity(R.drawable.head_protrait_guide_tips_icon, "凯盖");
        friends.add(friend13);
        FriendEntity friend14 = new FriendEntity(R.drawable.head_protrait_guide_tips_icon, "姚晨");
        friends.add(friend14);
        FriendEntity friend15 = new FriendEntity(R.drawable.head_protrait_guide_tips_icon, "Mike");
        friends.add(friend15);
        FriendEntity friend16 = new FriendEntity(R.drawable.head_protrait_guide_tips_icon, "马伊琍");
        friends.add(friend16);
        FriendEntity friend17 = new FriendEntity(R.drawable.head_protrait_guide_tips_icon, "柳岩");
        friends.add(friend17);
        FriendEntity friend18 = new FriendEntity(R.drawable.head_protrait_guide_tips_icon, "wendy");
        friends.add(friend18);
        FriendEntity friend19 = new FriendEntity(R.drawable.head_protrait_guide_tips_icon, "文章");
        friends.add(friend19);
        FriendEntity friend20 = new FriendEntity(R.drawable.head_protrait_guide_tips_icon, "胖子");
        friends.add(friend20);


    }
}
