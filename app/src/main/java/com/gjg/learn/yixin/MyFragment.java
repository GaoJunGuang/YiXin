package com.gjg.learn.yixin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Junguang_Gao on 2016/6/10.
 */
public class MyFragment extends Fragment {
    private int pageNum;
    private TextView tv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View pager = inflater.inflate(R.layout.pager_fragment, container, false);

        tv = (TextView) pager.findViewById(R.id.tv);
        Bundle bundle = getArguments();
        pageNum = bundle.getInt("page_num");
        tv.setText("第" + pageNum+"页：内容...");
        tv.setTextSize(30);
        return pager;
    }
}
