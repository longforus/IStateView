package com.example.longforus.testinclude

import com.longforus.stateview.IStateBean

/**
 * @author XQ Yang
 * @date 5/6/2018  1:38 PM
 */
data class ResultBean(override val state: String, override val msg: String, override val data: ResultList?) : IStateBean<String, ResultList>