package com.example.longforus.testinclude

/**
 *
 * @author  XQ Yang
 * @date 5/6/2018  8:24 PM
 */
class MainListPresenterImpl(override val mView: IMainListView) :IMainListPresenter{
    override fun onClick(i: Int) {
        mView.getStateView().setData(mModel.getData(i))
    }

    override val mModel: IMainListModel = MainListModelImpl(this)


}