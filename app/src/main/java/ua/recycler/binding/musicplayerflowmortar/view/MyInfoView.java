package ua.recycler.binding.musicplayerflowmortar.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import flow.Flow;

/**
 * Created by Andrii Papai on 31.10.2017.
 */

public class MyInfoView extends FrameLayout {
    public MyInfoView(@NonNull Context context) {
        super(context);
    }

    public MyInfoView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyInfoView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        TrackInfo info = Flow.getKey(this);
    }
}
