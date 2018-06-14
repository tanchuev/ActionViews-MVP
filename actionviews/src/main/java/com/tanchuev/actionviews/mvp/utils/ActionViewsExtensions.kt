package com.tanchuev.actionviews.mvp.utils

import android.view.View
import com.tanchuev.actionviews.mvp.R
import com.tanchuev.actionviews.mvp.view.*
import com.tanchuev.actionviews.mvp.view.base.ActionsView
import io.reactivex.*
import io.reactivex.Observable
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.util.*

/**
 * Created by tanchuev
 */

val NETWORK_EXCEPTIONS = listOf(
    UnknownHostException::class,
    SocketTimeoutException::class,
    ConnectException::class
)

// region WITH DO ON ACTION
fun <T> Observable<T>.withActionViews(
    view: ActionsView,
    contentView: View = view.contentActionView,
    loadingView: LoadingView? = view.loadingActionView,
    noInternetView: NoInternetView? = view.noInternetActionView,
    emptyContentView: EmptyContentView? = view.emptyContentActionView,
    errorView: ErrorView = view.errorActionView,
    doOnLoadStart: () -> Unit = { doOnLoadSubscribe(contentView, loadingView) },
    doOnLoadEnd: () -> Unit = { doOnLoadComplete(contentView, loadingView) },
    doOnStartNoInternet: () -> Unit = { doOnNoInternetSubscribe(contentView, noInternetView) },
    doOnNoInternet: (Throwable) -> Unit = { doOnNoInternet(contentView, errorView, noInternetView) },
    doOnStartEmptyContent: () -> Unit = { doOnEmptyContentSubscribe(contentView, emptyContentView) },
    doOnEmptyContent: () -> Unit = { doOnEmptyContent(contentView, errorView, emptyContentView) },
    doOnError: (Throwable) -> Unit = { doOnError(errorView, it) }
) =
    subscribeOnBackground()
        .observeOnMain()
        .withErrorView(
            doOnStartNoInternet,
            doOnNoInternet,
            doOnStartEmptyContent,
            doOnEmptyContent,
            doOnError
        ).withLoadingView(doOnLoadStart, doOnLoadEnd)

fun <T> Flowable<T>.withActionViews(
    view: ActionsView,
    contentView: View = view.contentActionView,
    loadingView: LoadingView? = view.loadingActionView,
    noInternetView: NoInternetView? = view.noInternetActionView,
    emptyContentView: EmptyContentView? = view.emptyContentActionView,
    errorView: ErrorView = view.errorActionView,
    doOnLoadStart: () -> Unit = { doOnLoadSubscribe(contentView, loadingView) },
    doOnLoadEnd: () -> Unit = { doOnLoadComplete(contentView, loadingView) },
    doOnStartNoInternet: () -> Unit = { doOnNoInternetSubscribe(contentView, noInternetView) },
    doOnNoInternet: (Throwable) -> Unit = { doOnNoInternet(contentView, errorView, noInternetView) },
    doOnStartEmptyContent: () -> Unit = { doOnEmptyContentSubscribe(contentView, emptyContentView) },
    doOnEmptyContent: () -> Unit = { doOnEmptyContent(contentView, errorView, emptyContentView) },
    doOnError: (Throwable) -> Unit = { doOnError(errorView, it) }
) = subscribeOnBackground()
    .observeOnMain()
    .withErrorView(
        doOnStartNoInternet,
        doOnNoInternet,
        doOnStartEmptyContent,
        doOnEmptyContent,
        doOnError
    ).withLoadingView(doOnLoadStart, doOnLoadEnd)

fun <T> Single<T>.withActionViews(
    view: ActionsView,
    contentView: View = view.contentActionView,
    loadingView: LoadingView? = view.loadingActionView,
    noInternetView: NoInternetView? = view.noInternetActionView,
    emptyContentView: EmptyContentView? = view.emptyContentActionView,
    errorView: ErrorView = view.errorActionView,
    doOnLoadStart: () -> Unit = { doOnLoadSubscribe(contentView, loadingView) },
    doOnLoadEnd: () -> Unit = { doOnLoadComplete(contentView, loadingView) },
    doOnStartNoInternet: () -> Unit = { doOnNoInternetSubscribe(contentView, noInternetView) },
    doOnNoInternet: (Throwable) -> Unit = { doOnNoInternet(contentView, errorView, noInternetView) },
    doOnStartEmptyContent: () -> Unit = { doOnEmptyContentSubscribe(contentView, emptyContentView) },
    doOnEmptyContent: () -> Unit = { doOnEmptyContent(contentView, errorView, emptyContentView) },
    doOnError: (Throwable) -> Unit = { doOnError(errorView, it) }
) = subscribeOnBackground()
    .observeOnMain()
    .withErrorView(
        doOnStartNoInternet,
        doOnNoInternet,
        doOnStartEmptyContent,
        doOnEmptyContent,
        doOnError
    ).withLoadingView(doOnLoadStart, doOnLoadEnd)

