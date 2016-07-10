package com.gjg.learn.yixin.phone;

import android.app.AlertDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.gjg.learn.yixin.R;
import com.gjg.learn.yixin.entity.ContactsEntity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by Junguang_Gao on 2016/6/10.
 */
public class PhoneFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener, AdapterView.OnItemClickListener {

    private SwipeRefreshLayout mRefreshLayout;
    private ListView lv;
    private ContactAdapter contactAdapter;
    private List<ContactsEntity> entityList;
    private FrameLayout fl_phone_circle;
    private TextView tv_phone_circle_image1;
    private TextView tv_phone_circle_image2;
    private TextView tv_phone_circle_image3;
    private TextView tv_phone_circle_image4;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.phone_fragment, container, false);

        mRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.refresh_layout);
        mRefreshLayout.setOnRefreshListener(this);
        mRefreshLayout.setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        initView(view);
        initDatas();
        contactAdapter = new ContactAdapter(getActivity(), entityList);
        lv.setAdapter(contactAdapter);
        lv.setOnItemClickListener(this);
        return view;
    }

    private void initView(View view) {
        lv = (ListView) view.findViewById(R.id.lv);
        fl_phone_circle = (FrameLayout) view.findViewById(R.id.fl_phone_circle);
        tv_phone_circle_image1 = (TextView) view.findViewById(R.id.tv_phone_circle_image1);
        tv_phone_circle_image2 = (TextView) view.findViewById(R.id.tv_phone_circle_image2);
        tv_phone_circle_image3 = (TextView) view.findViewById(R.id.tv_phone_circle_image3);
        tv_phone_circle_image4 = (TextView) view.findViewById(R.id.tv_phone_circle_image4);

    }

    private int[] image_id = new int[]{
            R.drawable.phone_record_in_call,
            R.drawable.phone_record_miss_call,
            R.drawable.phone_record_out_call

    };
    private String[] names = new String[]{
            "17003637147", "mike", "back", "王江",
            "15327387678", "杜红", "杨乐", "liz",
            "17058937147", "百丽", "黄花鱼", "合亮江",
            "18897387678", "浮士德", "二维", "qa"

    };

    private String[] numbers = new String[]{
            "17003637147", "17704377147", "18203633247", "13734237147",
            "15327387678", "15303446147", "13708794347", "18903632701",
            "17058937147", "17021217156", "17003456147", "15902137767",
            "18897387678", "18703658147", "17005437547", "18801237358"

    };

    private void initDatas() {
        fl_phone_circle.setVisibility(View.INVISIBLE);
        entityList = new ArrayList<ContactsEntity>();
        Random random = new Random();
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        for (int i = 0; i < names.length; i++) {
            ContactsEntity entity = new ContactsEntity(image_id[random.nextInt(3)], names[i], numbers[i], format.format(date));
            entityList.add(entity);
        }

    }

    @Override
    public void onRefresh() {
        mRefreshLayout.setRefreshing(true);
        new Handler().postDelayed(new Runnable() {
            public void run() {

                mRefreshLayout.setRefreshing(false);//设置为false后进度圈消失，若为true则会一直存在

                View view = LayoutInflater.from(getActivity()).inflate(R.layout.phone_contacts_top_circle, null);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

                ContactsEntity contact1 = entityList.get(new Random().nextInt(entityList.size()));
                tv_phone_circle_image1.setText(contact1.getPhoneNumber().substring(7, 10));
                Random rand = new Random();
                int pos = rand.nextInt(entityList.size());
                ContactsEntity contact2 = entityList.get(pos);
                if (contact2.getName().length() == 11) {
                    tv_phone_circle_image2.setText(contact2.getName().substring(7, 10));
                } else {
                    tv_phone_circle_image2.setText(contact2.getName());
                }
                ContactsEntity contact3 = entityList.get(new Random().nextInt(entityList.size()));
                if (contact3.getName().length() == 11) {
                    tv_phone_circle_image3.setText(contact3.getName().substring(7, 10));
                } else {
                    tv_phone_circle_image3.setText(contact3.getName());
                }
                ContactsEntity contact4 = entityList.get(new Random().nextInt(entityList.size()));
                if (contact4.getName().length() == 11) {
                    tv_phone_circle_image4.setText(contact4.getName().substring(7, 10));
                } else {
                    tv_phone_circle_image4.setText(contact4.getName());
                }

                fl_phone_circle.setVisibility(View.VISIBLE);

                //contactAdapter.notifyDataSetChanged();

            }
        }, 2000);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        CustomDialog.Builder dialog = new CustomDialog.Builder(getActivity());
        View dialog_layout = LayoutInflater.from(getActivity()).inflate(R.layout.phone_dialog1, null);
        TextView tv_name = (TextView) dialog_layout.findViewById(R.id.tv_phone_contact_name);
        tv_name.setText(entityList.get(position).getName());

        dialog.create(dialog_layout).show();


    }
}
