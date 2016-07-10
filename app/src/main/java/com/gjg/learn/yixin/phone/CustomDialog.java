package com.gjg.learn.yixin.phone;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gjg.learn.yixin.R;

/**
 * Created by Junguang_Gao on 2016/6/21.
 */
public class CustomDialog extends Dialog {
    public CustomDialog(Context context) {
        super(context);
    }

    public CustomDialog(Context context, int theme) {
        super(context, theme);
    }




    public static class Builder{
        private Context context;
        private String title;
        private String message;
        private String positiveButtonText;
        private String negativeButtonText;
        private View contentView;
        private DialogInterface.OnClickListener positiveButtonClickListener;
        private DialogInterface.OnClickListener negativeButtonClickListener;

        public Builder(Context context){
            this.context=context;
        }
        public Builder setMessage(String message){
            this.message=message;
            return this;
        }
        public Builder setMessage(int message){
            this.message= (String) context.getText(message);
            return this;
        }

        public Builder setTitle(String title){
            this.message=message;
            return this;
        }

        public Builder setTitle(int title){
            this.title= (String) context.getText(title);
            return this;
        }

        public Builder setContentView(View view){
            this.contentView= view;
            return this;
        }

        public Builder setPositiveButton(int positiveButtonText,
                                         DialogInterface.OnClickListener listener) {
            this.positiveButtonText = (String) context
                    .getText(positiveButtonText);
            this.positiveButtonClickListener = listener;
            return this;
        }

        public Builder setPositiveButton(String positiveButtonText,
                                         DialogInterface.OnClickListener listener) {
            this.positiveButtonText = positiveButtonText;
            this.positiveButtonClickListener = listener;
            return this;
        }

        public Builder setNegativeButton(int negativeButtonText,
                                         DialogInterface.OnClickListener listener) {
            this.negativeButtonText = (String) context
                    .getText(negativeButtonText);
            this.negativeButtonClickListener = listener;
            return this;
        }

        public Builder setNegativeButton(String negativeButtonText,
                                         DialogInterface.OnClickListener listener) {
            this.negativeButtonText = negativeButtonText;
            this.negativeButtonClickListener = listener;
            return this;
        }

        public CustomDialog create(View view_layout) {
            CustomDialog dialog = new CustomDialog(context,R.style.phone_dialog_style);
            View layout = view_layout;
            //dialog.setCancelable(false);//点击dialog外和返回键都不关闭dialog
            dialog.setCanceledOnTouchOutside(false);//点击dialog外不关闭dialog,点击返回键关闭dialog
            dialog.setContentView(layout);
            return dialog;
        }



    }
}
