package com.ar4i.durak.presentation.game.views

import android.os.Bundle
import com.ar4i.durak.R
import com.ar4i.durak.presentation.base.views.BaseActivity
import com.ar4i.durak.presentation.game.presenter.GamePresenter
import javax.inject.Inject

class GameActivity : BaseActivity(), GameView {

    //==========================================start Fields============================================================

    @Inject
    lateinit var gamePresenter: GamePresenter

    //-------------------------------------------end Fields-------------------------------------------------------------


    //==========================================start Ui================================================================


    //-------------------------------------------end Ui-----------------------------------------------------------------


    //==========================================start Lifecycle=========================================================

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        gamePresenter.attachView(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        gamePresenter.detachView()
    }

    //-------------------------------------------end Lifecycle----------------------------------------------------------

    //==========================================start extends BaseActivity==============================================

    override fun getLayoutId(): Int {
        return R.layout.activity_game
    }

    override fun inject() {
        getComponent().injectGameActivity(this)
    }

    //-------------------------------------------end extends BaseActivity-----------------------------------------------
}
