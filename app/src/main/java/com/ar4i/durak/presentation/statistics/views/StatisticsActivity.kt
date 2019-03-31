package com.ar4i.durak.presentation.statistics.views

import com.ar4i.durak.R
import com.ar4i.durak.presentation.base.views.BaseActivity

class StatisticsActivity : BaseActivity(), StatisticsView {

    //==========================================start extends BaseActivity==============================================

    override fun getLayoutId(): Int {
        return R.layout.activity_statistics
    }

    //-------------------------------------------end extends BaseActivity-----------------------------------------------
}
