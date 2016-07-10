package com.gjg.learn.yixin.me;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.gjg.learn.yixin.R;
import com.gjg.learn.yixin.RecycleViewDivider;
import com.gjg.learn.yixin.entity.MeEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Junguang_Gao on 2016/7/6.
 */
public class MeFragment extends Fragment {
    private RecyclerView recyclerView;
    private MeAdapter meAdapter;
    private List<MeEntity> meEntityList;

    private int[] images=new int[]{
            R.drawable.prize_center_icon,R.drawable.my_bank_card_icon,
            R.drawable.sticker_module_icon,R.drawable.my_favorite_icon,
            R.drawable.my_agenda_icon,R.drawable.my_setting_icon
    };
    private String[] titleNames=new String[]{
            "奖励中心","易信钱包",
            "表情商店","我的收藏",
            "代办任务","设置"
    };
    private int[] ishasmsg=new int[]{
            0,1,
            0,0,
            0,0
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=LayoutInflater.from(getActivity()).inflate(R.layout.me_fragment,container,false);
        recyclerView= (RecyclerView) view.findViewById(R.id.rv_me);
        initDatas();
        meAdapter=new MeAdapter(getActivity(),meEntityList);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(meAdapter);
        recyclerView.addItemDecoration(new RecycleViewDivider(getActivity(),LinearLayoutManager.VERTICAL));
        meAdapter.setOnItemClickListener(new MeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getActivity(),meEntityList.get(position).getTitle()+"",Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }

    private void initDatas() {
        meEntityList=new ArrayList<MeEntity>();
        for (int i=0;i<titleNames.length;i++){
            MeEntity entity=new MeEntity(images[i],titleNames[i],ishasmsg[i]);
            meEntityList.add(entity);
        }

    }
}
