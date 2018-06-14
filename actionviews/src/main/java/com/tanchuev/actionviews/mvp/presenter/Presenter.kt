package com.tanchuev.actionviews.mvp.presenter

import com.tanchuev.actionviews.mvp.view.HasActionViews

/**
 * @author tanchuev
 */
abstract class Presenter {
    abstract val view: HasActionViews
}
