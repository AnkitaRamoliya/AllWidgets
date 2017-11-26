package com.oozeetech.bizdesk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.oozeetech.bizdesk.R;
import com.oozeetech.bizdesk.utils.FontUtils;


public class DButtonMaterial extends android.support.v7.widget.AppCompatButton {

    public DButtonMaterial(Context context) {
        super(context);

        ButtonHelper.setTypeface(context, this);
    }

    public DButtonMaterial(Context context, AttributeSet attrs) {
        super(context, attrs);

        ButtonHelper.setTypeface(context, this, attrs);
    }

    public DButtonMaterial(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


        ButtonHelper.setTypeface(context, this, attrs);
    }

    public static class ButtonHelper {

        private static Typeface typeface = null;
        private static int type = 1;

        public static void setTypeface(Context context, TextView textView, AttributeSet attrs) {

            TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.DButton);
            try {
                type = ta.getInt(R.styleable.DButton_buttonFontFace, 1);

                typeface = FontUtils.fontName(context, type);


            } finally {
                ta.recycle();
            }


            textView.setTypeface(typeface);
        }

        public static void setTypeface(Context context, TextView textView) {

            if (typeface == null) {

                typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Regular.ttf");
            }

            textView.setTypeface(typeface);
        }

    }

}