fun <T> Maybe<T>.withActionViews(
    view: ActionsView,
    contentView: View = view.contentActionView,
    loadingView: LoadingView? = view.loadingActionView,
    noInternetView: NoInternetView? = view.noInternetActionView,
    emptyContentView: EmptyContentView? = view.emptyContentActionView,
    errorView: ErrorView = view.errorActionView,
    doOnLoadStart: () -> Unit = { doOnLoadSubscribe(contentView, loadingView) },
    doOnLoadEnd: () -> Unit = { doOnLoadComplete(contentView, loadingView) },
    doOnStartNoInternet: () -> Unit = { doOnNoInternetSubscribe(contentView, noInternetView) },
    doOnNoInternet: (Throwable) -> Unit = { doOnNoInternet(contentView, errorView, noInternetView) },
    doOnStartEmptyContent: () -> Unit = { doOnEmptyContentSubscribe(contentView, emptyContentView) },
    doOnEmptyContent: () -> Unit = { doOnEmptyContent(contentView, errorView, emptyContentView) },
    doOnError: (Throwable) -> Unit = { doOnError(errorView, it) }
) = subscribeOnBackground()
    .observeOnMain()
    .withErrorView(
        doOnStartNoInternet,
        doOnNoInternet,
        doOnStartEmptyContent,
        doOnEmptyContent,
        doOnError
    ).withLoadingView(doOnLoadStart, doOnLoadEnd)

fun Completable.withActionViews(
    view: ActionsView,
    contentView: View = view.contentActionView,
    loadingView: LoadingView? = view.loadingActionView,
    noInternetView: NoInternetView? = view.noInternetActionView,
    emptyContentView: EmptyContentView? = view.emptyContentActionView,
    errorView: ErrorView = view.errorActionView,
    doOnLoadStart: () -> Unit = { doOnLoadSubscribe(contentView, loadingView) },
    doOnLoadEnd: () -> Unit = { doOnLoadComplete(contentView, loadingView) },
    doOnStartNoInternet: () -> Unit = { doOnNoInternetSubscribe(contentView, noInternetView) },
    doOnNoInternet: (Throwable) -> Unit = { doOnNoInternet(contentView, errorView, noInternetView) },
    doOnStartEmptyContent: () -> Unit = { doOnEmptyContentSubscribe(contentView, emptyContentView) },
    doOnEmptyContent: () -> Unit = { doOnEmptyContent(contentView, errorView, emptyContentView) },
    doOnError: (Throwable) -> Unit = { doOnError(errorView, it) }
) = subscribeOnBackground()
    .observeOnMain()
    .withErrorView(
        doOnStartNoInternet,
        doOnNoInternet,
        doOnStartEmptyContent,
        doOnEmptyContent,
        doOnError
    ).withLoadingView(doOnLoadStart, doOnLoadEnd)
// endregion WITH DO ON ACTIONS

// region DO ON LOAD
fun <T> Observable<T>.withLoadingView(
    doOnLoadStart: () -> Unit,
    doOnLoadEnd: () -> Unit
): Observable<T> =
    doOnSubscribe { doOnLoadStart() }
        .doFinally { doOnLoadEnd() }

fun <T> Flowable<T>.withLoadingView(
    doOnLoadStart: () -> Unit,
    doOnLoadEnd: () -> Unit
): Flowable<T> =
    doOnSubscribe { doOnLoadStart() }
        .doFinally { doOnLoadEnd() }

fun <T> Single<T>.withLoadingView(
    doOnLoadStart: () -> Unit,
    doOnLoadEnd: () -> Unit
): Single<T> =
    doOnSubscribe { doOnLoadStart() }
        .doFinally { doOnLoadEnd() }

fun <T> Maybe<T>.withLoadingView(
    doOnLoadStart: () -> Unit,
    doOnLoadEnd: () -> Unit
): Maybe<T> =
    doOnSubscribe { doOnLoadStart() }
        .doFinally { doOnLoadEnd() }

fun Completable.withLoadingView(
    doOnLoadStart: () -> Unit,
    doOnLoadEnd: () -> Unit
): Completable =
    doOnSubscribe { doOnLoadStart() }
        .doFinally { doOnLoadEnd() }

private fun doOnLoadSubscribe(contentView: View, loadingView: LoadingView?) {
    loadingView?.setVisibility(true, contentView)
}

private fun doOnLoadComplete(contentView: View, loadingView: LoadingView?) {
    loadingView?.setVisibility(false, contentView)
}
// endregion DO ON LOAD

// region DO ON ERROR
fun <T> Observable<T>.withErrorView(
    doOnStartNoInternet: () -> Unit,
    doOnNoInternet: (Throwable) -> Unit,
    doOnStartEmptyContent: () -> Unit,
    doOnEmptyContent: () -> Unit,
    doOnError: (Throwable) -> Unit
): Observable<T> =
    doOnSubscribe {
        doOnStartNoInternet()
        doOnStartEmptyContent()
    }.flatMap {
        if (it.isNullOrEmpty()) {
            emptyObservable(doOnEmptyContent)
        } else this
    }.doOnError {
        when {
            it::class in NETWORK_EXCEPTIONS -> {
                doOnNoInternet(it)
            }
            it is NoSuchElementException -> {
                doOnEmptyContent()
            }
            else -> doOnError(it)
        }
    }

