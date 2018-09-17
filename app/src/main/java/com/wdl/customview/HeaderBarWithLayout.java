package com.wdl.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * author：   wdl
 * time： 2018/9/17 16:27
 * des：    TODO
 */
public class HeaderBarWithLayout extends FrameLayout {
    private Boolean isShowBack;
    private String titleText;
    private String rightText;

    public HeaderBarWithLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.HeaderBarWithLayout);

        isShowBack = typedArray.getBoolean(R.styleable.HeaderBarWithLayout_isShowBack, false);
        titleText = typedArray.getString(R.styleable.HeaderBarWithLayout_titleText);
        rightText = typedArray.getString(R.styleable.HeaderBarWithLayout_rightText);

        typedArray.recycle();
        View view = View.inflate(context, R.layout.layout_header_bar, this);
        view.findViewById(R.id.mLeftIv).setVisibility(isShowBack ? VISIBLE : GONE);
        TextView title = view.findViewById(R.id.mTitleTv);
        title.setText(titleText);
        TextView right = view.findViewById(R.id.mRightTv);
        right.setText(rightText);
        right.setVisibility(TextUtils.isEmpty(rightText)?GONE:VISIBLE);
    }
}
