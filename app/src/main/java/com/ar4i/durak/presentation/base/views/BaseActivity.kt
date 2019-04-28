package com.ar4i.durak.presentation.base.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ar4i.durak.app.App
import com.ar4i.durak.app.di.components.AppComponent

abstract class BaseActivity : AppCompatActivity(), BaseMvpView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        inject()

        setContentView(getLayoutId())

    }

    //==========================================start implements BaseMvpView============================================

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    //-------------------------------------------end implements BaseMvpView---------------------------------------------


    //==========================================start Abstarct methods==================================================

    protected abstract fun getLayoutId(): Int

    protected abstract fun inject()

    //-------------------------------------------end Abstarct methods---------------------------------------------------

    //==========================================start Protected Methods==============================================

    protected fun actionComplete(): Boolean = true

    protected fun getComponent(): AppComponent {
        var aaa = App.appComponent
        return aaa
    }

    //-------------------------------------------end Protected Methods-----------------------------------------------

}
