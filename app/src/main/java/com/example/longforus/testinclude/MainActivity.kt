package com.example.longforus.testinclude

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.longforus.stateview.IStateView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),IMainListView {
    override var mPresenter: IMainListPresenter? = null

    override fun getContext(): Context {
        return this
    }


    override fun getStateView(): IStateView {
        return sv
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mPresenter =  MainListPresenterImpl(this)
        btn_empty.setOnClickListener {
            mPresenter?.onClick(3)
        }
        btn_success.setOnClickListener {
            mPresenter?.onClick(1)
        }
        btn_error.setOnClickListener {
            mPresenter?.onClick(2)
        }

    }
}
