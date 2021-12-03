package com.example.library.newproject_cicerone.ui.ui.base

interface IListPresenter<V: IItemView> {

    var itemClickListener: ((V) -> Unit)?

    fun getCount(): Int

    fun bindView(view: V)
}