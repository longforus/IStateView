package com.longforus.stateview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import kotlinx.android.synthetic.main.layout_empty_view.view.*
import kotlinx.android.synthetic.main.layout_error_view.view.*
import kotlinx.android.synthetic.main.view_state_layout.view.*

/**
 *
 * @author  XQ Yang
 * @date 5/6/2018  12:23 PM
 */
class StateView(context: Context,attrs: AttributeSet? = null):FrameLayout(context,attrs),IStateView{

    override var bindView: View? = null
    private val emptyLayout:View by lazy {
        val view = vs_empty.inflate()
        tv_empty.text = emptyMsg
        view
    }
    private val errorLayout:View by lazy {
        val view = vs_error.inflate()
        tv_error.text = errorMsg
        view
    }
    override var emptyMsg: String = "這里什么也没有噢!ヾ(･ω･`｡)"
    override var errorMsg: String= "怎么回事,出错了!(⊙_⊙)?"
    override var onSeateChanged: ((Int) -> Unit)? = null
    override var curState: Int = STATE_EMPTY

    override fun showSuccess() {
        hideAll()
        bindView?.visibility = View.VISIBLE
        curState = STATE_SUCCESS
        onSeateChanged?.invoke(STATE_SUCCESS)
    }

    var bindViewId = 0

    override fun showError(msg: String?) {
        hideAll()
        msg?.let {
            tv_error.text = it
        }
        errorLayout.visibility = View.VISIBLE
        curState = STATE_ERROR
        onSeateChanged?.invoke(STATE_ERROR)
    }

    override fun showEmpty(msg: String?) {
        hideAll()
        msg?.let {
            tv_empty.text = it
        }
        emptyLayout.visibility = View.VISIBLE
        curState = STATE_EMPTY
        onSeateChanged?.invoke(STATE_EMPTY)
    }

    override fun <T, DATA : IListBean<T>> getState(bean: IStateBean<T, DATA>?): Int {
        return if (bean?.isOk() ==true) {
            if (bean.data?.list == null || bean.data!!.list.isEmpty()) STATE_EMPTY else STATE_SUCCESS
        } else {
            STATE_ERROR
        }
    }

    override fun <T, DATA : IListBean<T>> setData(bean: IStateBean<T, DATA>?) {
        when (getState(bean)) {
            STATE_SUCCESS->showSuccess()
            STATE_EMPTY->showEmpty()
            STATE_ERROR->showError()
        }
    }

    private fun hideAll(){
        if (bindView == null) {
            bindView = findViewById(bindViewId)
        }
        bindView?.visibility = View.GONE
        emptyLayout.visibility = View.GONE
        errorLayout.visibility = View.GONE
    }

    init {
        LayoutInflater.from(context).inflate(R.layout.view_state_layout,this,true)
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.StateView)
        bindViewId =  attributes.getResourceId(R.styleable.StateView_bindId, -1)
        attributes.recycle()
    }
}