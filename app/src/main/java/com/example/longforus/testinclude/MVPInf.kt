package com.example.longforus.testinclude

import android.content.Context
import com.longforus.stateview.IStateView

/**
 *
 * @author  XQ Yang
 * @date 5/6/2018  8:15 PM
 */

interface IView<P:ITopPresenter>:ITopView{
    var mPresenter:P?

}

interface IListView<P:ITopPresenter>:IView<P>{
    fun getStateView():IStateView
}

interface ITopView{
    fun getContext():Context
}

interface IPresenter<V:ITopView,M:ITopModel>:ITopPresenter{
    val mView:V
    val mModel:M
    override fun getContext(): Context {
        return mView.getContext()
    }
}

interface ITopPresenter{
    fun getContext():Context
}

interface IModel<P:ITopPresenter>:ITopModel{
    val mPresenter:P
}

interface ITopModel


interface IMainListView:IListView<IMainListPresenter>

interface IMainListPresenter:IPresenter<IMainListView,IMainListModel> {
    fun onClick(i: Int)
}

interface IMainListModel:IModel<IMainListPresenter> {
    fun getData(i: Int): ResultBean?
}