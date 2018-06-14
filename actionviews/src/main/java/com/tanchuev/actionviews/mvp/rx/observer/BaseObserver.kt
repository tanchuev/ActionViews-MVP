package com.tanchuev.actionviews.mvp.rx.observer


import io.reactivex.functions.Action
import io.reactivex.functions.Consumer
import io.reactivex.observers.DisposableObserver

/**
 * @author tanchuev
 */
class BaseObserver<T> : DisposableObserver<T> {

    private var onNext: Consumer<in T>? = null
    private var onError: Consumer<Throwable>? = null
    private var onComplete: Action? = null

    constructor(onNext: ((T) -> Unit)? = null, onComplete: (() -> Unit)? = null, onError: ((Throwable) -> Unit)? = null) {
        if (onNext != null) {
            this.onNext = Consumer { onNext(it) }
        }
        if (onComplete != null) {
            this.onComplete = Action { onComplete() }
        }
        if (onError != null) {
            this.onError = Consumer { onError(it) }
        }
    }

    override fun onComplete() {
        try {
            onComplete?.run()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        dispose()
    }

    override fun onError(e: Throwable) {
        try {
            onError?.accept(e)
        } catch (ex: Exception) {
            ex.printStackTrace()
        }

        dispose()
    }

    override fun onNext(t: T) {
        try {
            onNext?.accept(t)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}
