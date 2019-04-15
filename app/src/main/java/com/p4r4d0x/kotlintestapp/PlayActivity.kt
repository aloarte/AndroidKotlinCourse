package com.p4r4d0x.kotlintestapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_play.*

class PlayActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)

        btn_submit?.setOnClickListener { writeInputOnET()}

    }

    private fun writeInputOnET() {
        tv_submit.append(et_submit?.text)
    }

    override fun onResume() {
        super.onResume()

    }
}
