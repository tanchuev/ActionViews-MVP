package com.tanchuev.actionviews.mvp.view

import android.support.v4.widget.SwipeRefreshLayout
import android.view.View
import com.tanchuev.actionviews.mvp.utils.setVisibility

/**
 * @author tanchuev
 */
interface EmptyContentView {
    var isContentEmpty: Boolean

    fun setButtonClickListener(onClickListener: View.OnClickListener)

    fun setVisibility(visible: Boolean, contentView: View) {
        val view = this as View
        if (visible && isContentEmpty) {
            if (contentView !is SwipeRefreshLayout) {
                setVisibility(View.GONE, contentView)
            }
            setVisibility(View.VISIBLE, view)
        } else {
            setVisibility(View.GONE, view)
            setVisibility(View.VISIBLE, contentView)
        }
    }
}