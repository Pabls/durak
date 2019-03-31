package com.ar4i.durak.presentation.base.presenter

import com.ar4i.durak.presentation.base.views.BaseMvpView
import io.reactivex.disposables.Disposable

interface MvpPresenter<V : BaseMvpView> {
    fun attachView(v: V?)
    fun detachView()
    fun getView(): V?
    fun track(disposable: Disposable)
}