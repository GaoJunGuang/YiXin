package com.gjg.learn.yixin.friend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gjg.learn.yixin.R;
import com.gjg.learn.yixin.entity.FunctionTabEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Junguang_gao on 2016/6/14.
 */
public class FriendFunctionTabAdapter extends BaseAdapter {
    private ViewHolder viewHolder;
    private Context context;
    private List<FunctionTabEntity> tabEntityList;

    private int[] images=new int[]{R.drawable.ic_add_friends,R.drawable.ic_push_friends};
    private int[] desc=new int[]{R.string.add_friends,R.string.new_friend};

    public FriendFunctionTabAdapter(Context context){
        this.context=context;
        initFunctionTabDatas();

    }

    private void initFunctionTabDatas() {
        tabEntityList=new ArrayList<FunctionTabEntity>();
        for (int i=0;i<images.length;i++){
            FunctionTabEntity functionTab=new FunctionTabEntity(images[i],context.getResources().getString(desc[i]));
            tabEntityList.add(functionTab);
        }
    }

    @Override
    public int getCount() {
        return tabEntityList.size();
    }

    @Override
    public Object getItem(int position) {
        return tabEntityList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return tabEntityList.get(position).getTab_image();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder=new ViewHolder();
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.friend_functiontab_item,null);
            viewHolder.iv= (ImageView) convertView.findViewById(R.id.iv_friend_function_tab);
            viewHolder.tv= (TextView) convertView.findViewById(R.id.tv_friend_tunction_tab);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder)convertView.getTag();
        }
        viewHolder.iv.setImageResource(tabEntityList.get(position).getTab_image());
        viewHolder.tv.setText(tabEntityList.get(position).getTab_function_desc());

        return convertView;
    }

    private class ViewHolder{
        ImageView iv;
        TextView tv;
    }
}
