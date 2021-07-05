package com.miserydx.compose58.model

 class HouseListItemBean(
    val picUrl: String,
    val title: String,
    val huxing: String,
    val area: String,
    val dictName: String,
    val lastLocal: String,
    val centerImg: String?,
    val usedTages: String,
    var price: String,
    val priceUnit: String,
    val recommendReason: RecommendReason?,
    val distanceDict: String?,
)

data class RecommendReason(
    val text: String,
    val leftIcon: String? = null,
)