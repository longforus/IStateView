package com.longforus.stateview

interface IListBean<out T> {
    val list: List<T>
}