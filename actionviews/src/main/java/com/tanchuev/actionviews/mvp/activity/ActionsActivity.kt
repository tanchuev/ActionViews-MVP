package com.tanchuev.actionviews.mvp.activity

import android.support.v7.app.AppCompatActivity
import android.view.View
import com.tanchuev.actionviews.mvp.R
import com.tanchuev.actionviews.mvp.utils.findViewByIdNullable
import com.tanchuev.actionviews.mvp.utils.mutableLazy
import com.tanchuev.actionviews.mvp.view.*
import com.tanchuev.actionviews.mvp.view.base.ActionsView
import com.tanchuev.actionviews.mvp.widget.ToastView

/**
 * @author tanchuev
 */

abstract class ActionsActivity : AppCompatActivity(), ActionsView {

    override var contentActionView: View by mutableLazy { findViewById<View>(R.id.contentView) }
    override var loadingActionView: LoadingView? by mutableLazy { findViewByIdNullable<View>(R.id.loadingView) as LoadingView? }
    override var noInternetActionView: NoInternetView? by mutableLazy { findViewByIdNullable<View>(R.id.noInternetView) as NoInternetView? }
    override var emptyContentActionView: EmptyContentView? by mutableLazy { findViewByIdNullable<View>(R.id.emptyContentView) as EmptyContentView? }
    override var errorActionView: ErrorView by mutableLazy { ToastView(this) }
}