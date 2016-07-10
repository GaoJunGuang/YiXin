package com.gjg.learn.yixin.friend;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gjg.learn.yixin.R;
import com.gjg.learn.yixin.entity.FriendEntity;

import java.util.List;

/**
 * Created by Junguang_gao on 2016/6/14.
 */
public class FriendContactAdapter extends BaseAdapter {
    private ViewHolder viewHolder;
    private Context context;
    private List<FriendEntity> friendEntityList;

    public FriendContactAdapter(Context context,List<FriendEntity> entityList){
        this.context=context;
        this.friendEntityList=entityList;
        FriendEntity entity=new FriendEntity("");
        friendEntityList.add(entity);

    }

    @Override
    public boolean isEnabled(int position) {
        //索引字母不能点击
        if(friendEntityList.get(position).getFriend_name().length()==1){
            return false;
        }
        return super.isEnabled(position);
    }

    @Override
    public int getCount() {
        return friendEntityList.size();
    }

    @Override
    public Object getItem(int position) {
        return friendEntityList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder=new ViewHolder();
        String item = friendEntityList.get(position).getFriend_name();
       // if(convertView==null){
            //字母背景颜色item
            if (item.length() == 1) {
                convertView = LayoutInflater.from(context).inflate(R.layout.friend_index_item, null);
                viewHolder.index = (TextView) convertView.findViewById(R.id.tv_character_index);
            } else {
                convertView = LayoutInflater.from(context).inflate(R.layout.friend_contact_item, null);
                viewHolder.iv = (ImageView) convertView.findViewById(R.id.iv_friend_contact);
                viewHolder.tv = (TextView) convertView.findViewById(R.id.tv_friend_contact);
            }
         //   convertView.setTag(viewHolder);

        /*}else {
            viewHolder= (ViewHolder) convertView.getTag();

        }*/
        if (item.length() == 1) {
            viewHolder.index.setText(friendEntityList.get(position).getFriend_name());
        } else {

            if(position==friendEntityList.size()-1){
                viewHolder.iv.setVisibility(View.INVISIBLE);
                viewHolder.tv.setText("共有好友"+friendEntityList.size()+"名");
                viewHolder.tv.setTextSize(9);
                viewHolder.tv.setGravity(Gravity.CENTER);
            }else {
                viewHolder.iv.setImageResource(friendEntityList.get(position).getFriend_image());
                viewHolder.tv.setText(friendEntityList.get(position).getFriend_name());
            }
        }

        return convertView;
    }

    private static class ViewHolder{
        private TextView index;
        private ImageView iv;
        private TextView tv;
    }
}
