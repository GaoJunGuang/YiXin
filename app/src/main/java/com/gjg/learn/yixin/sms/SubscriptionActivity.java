package com.gjg.learn.yixin.sms;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

import com.gjg.learn.yixin.R;

/**
 * Created by Junguang_Gao on 2016/6/15.
 */
public class SubscriptionActivity extends Activity implements View.OnClickListener {
    private ImageButton ib_back;
    private ImageButton ib_more;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.sms_subscription_activity);
        initView();

    }

    private void initView() {
        ib_back= (ImageButton) this.findViewById(R.id.ib_sms_subscription_back);
        ib_back.setOnClickListener(this);
        ib_more= (ImageButton) this.findViewById(R.id.ib_sms_subscription_more);
        ib_more.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ib_sms_subscription_back:
                finish();
                break;
            case R.id.ib_sms_subscription_more:

                break;
        }
    }
}
