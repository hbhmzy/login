package com.example.test;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Administrator on 2018/2/5.
 */

@SuppressLint("AppCompatCustomView")
public class DelEdittext extends EditText {
    private Context mcontext;
    private Drawable imgClear;
    private Drawable imguser;

    public DelEdittext(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mcontext = context;
        init();
    }

    private void init() {
        imgClear = mcontext.getResources().getDrawable(R.drawable.delete1);
        imguser= mcontext.getResources().getDrawable(R.drawable.name);
        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                setDrawable();

            }

        });

    }

    private void setDrawable() {
        if (length() < 1)
            setCompoundDrawablesWithIntrinsicBounds(imguser, null, null, null);
        else
            setCompoundDrawablesWithIntrinsicBounds(imguser, null, imgClear, null);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            if (getCompoundDrawables()[2] != null) {
                boolean touchable = event.getX() > (getWidth() - getTotalPaddingRight())
                        && (event.getX() < ((getWidth() - getPaddingRight())));

                if (touchable) {
                    this.setText("");
                }
            }
            this.setFocusable(true);
            this.setFocusableInTouchMode(true);
            this.requestFocus();
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}

