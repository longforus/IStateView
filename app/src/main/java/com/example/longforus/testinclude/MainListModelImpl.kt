package com.example.longforus.testinclude

/**
 *
 * @author  XQ Yang
 * @date 5/6/2018  8:26 PM
 */

class MainListModelImpl(override val mPresenter: IMainListPresenter) : IMainListModel {
    override fun getData(i: Int): ResultBean? {
        return when (i) {
            1 -> successBean
            2 -> errorBean
            3 -> emptyBean
            else -> {
                null
            }
        }
    }

    val successBean = ResultBean("0", "success", ResultList(listOf("long", "for", "us")))
    val errorBean = ResultBean("1", "net error", null)
    val emptyBean = ResultBean("0", "success", ResultList(listOf()))
}