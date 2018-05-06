package com.example.longforus.testinclude

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val successBean = ResultBean("0","success", ResultList(listOf("long","for","us")))
    val errorBean = ResultBean("1","net error",null)
    val emptyBean = ResultBean("0","success", ResultList(listOf()))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_empty.setOnClickListener {
            sv.setData(emptyBean)
        }
        btn_success.setOnClickListener {
            sv.setData(successBean)
        }
        btn_error.setOnClickListener {
            sv.setData(errorBean)
        }
        println("main ${rv.id}")
    }
}
