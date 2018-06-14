package com.tanchuev.actionviews.mvp.view


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
