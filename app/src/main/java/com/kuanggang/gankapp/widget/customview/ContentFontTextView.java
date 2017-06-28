package com.kuanggang.gankapp.widget.customview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.kuanggang.gankapp.GankApp;

/**
 * @author KG on 2017/6/7.
 */

public class ContentFontTextView extends AppCompatTextView {

    public ContentFontTextView(Context context) {
        super(context);
        init();
    }

    public ContentFontTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ContentFontTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setTypeface(GankApp.contentTf);
    }
}