fun <T> Flowable<T>.withErrorView(
    doOnStartNoInternet: () -> Unit,
    doOnNoInternet: (Throwable) -> Unit,
    doOnStartEmptyContent: () -> Unit,
    doOnEmptyContent: () -> Unit,
    doOnError: (Throwable) -> Unit
): Flowable<T> =
    doOnSubscribe {
        doOnStartNoInternet()
        doOnStartEmptyContent()
    }.flatMap {
        if (it.isNullOrEmpty()) {
            emptyFlowable(doOnEmptyContent)
        } else this
    }.doOnError {
        when {
            it::class in NETWORK_EXCEPTIONS -> {
                doOnNoInternet(it)
            }
            it is NoSuchElementException -> {
                doOnEmptyContent()
            }
            else -> doOnError(it)
        }
    }

fun <T> Single<T>.withErrorView(
    doOnStartNoInternet: () -> Unit,
    doOnNoInternet: (Throwable) -> Unit,
    doOnStartEmptyContent: () -> Unit,
    doOnEmptyContent: () -> Unit,
    doOnError: (Throwable) -> Unit
): Single<T> =
    doOnSubscribe {
        doOnStartNoInternet()
        doOnStartEmptyContent()
    }
        .doOnError {
            when {
                it::class in NETWORK_EXCEPTIONS -> {
                    doOnNoInternet(it)
                }
                it is NoSuchElementException -> {
                    doOnEmptyContent()
                }
                else -> doOnError(it)
            }
        }
        .flatMap {
            if (it.isNullOrEmpty()) {
                throw NoSuchElementException()
            } else this
        }

fun <T> Maybe<T>.withErrorView(
    doOnStartNoInternet: () -> Unit,
    doOnNoInternet: (Throwable) -> Unit,
    doOnStartEmptyContent: () -> Unit,
    doOnEmptyContent: () -> Unit,
    doOnError: (Throwable) -> Unit
): Maybe<T> =
    doOnSubscribe {
        doOnStartNoInternet()
        doOnStartEmptyContent()
    }
        .doOnError {
            when {
                it::class in NETWORK_EXCEPTIONS -> {
                    doOnNoInternet(it)
                }
                it is NoSuchElementException -> {
                    doOnEmptyContent()
                }
                else -> doOnError(it)
            }
        }
        .flatMap {
            if (it.isNullOrEmpty()) {
                throw NoSuchElementException()
            } else this
        }

fun Completable.withErrorView(
    doOnStartNoInternet: () -> Unit,
    doOnNoInternet: (Throwable) -> Unit,
    doOnStartEmptyContent: () -> Unit,
    doOnEmptyContent: () -> Unit,
    doOnError: (Throwable) -> Unit
): Completable =
    doOnSubscribe {
        doOnStartNoInternet()
        doOnStartEmptyContent()
    }.doOnError {
        when {
            it::class in NETWORK_EXCEPTIONS -> {
                doOnNoInternet(it)
            }
            it is NoSuchElementException -> {
                doOnEmptyContent()
            }
            else -> doOnError(it)
        }
    }

private fun doOnError(
    errorView: ErrorView,
    t: Throwable
) {
    errorView.showError(t)
}
// endregion DO ON ERROR

// region DO ON NO INTERNET
private fun doOnNoInternetSubscribe(contentView: View, noInternetView: NoInternetView?) {
    noInternetView?.setVisibility(false, contentView)
}

private fun doOnNoInternet(contentView: View, errorView: ErrorView, noInternetView: NoInternetView?) {
    if (noInternetView != null) {
        noInternetView.setVisibility(true, contentView)
    } else {
        errorView.showError(R.string.errorNoInternet)
    }
}
// endregion DO ON NO INTERNET

// region DO ON EMPTY CONTENT
private fun doOnEmptyContentSubscribe(contentView: View, emptyContentView: EmptyContentView?) {
    emptyContentView?.setVisibility(false, contentView)
}

private fun doOnEmptyContent(contentView: View, errorView: ErrorView, emptyContentView: EmptyContentView?) {
    if (emptyContentView != null) {
        emptyContentView.setVisibility(true, contentView)
    } else {
        errorView.showError(R.string.errorEmptyContent)
    }
}

private fun <T> emptyObservable(doOnEmptyContent: () -> Unit): Observable<T> =
    Observable.create(ObservableOnSubscribe<T> { it.onComplete() })
        .doFinally { doOnEmptyContent() }

private fun <T> emptyFlowable(doOnEmptyContent: () -> Unit): Flowable<T> =
    Flowable.create(FlowableOnSubscribe<T> { it.onComplete() }, BackpressureStrategy.BUFFER)
        .doFinally { doOnEmptyContent() }
// endregion DO ON EMPTY CONTENT