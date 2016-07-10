package com.gjg.learn.yixin.phone;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gjg.learn.yixin.R;
import com.gjg.learn.yixin.entity.ContactsEntity;

import java.util.List;

/**
 * Created by Junguang_Gao on 2016/6/20.
 */
public class ContactAdapter extends BaseAdapter {
    private ViewHolder viewHolder;
    private List<ContactsEntity> list;
    private Context context;
    public ContactAdapter(Context context,List<ContactsEntity> list) {
        this.context=context;
        this.list=list;

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getViewTypeCount() {
        return super.getViewTypeCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder=new ViewHolder();
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.phone_contacts_item,null);
            viewHolder.imageView= (ImageView) convertView.findViewById(R.id.iv_phone_record_image);
            viewHolder.textView_name= (TextView) convertView.findViewById(R.id.tv_phone_record_name);
            viewHolder.textView_num= (TextView) convertView.findViewById(R.id.tv_phone_record_num);
            viewHolder.textView_time= (TextView) convertView.findViewById(R.id.tv_phone_record_time);

            convertView.setTag(viewHolder);

        }
        else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        final ContactsEntity contactsEntity=list.get(position);

        ImageView iv_opreate= (ImageView) convertView.findViewById(R.id.iv_phone_record_opreate);
        iv_opreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context,contactsEntity.getName(),Toast.LENGTH_LONG).show();
                showOperateDialog(v,contactsEntity);
            }
        });


        viewHolder.imageView.setImageResource(contactsEntity.getIsPlayInto());
        if(contactsEntity.getName().length()==11){
            viewHolder.textView_name.setTextColor(Color.RED);
            viewHolder.textView_name.setText(contactsEntity.getPhoneNumber());
            viewHolder.textView_num.setText("未存储号码");
        }else {
            viewHolder.textView_name.setTextColor(Color.BLACK);
            viewHolder.textView_name.setText(contactsEntity.getName());
            viewHolder.textView_num.setText(contactsEntity.getPhoneNumber());
        }

        viewHolder.textView_time.setText(contactsEntity.getTime());
        return convertView;
    }

    private void showOperateDialog(View v,ContactsEntity entity) {

        CustomDialog.Builder dialog=new CustomDialog.Builder(context);
        View dialog_layout;
        if(entity.getName().length()==11){
            //陌生号码，弹出添加对话框
            dialog_layout=LayoutInflater.from(context).inflate(R.layout.phone_dialog_stranger,null);
            TextView tv_num= (TextView) dialog_layout.findViewById(R.id.tv_phone_stranger_num);
            TextView tv_time= (TextView) dialog_layout.findViewById(R.id.tv_phone_stranger_time);
            tv_num.setText(entity.getName());
            tv_time.setText(entity.getTime());

        }else{
            //有记录的联系人，弹出呼叫对话框
            dialog_layout=LayoutInflater.from(context).inflate(R.layout.phone_dialog_contacts,null);
            TextView tv_name= (TextView) dialog_layout.findViewById(R.id.tv_phone_contact_record_name);
            TextView tv_time= (TextView) dialog_layout.findViewById(R.id.tv_phone_contact_time);
            TextView tv_num= (TextView) dialog_layout.findViewById(R.id.tv_phone_contact_number);
            tv_name.setText(entity.getName());
            tv_num.setText(entity.getPhoneNumber());
            tv_time.setText(entity.getTime());

        }


        dialog.create(dialog_layout).show();


    }

    private class ViewHolder{
        private ImageView imageView;
        private TextView textView_name;
        private TextView textView_num;
        private TextView textView_time;
    }
}
