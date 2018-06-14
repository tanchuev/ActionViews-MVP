package com.tanchuev.actionviews.mvp.view.base

import com.tanchuev.actionviews.mvp.view.EmptyContentView
import com.tanchuev.actionviews.mvp.view.ErrorView
import com.tanchuev.actionviews.mvp.view.LoadingView
import com.tanchuev.actionviews.mvp.view.NoInternetView


/**
 * @author tanchuev
 */
interface HasActionViews {
    var contentActionView: android.view.View
    var loadingActionView: LoadingView?
    var noInternetActionView: NoInternetView?
    var emptyContentActionView: EmptyContentView?
    var errorActionView: ErrorView
}
