package com.tanchuev.actionviews.mvp.view

import android.support.annotation.StringRes
import com.tanchuev.actionviews.mvp.R
import com.tanchuev.actionviews.mvp.utils.isNullOrEmpty

/**
 * @author tanchuev
 */
interface ErrorView {
    fun showError(error: Throwable) {
        if (error.message.isNullOrEmpty()) showError(R.string.errorUnexpected) else showError(error.message!!)
    }

    fun showError(@StringRes errorMessageId: Int)
    fun showError(errorMessage: String)

    //метода hide нет, потому, что он не нужен.
    //скрытие view такого типа должно контролироваться на уровне view
}
