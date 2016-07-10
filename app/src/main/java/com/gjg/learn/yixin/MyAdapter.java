package com.gjg.learn.yixin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Junguang_Gao on 2016/6/8.
 */
public class MyAdapter extends BaseAdapter{
    private List<MenuEntity> menus;
    private Context context;

    public MyAdapter(int[] images, int[] text, MenuActivity menuActivity) {
        context=menuActivity;
        menus=new ArrayList<MenuEntity>();
        for(int i=0;i<images.length;i++){
            MenuEntity menuEntity=new MenuEntity(images[i],text[i]);
            menus.add(menuEntity);
        }
    }

    @Override
    public int getCount() {
        return menus.size();
    }

    @Override
    public Object getItem(int position) {
        return menus.get(position);
    }

    @Override
    public long getItemId(int position) {
        return menus.get(position).getImageId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.menu_item, null);
            ImageView iv=(ImageView) convertView.findViewById(R.id.iv_menu_image);
            TextView tv=(TextView) convertView.findViewById(R.id.tv_menu_name);
            iv.setImageResource(menus.get(position).getImageId());
            tv.setText(menus.get(position).getFunctionId());

        }
        return convertView;
    }
}
