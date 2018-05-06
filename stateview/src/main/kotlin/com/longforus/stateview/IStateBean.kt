package com.longforus.stateview

interface IStateBean<out T, out DATA : IListBean<T>> {
    val state: String
    val msg: String
    val data: DATA?
    fun isOk(): Boolean = "0" == state
}