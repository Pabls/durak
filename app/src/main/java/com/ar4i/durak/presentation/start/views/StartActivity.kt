package com.ar4i.durak.presentation.start.views

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.ar4i.durak.R
import com.ar4i.durak.presentation.base.views.BaseActivity
import com.ar4i.durak.presentation.game.views.GameActivity
import com.ar4i.durak.presentation.start.presenter.StartPresenter
import com.ar4i.durak.presentation.statistics.views.StatisticsActivity
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.Observable
import javax.inject.Inject

class StartActivity : BaseActivity(), StartView {

    //==========================================start Fields============================================================

    @Inject
    lateinit var startPresenter : StartPresenter

    //-------------------------------------------end Fields-------------------------------------------------------------

    //==========================================start Ui================================================================

    lateinit var btnStartGame: Button
    lateinit var btnShowStatistics: Button

    //-------------------------------------------end Ui-----------------------------------------------------------------

    //==========================================start Lifecycle=========================================================

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.btnStartGame = findViewById(R.id.btn_new_game)
        this.btnShowStatistics = findViewById(R.id.btn_statistics)
        this.startPresenter.attachView(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        this.startPresenter.detachView()
    }

    //-------------------------------------------end Lifecycle----------------------------------------------------------


    //==========================================start extends BaseActivity==============================================

    override fun getLayoutId(): Int {
        return R.layout.activity_start
    }

    override fun inject() {
        getComponent().injectStartActivity(this)
    }

    //-------------------------------------------end extends BaseActivity-----------------------------------------------


    //==========================================start implements StartView==============================================

    override fun onStartGameButtonClick(): Observable<Boolean> {
        return RxView.clicks(this.btnStartGame).map { actionComplete() }
    }

    override fun onShowStatisticsButtonClick(): Observable<Boolean> {
        return RxView.clicks(this.btnShowStatistics).map { actionComplete() }
    }

    override fun navigateToNewGameActivity() {
        startActivity(Intent(this, GameActivity::class.java))
    }

    override fun navigateToStatisticsActivity() {
        startActivity(Intent(this, StatisticsActivity::class.java))
    }

    //-------------------------------------------end implements StartView-----------------------------------------------


}
