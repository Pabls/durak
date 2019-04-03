package com.ar4i.durak.presentation.start.views

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.ar4i.durak.R
import com.ar4i.durak.presentation.base.views.BaseActivity
import com.ar4i.durak.presentation.game.views.GameActivity
import com.ar4i.durak.presentation.statistics.views.StatisticsActivity
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.Observable

class StartActivity : BaseActivity(), StartView {

    //==========================================start Ui================================================================

    lateinit var btnStartGame: Button
    lateinit var btnShowStatistics: Button

    //-------------------------------------------end Ui-----------------------------------------------------------------

    //==========================================start Lifecycle=========================================================

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.btnStartGame = findViewById(R.id.btn_new_game)
        this.btnShowStatistics = findViewById(R.id.btn_statistics)
    }


    //-------------------------------------------end Lifecycle----------------------------------------------------------


    //==========================================start extends BaseActivity==============================================

    override fun getLayoutId(): Int {
        return R.layout.activity_start
    }

    //-------------------------------------------end extends BaseActivity-----------------------------------------------


    //==========================================start implements StartView==============================================

    override fun onStartGameButtonClick(): Observable<Boolean> {
        return RxView.clicks(this.btnStartGame).map { _ -> actionComplete() }
    }

    override fun onShowStatisticsButtonClick(): Observable<Boolean> {
        return RxView.clicks(this.btnShowStatistics).map { _ ->  actionComplete() }
    }

    override fun navigateToNewGameActivity() {
        startActivity(Intent(this, GameActivity::class.java))
    }

    override fun navigateToStatisticsActivity() {
        startActivity(Intent(this, StatisticsActivity::class.java))
    }

    //-------------------------------------------end implements StartView-----------------------------------------------


}
