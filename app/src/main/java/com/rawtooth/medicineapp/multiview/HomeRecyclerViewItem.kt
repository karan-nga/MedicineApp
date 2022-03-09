package com.rawtooth.medicineapp.multiview

sealed class HomeRecyclerViewItem {
    class Title(
        val type:String,
        val title:String
    ):HomeRecyclerViewItem()

    class Carsoul(
        val type:String,
        val title: String,
        val description:String,
        val time:String
    ):HomeRecyclerViewItem()
//    class TwoCard1(
//        val type:String,
//        val title: String,
//        val description: String
//    ):HomeRecyclerViewItem()
    class SingleCard(
        val type:String,
        val title: String
    ):HomeRecyclerViewItem()

}