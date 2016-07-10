package com.gjg.learn.yixin.me;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gjg.learn.yixin.R;
import com.gjg.learn.yixin.entity.MeEntity;

import java.util.List;

/**
 * Created by Junguang_Gao on 2016/7/7.
 */
public class MeAdapter extends RecyclerView.Adapter<MeAdapter.ViewHolder> {
    private Context context;
    private List<MeEntity> list;

    public MeAdapter(Context context,List<MeEntity> list){
        this.context=context;
        this.list=list;

    }

    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }
    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener=mOnItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.me_recyclerview_item,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.imageView.setImageResource(list.get(position).getImage());
        holder.textView_title.setText(list.get(position).getTitle());
        if(list.get(position).getIsHaveNewMessage()==1){
            holder.iv_hasmsg.setVisibility(View.VISIBLE);
        }
        if(mOnItemClickListener!=null){
            holder.textView_title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos=holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.textView_title,pos);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return list==null ? 0 : list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView_title;
        private ImageView iv_hasmsg;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.iv_me_image);
            textView_title= (TextView) itemView.findViewById(R.id.tv_me_title);
            iv_hasmsg= (ImageView) itemView.findViewById(R.id.iv_me_hasmsg);
        }
    }
}
