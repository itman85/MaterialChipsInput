package com.pchmn.sample.materialchipsinput;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.appbar.AppBarLayout;

public class TrackableScrollingBehavior extends AppBarLayout.ScrollingViewBehavior {

    @Nullable
    private Runnable mOnStartScrollAction;

    public TrackableScrollingBehavior() {}

    public TrackableScrollingBehavior(final Context context, final AttributeSet attrs) {
        super(context, attrs);
    }

    public void setOnStartScrollAction(@NonNull final Runnable onStartScrollAction) {
        this.mOnStartScrollAction = onStartScrollAction;
    }

    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        if(mOnStartScrollAction != null) {
            mOnStartScrollAction.run();
        }

        return super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, axes, type);
    }
}
