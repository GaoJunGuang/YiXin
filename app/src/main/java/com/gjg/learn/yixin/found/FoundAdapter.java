package com.gjg.learn.yixin.found;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gjg.learn.yixin.R;
import com.gjg.learn.yixin.entity.FoundEntity;

import java.util.List;

/**
 * Created by Junguang_Gao on 2016/7/6.
 */
public class FoundAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<FoundEntity> foundEntityList;

    //建立枚举 2个item 类型
    public enum ITEM_TYPE {
        ITEM1, ITEM2, ITEM3
    }

    public FoundAdapter(Context context, List<FoundEntity> foundEntityList) {
        this.context = context;
        this.foundEntityList = foundEntityList;

    }

    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }
    private OnItemClickListener mOnItemCLickListener;

    public void setOnItemClickListener(OnItemClickListener listener){
        this.mOnItemCLickListener=listener;
    }

    @Override
    public int getItemViewType(int position) {

        if (foundEntityList.get(position).getFound_item_type().equals("0")) {
            return ITEM_TYPE.ITEM1.ordinal();
        } else if (foundEntityList.get(position).getFound_item_type().equals("1")) {
            return ITEM_TYPE.ITEM2.ordinal();
        } else {
            return ITEM_TYPE.ITEM3.ordinal();
        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_TYPE.ITEM1.ordinal()) {
            return new MyViewHolder1(LayoutInflater.from(context).inflate(R.layout.found_item3, parent, false));
        } else if (viewType == ITEM_TYPE.ITEM2.ordinal()) {
            return new MyViewHolder2(LayoutInflater.from(context).inflate(R.layout.found_item1, parent, false));
        } else {
            return new MyViewHolder3(LayoutInflater.from(context).inflate(R.layout.found_item2, parent, false));
        }

    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder1) {
            ((MyViewHolder1) holder).iv_image.setImageResource(foundEntityList.get(position).getFound_image());
            ((MyViewHolder1) holder).tv_title.setText(foundEntityList.get(position).getFound_title());
            if(mOnItemCLickListener!=null){

                ((MyViewHolder1) holder).tv_title.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos=((MyViewHolder1)holder).getLayoutPosition();
                        mOnItemCLickListener.onItemClick(((MyViewHolder1) holder).tv_title,pos);
                    }
                });

            }

        } else if (holder instanceof MyViewHolder2) {
            ((MyViewHolder2) holder).iv_image.setImageResource(foundEntityList.get(position).getFound_image());
            ((MyViewHolder2) holder).tv_title.setText(foundEntityList.get(position).getFound_title());
            ((MyViewHolder2) holder).tv_desc.setText(foundEntityList.get(position).getFound_desc());
            if(mOnItemCLickListener!=null){

                ((MyViewHolder2) holder).tv_title.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos=((MyViewHolder2)holder).getLayoutPosition();
                        mOnItemCLickListener.onItemClick(((MyViewHolder2) holder).tv_title,pos);
                    }
                });

            }
        }else{
            ((MyViewHolder3) holder).iv_image.setImageResource(foundEntityList.get(position).getFound_image());
            ((MyViewHolder3) holder).tv_title.setText(foundEntityList.get(position).getFound_title());
            ((MyViewHolder3) holder).tv_desc.setText(foundEntityList.get(position).getFound_desc());
            ((MyViewHolder3) holder).tv_other.setText(foundEntityList.get(position).getFound_other());
            if(mOnItemCLickListener!=null){

                ((MyViewHolder3) holder).tv_title.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos=((MyViewHolder3)holder).getLayoutPosition();
                        mOnItemCLickListener.onItemClick(((MyViewHolder3) holder).tv_title,pos);
                    }
                });

            }
        }


    }

    @Override
    public int getItemCount() {
        return foundEntityList == null ? 0 : foundEntityList.size();
    }

    public class MyViewHolder1 extends RecyclerView.ViewHolder {
        private ImageView iv_image;
        private TextView tv_title;

        public MyViewHolder1(View itemView) {
            super(itemView);
            iv_image = (ImageView) itemView.findViewById(R.id.iv_found_image);
            tv_title = (TextView) itemView.findViewById(R.id.tv_found_title);
        }
    }

    public class MyViewHolder2 extends RecyclerView.ViewHolder {
        private ImageView iv_image;
        private TextView tv_title;
        private TextView tv_desc;

        public MyViewHolder2(View itemView) {
            super(itemView);
            iv_image = (ImageView) itemView.findViewById(R.id.iv_found_image);
            tv_title = (TextView) itemView.findViewById(R.id.tv_found_title);
            tv_desc = (TextView) itemView.findViewById(R.id.tv_found_desc);
        }
    }

    public class MyViewHolder3 extends RecyclerView.ViewHolder {
        private ImageView iv_image;
        private TextView tv_title;
        private TextView tv_desc;
        private TextView tv_other;

        public MyViewHolder3(View itemView) {
            super(itemView);
            iv_image = (ImageView) itemView.findViewById(R.id.iv_found_image);
            tv_title = (TextView) itemView.findViewById(R.id.tv_found_title);
            tv_desc = (TextView) itemView.findViewById(R.id.tv_found_desc);
            tv_other = (TextView) itemView.findViewById(R.id.tv_other);
        }
    }
}
