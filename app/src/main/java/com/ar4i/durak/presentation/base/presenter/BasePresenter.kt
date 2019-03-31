package com.ar4i.durak.presentation.base.presenter

import com.ar4i.durak.presentation.base.views.BaseMvpView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BasePresenter<V : BaseMvpView> : MvpPresenter<V> {

    //==========================================start Fields============================================================

    private var view: V? = null
    private var compositeDisposable: CompositeDisposable? = null

    //-------------------------------------------end Fields-------------------------------------------------------------

    //==========================================start implements MvpPresenter<V>========================================

    override fun attachView(v: V?) {
        this.view = v
        this.compositeDisposable = CompositeDisposable()
    }

    override fun detachView() {
        this.view = null
        this.compositeDisposable?.dispose()
        this.compositeDisposable = null
    }

    override fun getView(): V? {
        return this.view
    }

    override fun track(disposable: Disposable) {
        this.compositeDisposable?.add(disposable)
    }

    //-------------------------------------------end implements MvpPresenter<V>-----------------------------------------

}