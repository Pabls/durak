package com.ar4i.durak.presentation.base.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

abstract class BaseActivity : AppCompatActivity(), BaseMvpView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(getLayoutId())
    }

    //==========================================start implements BaseMvpView============================================

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    //-------------------------------------------end implements BaseMvpView---------------------------------------------


    //==========================================start Abstarct methods==================================================

    protected abstract fun getLayoutId(): Int

    //-------------------------------------------end Abstarct methods---------------------------------------------------

    //==========================================start Protected Methods==============================================

    protected fun actionComplete(): Boolean = true

    //-------------------------------------------end Protected Methods-----------------------------------------------

}
