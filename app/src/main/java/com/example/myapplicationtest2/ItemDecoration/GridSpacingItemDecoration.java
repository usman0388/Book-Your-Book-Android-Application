package com.example.myapplicationtest2.ItemDecoration;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

    private int mSpanCount;
    private float mItemSize;

    public GridSpacingItemDecoration(int spanCount, int itemSize) {
        this.mSpanCount = spanCount;
        mItemSize = itemSize;
    }

    @Override
    public void getItemOffsets(final Rect outRect, final View view, RecyclerView parent,
                               RecyclerView.State state) {
        final int position = parent.getChildLayoutPosition(view);
        final int column = position % mSpanCount;
        final int parentWidth = parent.getWidth();
        int spacing = (int) (parentWidth - (mItemSize * mSpanCount)) / (mSpanCount + 1);
        outRect.left = spacing - column * spacing / mSpanCount;
        outRect.right = (column + 1) * spacing / mSpanCount;

        if (position < mSpanCount) {
            outRect.top = spacing;
        }
        outRect.bottom = spacing;
    }
}